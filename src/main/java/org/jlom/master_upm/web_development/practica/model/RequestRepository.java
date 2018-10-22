package org.jlom.master_upm.web_development.practica.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Long> {

    List<Request> findByRequestName(String requestName);
}
