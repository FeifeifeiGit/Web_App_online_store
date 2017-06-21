package com.fei.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="FeedBackTable")
public class FeedBack {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long feedbackid;
	
	@Column
	private int score;
	
	@Column
	private String Comment;

	public long getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(long feedbackid) {
		this.feedbackid = feedbackid;
	}



	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}
	
	
}
