package br.com.samueltorga;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.Base64;

@MicronautTest(transactional = false)
class GrpcStudiesTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void serializeBigDecimalToDecimalValue() {
        var value = Base64.getEncoder().encodeToString(BigDecimal.valueOf(1500).unscaledValue().toByteArray());
        System.out.println(value);
    }

}
