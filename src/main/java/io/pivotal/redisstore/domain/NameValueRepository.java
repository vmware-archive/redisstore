package io.pivotal.redisstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface NameValueRepository extends CrudRepository<NameValue, Long> {

    List<NameValue> findByName(String name);
}