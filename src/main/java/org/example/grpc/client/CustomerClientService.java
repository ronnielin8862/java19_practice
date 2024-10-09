package org.example.grpc.client;

import com.practice.grpc.customer.CustomerOuterClass;
import com.practice.grpc.customer.CustomerServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class CustomerClientService {

    @GrpcClient("myGrpcService")  // myGrpcService 是 application.yml 中配置的 gRPC 服務
    private CustomerServiceGrpc.CustomerServiceBlockingStub blockingStub;

    public CustomerOuterClass.QueryCustomerResp queryCustomer(CustomerOuterClass.QueryCustomerReq req) {
        CustomerOuterClass.QueryCustomerReq req1 = CustomerOuterClass.QueryCustomerReq.newBuilder(req).build();
        CustomerOuterClass.QueryCustomerResp queryCustomerResp = blockingStub.queryCustomer(req1);

        return queryCustomerResp;
    }

}
