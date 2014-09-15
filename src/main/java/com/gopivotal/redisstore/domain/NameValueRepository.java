package com.gopivotal.redisstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface NameValueRepository extends CrudRepository<NameValue, Long> {

    List<NameValue> findByName(String name);
}