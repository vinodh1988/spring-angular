package isqlglobal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subtopic")
public class SubTopic {
@Id	
  private int sub_topic_id;
@Column(name="topic")
  private String topic;
@Column(name="topic_id",insertable=false,nullable=true)
  private int topic_id;
public int getSub_topic_id() {
	return sub_topic_id;
}
public void setSub_topic_id(int sub_topic_id) {
	this.sub_topic_id = sub_topic_id;
}
public String getTopic() {
	return topic;
}
public void setTopic(String topic) {
	this.topic = topic;
}
public int getTopic_id() {
	return topic_id;
}
public void setTopic_id(int topic_id) {
	this.topic_id = topic_id;
}


}
