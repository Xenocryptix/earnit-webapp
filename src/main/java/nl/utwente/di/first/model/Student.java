package nl.utwente.di.first.model;


public class Student extends User {
    String name;
    String birth;
    String university;
    String study;
    String skills;
    String btw_num;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getBirth() {
        return birth;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
    public String getUniversity() {
        return university;
    }
    public void setStudy(String study) {
        this.study = study;
    }
    public String getStudy() {
        return study;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getSkills() {
        return skills;
    }
    public void setBtw_num(String btw_num) {
        this.btw_num = btw_num;
    }
    public String getBtw_num() {
        return btw_num;
    }
}