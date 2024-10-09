package org.example.grpc.client;

import com.practice.grpc.Common;
import com.practice.grpc.GreetingServiceOuterClass;
import com.practice.grpc.customer.CustomerOuterClass;
import com.practice.grpc.customer.CustomerServiceGrpc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GrpcClientServiceTest {
    @Autowired
    GrpcClientService grpcClientService;
    @Autowired
    CustomerClientService customerClientService;

    @Test
    void queryCustomer(){
        Common.CommonReq cmdReq = Common.CommonReq.newBuilder().setUuid(9876).build();
        CustomerOuterClass.QueryCustomerReq req = CustomerOuterClass.QueryCustomerReq.newBuilder().addAllId(new ArrayList<>(Arrays.asList(1, 2, 3))).setCommonReq(cmdReq).build();
        CustomerOuterClass.QueryCustomerResp queryCustomerResp = customerClientService.queryCustomer(req);
        System.out.println(queryCustomerResp.getCommonResp());
        queryCustomerResp.getCustomerList().forEach(System.out::println);
        for (CustomerOuterClass.Customer customer : queryCustomerResp.getCustomerList()) {
            System.out.println(customer.getName());
        }
    }

    @Test
    void sendGreetingRequest() {
        System.out.println(grpcClientService.sendGreetingRequest(GreetingServiceOuterClass.Person.newBuilder()
                .setName("Ronnie")
                .setAge(18)
//                .setEmail("1@dd.com")
                .build(), "BALL"));
    }
}