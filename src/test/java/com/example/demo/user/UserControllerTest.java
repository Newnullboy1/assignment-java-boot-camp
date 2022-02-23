package com.example.demo.user;

import com.example.demo.UtilTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserService userService;

    private final UtilTestData utilTestData = new UtilTestData();

    @Test
    void getUserAddress() {

        UserEntity user = utilTestData.generateUserMockData();
        UserAddressResponseModel userAddress = new UserAddressResponseModel();
        userAddress.setAddress(user.getAddress());
        when(userService.getUserAddress("0")).thenReturn(userAddress);

        UserAddressResponseModel result = testRestTemplate.getForObject("/user/get/address/0",UserAddressResponseModel.class);

        assertEquals(user.getAddress(),result.getAddress());
    }
}