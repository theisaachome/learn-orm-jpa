## Four type of Mapping

- One to One
- Many to One
- One to Many
- Many to Many

---

## 2 Category

### Single

- One to One
- Many to One
  - 2 Strategies
  - JoinColumn and Join Table
  - By Default Join Column is Created but we can create joinTable.

### Collection

- One to Many (Join Table Created By Default)
- Many to Many

---

## One-to-One Relationship in JPA

### Using a Foreign Key

Let's have a look at the following ER diagram, which represents a foreign key-based one-to-one mapping:

<image src="https://www.baeldung.com/wp-content/uploads/2018/12/1-1_FK.png" />

In this example, the address_id column in users is the foreign key to address.

### Implementing With a Foreign Key in JPA

First, let's create the User class and annotate it appropriately:

```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    //...
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // ... getters and setters
}
```

Note that we place the `@OneToOne` annotation on the related entity field, Address.

Also, we need to place the `@JoinColumn` annotation to configure the name of the column in the users table that maps to the primary key in the address table.  
If we don't provide a name, Hibernate will follow some rules to select a default one.

```java
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    //...

    @OneToOne(mappedBy = "address")
    private User user;
    //... getters and setters
}
```

---

## Using a Shared Primary Key

### Modeling With a Shared Primary Key

In this strategy, instead of creating a new column address_id, we'll mark the primary key column (user_id) of the address table as the foreign key to the users table:

<img src="https://www.baeldung.com/wp-content/uploads/2018/12/1-1-SK.png"/>

## Implementing With a Shared Primary Key in JPA

```java
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    //...

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    //... getters and setters
}
```

```java
@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "user_id")
    private Long id;

    //...

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    //... getters and setters
}
```

The mappedBy attribute is now moved to the User class since the foreign key is now present in the address table.  
We've also added the **@PrimaryKeyJoinColumn annotation, which indicates that the primary key of the User entity is used as the foreign key value for the associated Address entity**.

We still have to define an @Id field in the Address class. But note that this references the user_id column, and it no longer uses the @GeneratedValue annotation.

Also, on the field that references the User, we've added the **@MapsId** annotation, which indicates that the primary key values will be copied from the User entity.
