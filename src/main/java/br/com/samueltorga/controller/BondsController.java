package br.com.samueltorga.controller;


import br.com.samueltorga.mapper.BondEntityConverter;
import br.com.samueltorga.protobuf.BondReply;
import br.com.samueltorga.protobuf.BondRequest;
import br.com.samueltorga.protobuf.BondsControllerGrpc;
import br.com.samueltorga.repository.BondRepository;
import br.com.samueltorga.repository.entity.Bond;
import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class BondsController extends BondsControllerGrpc.BondsControllerImplBase {

    private final BondRepository bondRepository;

    @Override
    public void create(BondRequest request, StreamObserver<BondReply> responseObserver) {
        log.debug("Request received: Send");
        Bond entity = BondEntityConverter.INSTANCE.toBondEntity(request);
        Bond saved = bondRepository.save(entity);
        BondReply response = BondReply.newBuilder()
                .setId(saved.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
