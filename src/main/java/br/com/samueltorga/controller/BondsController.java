package br.com.samueltorga.controller;


import br.com.samueltorga.protobuf.BondReply;
import br.com.samueltorga.protobuf.BondRequest;
import br.com.samueltorga.protobuf.BondsControllerGrpc;
import br.com.samueltorga.protobuf.DecimalValue;
import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Singleton
public class BondsController extends BondsControllerGrpc.BondsControllerImplBase {

    @Override
    public void create(BondRequest request, StreamObserver<BondReply> responseObserver) {
        log.debug("Request received: Send");
        BondReply response = BondReply.newBuilder()
                .setId(UUID.randomUUID().toString())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private BigDecimal serializeToBigDecimal(DecimalValue decimalValue) {
        return new BigDecimal(
                new java.math.BigInteger(decimalValue.getValue().toByteArray()),
                decimalValue.getScale(),
                new java.math.MathContext(decimalValue.getPrecision())
        );
    }

}
