package com.br.itwzhangzx02.learn.POJO;

public class User {
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  private Long id;       //主键id
  private String name;   //姓名
  private Integer age;   //年龄
  private String school; //学校

  public User(Long id, String name, Integer age, String school) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.school = school;
  }
}
