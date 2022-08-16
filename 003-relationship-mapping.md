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

```java

```
