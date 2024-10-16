
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