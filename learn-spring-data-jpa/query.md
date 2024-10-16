
# Sort your Query Results


- You often need to get your query results in a specific order.
- Using Spring Data JPA, you have several options to do that. 
- We discussed how to define static ORDER BY clauses in some of the previous lectures. 
- Let‘s quickly refresh that before we take a look at Spring Data JPA‘s dynamic sorting feature.


## Static Order By

- If you’re using a derived query, you can include the keyword OrderBy followed by one or more attribute names and the sorting direction in your method name.
- Spring Data JPA then adds an ORDER BY clause when it generates the query.

And if you use the @Query annotation to define a custom query, you are providing the statement yourself. In that statement, you can, of course, include an ORDER BY clause.

In both cases, you’re defining the result’s order at development time and can’t adapt it to different use cases or based on user input.



## Dynamic Sorting
Spring Data JPA also supports dynamic sorting. If you add a parameter of type Sort to your repository method, you can define the sorting at runtime, and Spring Data JPA generates the required ORDER BY clause.

## The Sort class
The Sort class provides a set of static methods that you can use to define the sorting of your query result. Before we look at an example, I want to point out 2 limitations:

- You can only sort by attributes of entity classes used in the query or by aliases defined in your query. If you want to sort by a more complex expression, you need to use a different class, which I will show you later in this lecture.
- And because Spring Data JPA needs to parse and extend your query, you can’t use it with native SQL queries.

Ok, let’s take a look at an example.

## Code Sample
If your repository interface extends Spring Data JPA’s PagingAndSortingRepository or JpaRepostory interface, your repository already offers some methods with a parameter of type Sort. One of them is the findAll method that I use in this test case.

```java
@Test
public void sortByName() {
    log.info("... sortByName ...");
 
    Sort sort = Sort.by("lastName").ascending();
    List<ChessPlayer> players = playerRepo.findAll(sort);
    assertThat(players.size()).isEqualTo(19);
     
    for (ChessPlayer player : players) {
        log.info(player.getLastName() + ", " + player.getFirstName()); 
    }
}
```
The Sort class implements a fluid API that you can use to define your sorting based on String references to attribute names or aliases used in the query statement.
In this case, I reference an attribute with the name lastName and specify an ascending sorting direction. When I use that object as a parameter of the findAll method of my ChessPlayerRepository, Spring Data JPA generates a query that returns all players in the ascending order of their last name.

```java
@Test
public void sortByMethodReference() {
    log.info("... sortByMethodReference ...");
 
    Sort sort = Sort.sort(ChessPlayer.class).by(ChessPlayer::getLastName).ascending();
    List<ChessPlayer> players = playerRepo.findByName("%a%", sort);
    assertThat(players.size()).isEqualTo(3);
     
    for (ChessPlayer player : players) {
        log.info(player.getLastName() + ", " + player.getFirstName()); 
    }
}

```

```java
@Query("SELECT p FROM ChessPlayer p WHERE upper(p.lastName) LIKE upper(:lastName)")
List<ChessPlayer> findByName(String lastName, Sort sort);
```

```java
@Test
public void sortByMultipleAttributes() {
    log.info("... sortByMultipleAttributes ...");
 
    TypedSort<ChessPlayer> playerSort = Sort.sort(ChessPlayer.class);
    Sort sort = playerSort.by(ChessPlayer::getLastName).ascending()
                            .and(playerSort.by(ChessPlayer::getFirstName).ascending());
    List<ChessPlayer> players = playerRepo.findByName("%a%", sort);
    assertThat(players.size()).isEqualTo(3);
     
    for (ChessPlayer player : players) {
        log.info(player.getLastName() + ", " + player.getFirstName()); 
    }
}
```

```java

@Test
public void sortByMultipleAttributesSameDirection() {
    log.info("... sortByMultipleAttributesSameDirection ...");
 
    Sort sort = Sort.by(Direction.ASC, "firstName", "lastName");
    List<ChessPlayer> players = playerRepo.findByName("%a%", sort);
    assertThat(players.size()).isEqualTo(3);
     
    for (ChessPlayer player : players) {
        log.info(player.getLastName() + ", " + player.getFirstName()); 
    }
}
```

```java
@Test
public void unsorted() {
    log.info("... unsorted ...");
 
    List<ChessPlayer> players = playerRepo.findByName("%a%", Sort.unsorted());
    assertThat(players.size()).isEqualTo(3);
     
    for (ChessPlayer player : players) {
        log.info(player.getLastName() + ", " + player.getFirstName()); 
    }
}
```

## The JpaSort class
```java
@Test
public void sortByFunction() {
    log.info("... sortByFunction ...");
 
    Sort sort = JpaSort.unsafe(Direction.DESC, "length(lastName)", "length(firstName)");
    List<ChessPlayer> players = playerRepo.findByName("%a%", sort);
    assertThat(players.size()).isEqualTo(3);
     
    for (ChessPlayer player : players) {
        log.info(player.getLastName() + ", " + player.getFirstName()); 
    }
}
```

# Paginate your Query Results
If your query returns a huge number of records, you often don‘t want to receive all of them at once. Instead, you want to split the result set into multiple parts that can be easily presented in the frontend or handled by your business logic. This is called pagination, and it‘s, of course, not a feature that is exclusive to Spring Data JPA. In an SQL query, you usually use an OFFSET and a LIMIT clause to tell your database if you want to skip any number of records at the beginning of the result set and how many records you want to receive. Using plain JPA, you can achieve the same by calling the setFirstResult and setMaxResult methods on your query.

Spring Data JPA provides an abstraction for pagination, which is similar to the approach implemented by JPA but slightly easier to use.



## Pageable
Using plain JPA, you set the number of records you want to retrieve as maxResults and calculate the index of the first record based on the index of your page and the number of records per page.

Spring Data JPA provides the Pageable abstraction for that. You can activate it by adding a parameter of type Pageable to your repository method. When you call that method in your business code, you can use the PageRequest class to specify the number of elements per page and the index of the page you want to retrieve. And to ensure that you always get the records in the same order and don’t miss anything when requesting one page after the other, you can also provide a Sort object. This is the same object as we used in the previous lecture to define the sorting of our query results.

At runtime, Spring Data JPA then calculates the index of the first record you requested and sets the firstResult and maxResults properties accordingly.


## Query Result
When you use this approach, you also need to choose a result type for your repository method. Spring Data JPA can return it as a Page containing the requested number of records from the result set and the total number of pages available. This is very useful if you want to present the result in your frontend and enable your user to navigate through the pages. To get the number of pages, Spring Data JPA executes a count query. If you’re using a derived query or a custom JPQL query, Spring Data JPA can generate the count query for you. If you’re using a custom native SQL query, you need to provide that statement yourself. But more about that later.

If you don’t need to know how many pages you could retrieve, you can let Spring Data JPA return a Slice or a List. Both only contain the records of the specified page but no additional metadata. In these cases, Spring Data JPA, of course, skips the execution of the count query.

## Code Sample
If your repository extends Spring Data JPA’s PagingAndSortingRepository or JpaRepository interface, you get a findAll method that accepts a parameter of type Pageable. I call that method in this first test case and provide this PageRequest to it. The 1st parameter specifies the index of the page I want to retrieve. This index is zero-based. So, I’m requesting the 2nd page of the result set. The 2nd parameter defines the number of records per page, which in this example will be 5. And then, I’m providing this Sort object to sort the players in the ascending order of their last name.


```java
@Test
public void findAll() {
    log.info("... findAll ...");
 
    PageRequest page = PageRequest.of(1, 5, Sort.by("lastName").ascending());
    Page<ChessPlayer> players = playerRepo.findAll(page);
    assertThat(players.getNumber()).isEqualTo(1);
    assertThat(players.getSize()).isEqualTo(5);
    assertThat(players.getNumberOfElements()).isEqualTo(5);
    assertThat(players.getTotalPages()).isEqualTo(4);
    assertThat(players.getTotalElements()).isEqualTo(19);
     
    for (ChessPlayer player : players) {
        log.info(player.getLastName() + ", " + player.getFirstName()); 
    }
}
```

```java
Page<ChessPlayer> findByLastName(String lastName, Pageable page);

@Test
public void findByNameDerived() {
    log.info("... findByNameDerived ...");

    PageRequest page = PageRequest.of(1, 5, Sort.by("lastName"));
    Page<ChessPlayer> players = playerRepo.findByLastName("Doe", page);
    assertThat(players.getNumber()).isEqualTo(1);
    assertThat(players.getNumberOfElements()).isEqualTo(5);
    assertThat(players.getTotalPages()).isEqualTo(3);
    assertThat(players.getTotalElements()).isEqualTo(15);

    for (ChessPlayer player : players) {
        log.info(player.getLastName() + ", " + player.getFirstName());
    }
}


```

```java
@Query("SELECT p FROM ChessPlayer p WHERE upper(p.lastName) LIKE upper(:lastName)")
Page<ChessPlayer> findByNamePage(String lastName, Pageable page);
```
```java
@Query(value = "SELECT * FROM Chess_Player p WHERE upper(p.last_name) LIKE upper(:lastName)",
        countQuery = "SELECT count(p.id) FROM Chess_Player p WHERE upper(p.last_name) LIKE upper(:lastName)",
        nativeQuery = true)
Page<ChessPlayer> findByNameNative(String lastName, Pageable page);

```

```java
@Query("SELECT p FROM ChessPlayer p WHERE upper(p.lastName) LIKE upper(:lastName)")
Slice<ChessPlayer> findByNameSlice(String lastName, Pageable page);
 
@Query("SELECT p FROM ChessPlayer p WHERE upper(p.lastName) LIKE upper(:lastName)")
List<ChessPlayer> findByNameList(String lastName, Pageable page);

```

```java
@Test
public void findByNameSlice() {
    log.info("... findByNameSlice ...");
 
    PageRequest page = PageRequest.of(1, 5, Sort.by("lastName"));
    Slice<ChessPlayer> players = playerRepo.findByNameSlice("Doe", page);
    assertThat(players.getNumber()).isEqualTo(1);
    assertThat(players.getNumberOfElements()).isEqualTo(5);
     
    for (ChessPlayer player : players) {
        log.info(player.getLastName() + ", " + player.getFirstName()); 
    }
}
```

```java
@Test
public void unpaged() {
    log.info("... unpaged ...");
 
    Page<ChessPlayer> players = playerRepo.findByNameNative("Doe", Pageable.unpaged());
    assertThat(players.getNumberOfElements()).isEqualTo(15);
     
    for (ChessPlayer player : players) {
        log.info(player.getLastName() + ", " + player.getFirstName()); 
    }
}
```