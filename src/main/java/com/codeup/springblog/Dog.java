//package com.codeup.springblog;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="dogs")
//public class Dog {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false, name = "id")
//    private int id;
//
//    @Column(unique=true, nullable = false, name = "age", columnDefinition = "TINYINT(3)")
//    private int age;
//
//    @Column(nullable = false, name = "name", length = 200)
//    private String name;
//
//    @Column(name = "reside_state",columnDefinition = "CHAR(2) default 'XX'")
//    private char reside_state;
//
//    public Dog(int age, String name, char reside_state) {
//        this.age = age;
//        this.name = name;
//        this.reside_state = reside_state;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public char getReside_state() {
//        return reside_state;
//    }
//
//    public void setReside_state(char reside_state) {
//        this.reside_state = reside_state;
//    }
//}
