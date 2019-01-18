package isqlglobal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isqlglobal.dao.ModuleDAO;
import isqlglobal.dao.ModuleDetailsDAO;
import isqlglobal.dao.SubTopicDAO;
import isqlglobal.entity.Module;
import isqlglobal.entity.ModuleDetails;
import isqlglobal.entity.SubTopic;
@Service
public class ModuleService {
@Autowired
  ModuleDAO moduleDAO;

@Autowired
  SubTopicDAO subTopicDAO;

@Autowired
   ModuleDetailsDAO mdao;

public List<Module> getModules(){
	 Iterable<Module> i=moduleDAO.findAll();
	 List<Module> l=new ArrayList<Module>();
	 
	 for(Module x:i){
		 l.add(x);
	 }
	 return l;
}

public Module getModules(String module){
	 Iterable<Module> i=moduleDAO.findAll();
	
	 
	 for(Module x:i){
		 if(x.getModulecode().contentEquals(module))
			 return x;
	 }
	 return null;
}

public List<SubTopic> getSubs(String data){
	return subTopicDAO.getSubtopics(data.toLowerCase());
}

public List<ModuleDetails> getMdetails(){
	return (List<ModuleDetails>) mdao.findAll();
}
}
