package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {
    @Id
    private int feedbackId;
    @Column(name = "starValue")
    private int starValue;
    @Column(name = "comments")
    private String text;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getStarValue() {
        return starValue;
    }

    public void setStarValue(int starValue) {
        this.starValue = starValue;
    }
}
