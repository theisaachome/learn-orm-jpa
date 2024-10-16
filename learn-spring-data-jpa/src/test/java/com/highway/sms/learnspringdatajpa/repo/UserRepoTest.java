package com.highway.sms.learnspringdatajpa.repo;

import com.highway.sms.learnspringdatajpa.oneToOne.Address;
import com.highway.sms.learnspringdatajpa.oneToOne.NRC;
import com.highway.sms.learnspringdatajpa.oneToOne.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;
    void test(){

    }
     // JUnit test for
         @Test
         public  void given_when_then(){
             // given -> precondition or setup
             var newUser = User.builder()
                     .userName("user-name")
                     .build();
             var address = new Address();
             address.setCity("city");
             address.setZipcode("12345");
             address.setStreet("street-address");
             newUser.setShippingAddress(address);
             // when -> action or the behaviour that we are going to test
             var savedUser = userRepo.save(newUser);

             // then -> verify the output...
             Assertions.assertThat(savedUser).isNotNull();
         }
          @Test
         void saveUserWithNRC(){
            var newUser = User.builder()
                    .userName("Aung Aung")
                    .build();
            var nrc = new NRC();
            nrc.setCardNo("1234567");
            nrc.setCardType("NRC");
            newUser.setNrc(nrc);

           var savedUser= userRepo.save(newUser);

           Assertions.assertThat(savedUser).isNotNull();
           Assertions.assertThat(savedUser.getNrc()).isNotNull();

         }

}