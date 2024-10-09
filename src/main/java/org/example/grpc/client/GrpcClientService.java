package org.example.grpc.client;

import com.practice.grpc.GreetingServiceGrpc;
import com.practice.grpc.GreetingServiceOuterClass;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("myGrpcService")  // myGrpcService 是 application.yml 中配置的 gRPC 服務
    private GreetingServiceGrpc.GreetingServiceBlockingStub blockingStub;

    public String sendGreetingRequest(GreetingServiceOuterClass.Person person, String hobbie) {
        // 構建 gRPC 請求
        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder()
                .setPerson(person)
//                .addHobbies(hobbie)
                .build();

        // 發送 gRPC 請求，獲取回應
        GreetingServiceOuterClass.HelloResponse response = blockingStub.greeting(request);

        // 返回服務端的回應
        return response.getGreeting();
    }
}

