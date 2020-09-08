package com.domain;

public class Question {
    private int id;
    private String text;
    private String type;
    private String questionOptions;
    private int correctOptionIndex;

    public Question() {
    }

    public Question(int id, String text, String type, String questionOptions, int correctOptionIndex) {
        this.id = id;
        this.text =text;
        this.type = type;
        this.questionOptions = questionOptions;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(String questionOptions) {
        this.questionOptions = questionOptions;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }
}
