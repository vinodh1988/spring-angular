package isqlglobal.rest;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import isqlglobal.dao.AppMessage;
import isqlglobal.dao.User;
import isqlglobal.entity.Enquiry;
import isqlglobal.entity.Mail;
import isqlglobal.entity.Module;
import isqlglobal.entity.ModuleDetails;
import isqlglobal.entity.Result;
import isqlglobal.entity.Reviews;
import isqlglobal.entity.SubTopic;
import isqlglobal.service.EnquiryService;
import isqlglobal.service.MessagingService;
import isqlglobal.service.ModuleService;
import isqlglobal.service.ReviewService;



@RestController
@RequestMapping("/rest-api")
@CrossOrigin(origins={"http://localhost:4200"})
public class Boot {
	@Autowired
	ModuleService moduleService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	EnquiryService enquiryService;

	@Autowired
	    private MessagingService messagingService;
	
  @RequestMapping("/modules")
  public List<Module> getModules()
  {
	  return moduleService.getModules();
  }
  
  @RequestMapping("/reviews")
  public List<Reviews> getReviews()
  {
	  return reviewService.getReviews();
  }
  
  @RequestMapping("/get-users/{name}")
  public List<String> getAppUsers(@PathVariable String name)
  {
	  return messagingService.getUsers(name);
  }
  
  @RequestMapping("/app-messages/{from}/{to}")
  public List<AppMessage> getAppMessages(@PathVariable String  from,@PathVariable String to)
  {
	  return messagingService.getMessage(from,to);
  }

 @RequestMapping("/app-messages/{from}/{to}/{last}")
  List<AppMessage> getAppMessages(@PathVariable String from,@PathVariable String to,@PathVariable int last){
	  return messagingService.getMessage(from, to,last);
  }
  
  
  @RequestMapping(value="/enquiries",method=RequestMethod.POST)
  public Enquiry addEnquiry(@RequestBody Enquiry message){
	  Mail m=new Mail();
	  Map model = new HashMap();
      model.put("name", message.getName());
      model.put("location", "India");
      model.put("message", message.getMessage());
      model.put("signature", "https://xyzcourses.com");
      m.setModel(model);
	  m.setFrom("vinodh@isqlglobal.com");
	  m.setTo(message.getEmail());
	  m.setSubject("Enquiry made for a course");
	  m.setContent(message.getMessage());
	  /* try {
			//emailService.sendSimpleMessage(m);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return enquiryService.addEnquiry(message);
	  
  }
  
  @RequestMapping("/enquiries")
  public List<Enquiry> getEnquiries()
  {
	  return enquiryService.getEnquiries();
  }
  
  @RequestMapping(value="/reviews",method=RequestMethod.POST)
  public Reviews addMessage(@RequestBody Reviews message){
	  return reviewService.addReviews(message);
	  
  }
  
  @RequestMapping(value="/add-users",method=RequestMethod.POST)
  public User addMessage(@RequestBody User user){
	  return messagingService.addUser(user);
	  
  }
  
  @RequestMapping(value="/post-message",method=RequestMethod.POST)
  public AppMessage addMessage(@RequestBody AppMessage m){
	  return messagingService.addMessage(m);
	  
  }
  
  @RequestMapping(value="/check",method=RequestMethod.POST)
  public Result check(@RequestBody User user){
	  Result r=new Result();
	  if(messagingService.checkLong(user.getUserid(), user.getName()))
	  {
		  System.out.println("Success");
		  r.setResult("Success");
		  return r;
	  }
	  r.setResult("Fail");
		return r;
	  
  }
  

  @RequestMapping("/modules/{id}")
  public Module getModules(@PathVariable String id){
	  return moduleService.getModules(id);
  }
  
  @RequestMapping("/topics/{id}")
  public List<SubTopic> getSubtopics(@PathVariable String id){
	  return moduleService.getSubs(id);
  }
  
  @RequestMapping("/courses")
  public List<ModuleDetails> getModuleDetails()
  {
	  return moduleService.getMdetails();
  }
  
  @RequestMapping(
		  value = "/images/{filename}",
		  produces = MediaType.IMAGE_JPEG_VALUE
		)
		public @ResponseBody byte[] getImageWithMediaType(@PathVariable String filename) throws IOException {
	     File f=new File("D:\\projectimages\\"+filename);
		    FileInputStream in = new FileInputStream(f);
		    return IOUtils.toByteArray(in);
		}
  }
