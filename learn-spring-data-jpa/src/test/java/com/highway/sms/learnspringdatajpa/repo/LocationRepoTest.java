package com.highway.sms.learnspringdatajpa.repo;

import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.processing.SQL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
//@Sql(scripts = {"/data.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class LocationRepoTest {

    @Autowired
    private LocationRepo locationRepo;
    @Test
    void test(){
//        var locations = locationRepo.findFirstByState("CA");
        var locations = locationRepo.findAll();

        log.info("Location: [{}]",locations);
        assertNotNull(locations);
    }
}