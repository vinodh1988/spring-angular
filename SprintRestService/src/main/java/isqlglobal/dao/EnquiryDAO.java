package isqlglobal.dao;

import org.springframework.data.repository.CrudRepository;

import isqlglobal.entity.Enquiry;

public interface EnquiryDAO extends CrudRepository<Enquiry, Long>{

}