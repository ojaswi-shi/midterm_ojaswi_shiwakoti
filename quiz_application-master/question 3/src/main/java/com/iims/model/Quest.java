package com.iims.model;

public class Quest {
    int id;
    String quest, optionOne, optionTwo, optionThree, correctAns;

    public Quest() {}

    public Quest(int id, String quest, String ansOne, String ansTwo, String ansThree, String correctAns) {
        this.id = id;
        this.quest = quest;
        this.optionOne = ansOne;
        this.optionTwo = ansTwo;
        this.optionThree = ansThree;
        this.correctAns = correctAns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", quest='" + quest + '\'' +
                ", optionOne='" + optionOne + '\'' +
                ", optionTwo='" + optionTwo + '\'' +
                ", optionThree='" + optionThree + '\'' +
                ", correctAns='" + correctAns + '\'' +
                '}';
    }
}
