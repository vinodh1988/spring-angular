package isqlglobal.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="module")

public class Module {
@Id
   private String modulecode;
@Column(name="modulename")
   private String modulename;
@Column(name="duration")
   private String duration;
@OneToMany
@JoinColumn(name="modulecode")
private Set<Topic> topic;

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
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public Set<Topic> getTopic() {
	return topic;
}
public void setTopic(Set<Topic> topic) {
	this.topic = topic;
}



}
