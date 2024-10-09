package org.example.grpc.interceptor;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@GrpcGlobalServerInterceptor
public class GrpcServerInterceptor implements ServerInterceptor {
    private static final Metadata.Key<String> SID_KEY = Metadata.Key.of("sid", Metadata.ASCII_STRING_MARSHALLER);


    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {

        long startTime = System.currentTimeMillis();
        log.info("Received call to method: {}", call.getMethodDescriptor().getFullMethodName());

        log.info(headers.toString());
        log.info("sid = {}", headers.get(SID_KEY));

        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<>(next.startCall(call, headers)) {
            @Override
            public void onComplete() {
                long totalTime = System.currentTimeMillis() - startTime;
                log.info("Completed call to method: {}. Time taken: {} ms", call.getMethodDescriptor().getFullMethodName(), totalTime);
                super.onComplete();
            }
        };
    }
}
