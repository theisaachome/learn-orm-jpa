# Basic Entity Mappingg

## Class Level Mapping

- `@Table()`
- `@SecondaryTable`
- `@SecondaryTables`

## `@Table()` Annotation

Example

```java
@Entity
@Table(name = "student_tbl")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String address;
  // omit getter and setter
}
```

## `@SecondaryTable()` Annotation

Example

```java

@Entity
@Table(name = "student_tbl")
@SecondaryTable(name="email_tbl")
public class Student implements Serializable {
	@Id
	private Long id;
	private String name;
	@Column(table = "email_tbl")
	private String email;
	private String phone;
	private String address;
}
```

## `@SecondaryTables()` Annotation

```java
@Entity
@Table(name = "student_tbl")
@SecondaryTables({
   @SecondaryTable(name = "email_tbl"),
    @SecondaryTable(name = "phone_tbl") })
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;
	@Column(table = "email_tbl")
	private String email;
	@Column(table = "phone_tbl")
	private String phone;
	private String address;
}
```

---

## Real World Example SecondaryTable

Mapping a Single Entity to Multiple Tables in JPA.

Let's say we run a restaurant, and we want to store data about every meal we serve:

- Name
- Description
- Price

  What kind of allergens it contains
  Since there are many possible allergens, we're going to group this data set together.

```java
@Entity
@Table(name = "meal")
@SecondaryTable(name = "allergens", pkJoinColumns = @PrimaryKeyJoinColumn(name = "meal_id"))
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "peanuts", table = "allergens")
	private boolean peanuts;

	@Column(name = "celery", table = "allergens")
	private boolean celery;

	@Column(name = "sesame_seeds", table = "allergens")
	private boolean sesameSeeds;
}
```

---

## Combining @SecondaryTable With @Embedded

```java
@Entity
@Table(name = "meal")
@SecondaryTable(name = "allergens", pkJoinColumns = @PrimaryKeyJoinColumn(name = "meal_id"))
class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private Long id;

    @Column(name = "name")
   private String name;

    @Column(name = "description")
   private String description;

    @Column(name = "price")
   private BigDecimal price;

    @Embedded
    private Allergens allergens;

    // standard getters and setters

}


@Embeddable
public class Allergens {
    @Column(name = "peanuts", table = "allergens")
    private boolean peanuts;

    @Column(name = "celery", table = "allergens")
    private boolean celery;

    @Column(name = "sesame_seeds", table = "allergens")
    private boolean sesameSeeds;

    // standard getters and setters
}

```
