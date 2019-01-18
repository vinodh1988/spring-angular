package isqlglobal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isqlglobal.dao.ReviewDAO;
import isqlglobal.entity.Module;
import isqlglobal.entity.Reviews;

@Service
public class ReviewService {
@Autowired
  ReviewDAO reviewDAO;

public List<Reviews> getReviews(){
	 Iterable<Reviews> i=reviewDAO.findAll();
	 List<Reviews> l=new ArrayList<Reviews>();
	 
	 for(Reviews x:i){
		 l.add(x);
	 }
	 return l;
}

public Reviews addReviews(Reviews r){
	reviewDAO.save(r);
	return r;
}
}
