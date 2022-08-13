## Create Maven Project

- ## Update maven compiler 11
- ## Add dependencies
  - ### Hibernatae
  - ### HSQL DB
  - ### Junit Jupiter Engine
- ## Create META-INF folder under resource
- ## Convert to JPA Project
- ## Configure Persistence XML

  ```xml
  <persistence-unit name="jpa-basic" transaction-type="RESOURCE_LOCAL">
  		<properties>
  			<property name="javax.persistence.jdbc.driver" value="org.hsqldb.jdbc.JDBCDriver"/>
  			<property name="javax.persistence.jdbc.user" value="sa"/>
  			<property name="javax.persistence.jdbc.url" value="jdbc:hsqldb:mem:testDb"/>
  			<property name="javax.persistence.jdbc.password" value="sa"/>
  			<property name="javax.persistence.schema-generation.database.action" value="create"/>
  			<property name="hibernate.show_sql" value="true"/>
  			<property name="hibernate.format_sql" value="true"/>
  		</properties>
  	</persistence-unit>
  </persistence>

  ```

- ## Create Entity
- ## Create JUnit Test Case
- ## Run Test
