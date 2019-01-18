package isqlglobal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AppMessageDAO extends CrudRepository<AppMessage, Long>{

	@Query("from AppMessage where fromuser=:userid and touser=:touser order by sno desc")
	public List<AppMessage> findByName(@Param("userid") String from,@Param("touser") String to);
	
	@Query("from AppMessage where fromuser=:userid and touser=:touser and sno>:last order by sno desc")
	public List<AppMessage> findeByNameAndNew(@Param("userid") String from,@Param("touser") String to,@Param("last")int last);
}
