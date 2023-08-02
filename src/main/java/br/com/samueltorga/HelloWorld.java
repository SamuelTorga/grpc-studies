package br.com.samueltorga;

import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class HelloWorld extends GrpcStudiesServiceGrpc.GrpcStudiesServiceImplBase  {

    @Override
    public void send(GrpcStudiesRequest request, StreamObserver<GrpcStudiesReply> responseObserver) {
        log.debug("Request received: Send");
        GrpcStudiesReply response = GrpcStudiesReply.newBuilder()
                .setMessage(String.format("Name received: %s", request.getName()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
