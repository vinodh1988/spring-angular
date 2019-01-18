package isqlglobal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isqlglobal.dao.EnquiryDAO;
import isqlglobal.entity.Module;
import isqlglobal.entity.Enquiry;

@Service
public class EnquiryService {
@Autowired
  EnquiryDAO enquiryDAO;

public List<Enquiry> getEnquiries(){
	 Iterable<Enquiry> i=enquiryDAO.findAll();
	 List<Enquiry> l=new ArrayList<Enquiry>();
	 
	 for(Enquiry x:i){
		 l.add(x);
	 }
	 return l;
}

public Enquiry addEnquiry(Enquiry r){
	enquiryDAO.save(r);
	return r;
}
}
