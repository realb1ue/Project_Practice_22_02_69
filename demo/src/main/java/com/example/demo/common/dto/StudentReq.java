package com.example.demo.common.dto;

public class StudentReq {
    private String name;
    private String studentNo;
    private Integer point;
    private Integer age;
    private Integer height;
    private String room;
    private String year;
    //private String student_id;



    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
    public String getStudentNo(){
        return studentNo;
    }
    public void setPoint(Integer points) {
        this.point = points;
    }
    public Integer getPoint(){
        return point;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
    public Integer getHeight(){
        return height;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public String getRoom(){
        return room;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getYear(){
        return year;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
