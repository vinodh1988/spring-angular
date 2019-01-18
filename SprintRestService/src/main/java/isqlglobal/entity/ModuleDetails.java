package isqlglobal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="moduledetails")
public class ModuleDetails {
@Id
  private String modulecode;
@Column
  private String modulename;
@Column
  private String description;
@Column
  private String filename;
@Column
  private String duration;
@Column
  private double price;
public String getModulecode() {
	return modulecode;
}
public void setModulecode(String modulecode) {
	this.modulecode = modulecode;
}
public String getModulename() {
	return modulename;
}
public void setModulename(String modulename) {
	this.modulename = modulename;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


  
  
}
