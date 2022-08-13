# Identifiers in Hibernate/JPA

## Simple Identifiers

The most straightforward way to define an identifier is by using the `@Id` annotation.

Simple ids are mapped using `@Id` to a single property of one of these types: Java primitive and primitive wrapper types, String, Date, BigDecimal and BigInteger.

```java
@Entity
public class Student {
    @Id
    private long studentId;
    private String name;
}
```

---

## Generated Identifiers

we can add the @GeneratedValue annotation.
This can use four generation types: AUTO, IDENTITY, SEQUENCE and TABLE.

---

## Sequence Generator

```java

@Entity
@Table(name = "course_tbl")
@SequenceGenerator(name = "course_seq",initialValue = 100,allocationSize = 1)
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
	private Long id;
	private String name;
	private double price;
}
```
