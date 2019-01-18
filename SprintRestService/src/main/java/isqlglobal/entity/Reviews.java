package isqlglobal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Reviews {
	@Id
  private int review_id;
	@Column(name="name")
  private String name;
	@Column(name="email")
  private String email;
	@Column(name="course")
  private String course;
	@Column(name="message")
  private String message;
	@Column(name="reviewdate")
  private String reviewdate;
public int getReview_id() {
	return review_id;
}
public void setReview_id(int review_id) {
	this.review_id = review_id;
}
/**
 * 
 * This method returns the person name who reviewed
 * @return
 */
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getReviewdate() {
	return reviewdate;
}
public void setReviewdate(String reviewdate) {
	this.reviewdate = reviewdate;
}
  
  
}
