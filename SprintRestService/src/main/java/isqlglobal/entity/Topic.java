package isqlglobal.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="topic")
public class Topic {
	@Id
 private int topic_id;
	@Column(name="topic")
 private String topic;
@Column(name="modulecode",insertable=false,nullable=true)	
private String modulecode;
@OneToMany
@JoinColumn(name="topic_id")
private Set<SubTopic> subTopic;

	public String getModulecode() {
	return modulecode;
}

public void setModulecode(String modulecode) {
	this.modulecode = modulecode;
}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getTopic() {
		return topic;
	}

	
	public Set<SubTopic> getSubTopic() {
		return subTopic;
	}

	public void setSubTopic(Set<SubTopic> subTopic) {
		this.subTopic = subTopic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	


	
}
