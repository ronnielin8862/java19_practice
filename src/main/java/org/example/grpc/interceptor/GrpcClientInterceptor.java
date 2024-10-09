package org.example.grpc.interceptor;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GrpcClientInterceptor implements ClientInterceptor{

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method,
            CallOptions callOptions,
            Channel next) {

        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
                next.newCall(method, callOptions)) {

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                // 在這裡添加你要傳遞的 Metadata
                Metadata.Key<String> customHeaderKey =
                        Metadata.Key.of("custom-header-key", Metadata.ASCII_STRING_MARSHALLER);

                headers.put(customHeaderKey, "custom-header-value");

                // 呼叫原始的 start 方法
                super.start(responseListener, headers);
            }
        };
    }
}
