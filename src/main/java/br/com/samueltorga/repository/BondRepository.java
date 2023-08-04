package br.com.samueltorga.repository;

import br.com.samueltorga.repository.entity.Bond;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
public interface BondRepository extends CrudRepository<Bond, String> {
}
