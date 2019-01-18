package isqlglobal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isqlglobal.dao.AppMessage;
import isqlglobal.dao.AppMessageDAO;
import isqlglobal.dao.User;
import isqlglobal.dao.UserDAO;

@Service
public class MessagingService {
  @Autowired
  AppMessageDAO mdao;
  @Autowired
  UserDAO udao;
  public boolean checkLong(String user,String password){
	  Object[] u=udao.findByName(user,password);
	  System.out.println(udao.getName(user));
	  
	  if(u!=null)
		  return true;
	  else
		  return false;
  }
  
  public List<AppMessage> getMessage(String from,String to){
	 List<AppMessage> l= mdao.findByName(from, to);
	 List<AppMessage> result=new ArrayList<AppMessage>();
	 for(int i=0;i<5;i++)
		 result.add(l.get(i));
	 
	 return result;
  }
  
  public List<AppMessage> getMessage(String from,String to,int last)
  {
	  List<AppMessage> l=mdao.findeByNameAndNew(from, to, last);
	  return l;
  }  
  
  public List<String>  getUsers(String name){
	  List<User> l= udao.FindAllExcept(name);
	  List<String> list=new ArrayList();
	  for(User x:l)
		  list.add(x.getUserid());
	  return list;
		  
  }
  
  public User addUser(User user){
	 try{
	  udao.addUser(user.getUserid(), user.getName());
	  return null;
	 }
	 catch(Exception e){
		 e.printStackTrace();
		 return user;
	 }
  }
  
  public  AppMessage  addMessage(AppMessage m){
	  mdao.save(m);
	  return m;
	  
  }
	
}
