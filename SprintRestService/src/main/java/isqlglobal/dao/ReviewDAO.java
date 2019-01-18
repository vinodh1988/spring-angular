package isqlglobal.dao;

import org.springframework.data.repository.CrudRepository;

import isqlglobal.entity.Reviews;

public interface ReviewDAO extends CrudRepository<Reviews, Long>{

}