package isqlglobal.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface UserDAO extends CrudRepository<User, Long>{
	@Query("from User where userid=:userid")
	public User findByName(@Param("userid") String name);
	
	@Query("from User where userid!=:userid")
	public List<User> FindAllExcept(@Param("userid") String name);
	
	@Query(value="select * from appuser where userid=:userid and name=sha(:name)",nativeQuery=true)
	public Object[] findByName(@Param("userid")String user,@Param("name")String pass);
	
	@Query(value="select sha(:name) ",nativeQuery=true)
	public String getName(@Param("name")String name);
	
	@Modifying
	@Query(value="insert into appuser values(:name,sha(:pass))",nativeQuery=true)
	@Transactional
	public int addUser(@Param("name")String user,@Param("pass") String pass);
	

}
