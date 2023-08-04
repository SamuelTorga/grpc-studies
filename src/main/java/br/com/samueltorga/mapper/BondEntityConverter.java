package br.com.samueltorga.mapper;

import br.com.samueltorga.protobuf.BondRequest;
import br.com.samueltorga.protobuf.DecimalValue;
import br.com.samueltorga.repository.entity.Bond;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

@Mapper
public interface BondEntityConverter {

    BondEntityConverter INSTANCE = Mappers.getMapper(BondEntityConverter.class);

    @Mapping(source = "name", target = "name")
    Bond toBondEntity(BondRequest from);

    static BigDecimal toBigDecimal(DecimalValue decimalValue) {
        return new BigDecimal(
                new java.math.BigInteger(decimalValue.getValue().toByteArray()),
                decimalValue.getScale(),
                new java.math.MathContext(decimalValue.getPrecision())
        );
    }

}
