package isqlglobal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import isqlglobal.entity.SubTopic;

public interface SubTopicDAO extends CrudRepository<SubTopic, Long>{

	@Query(value="select * from subtopic where lower(topic) regexp :exp",nativeQuery=true)
	  public List<SubTopic> getSubtopics(@Param("exp")String exp);
}
