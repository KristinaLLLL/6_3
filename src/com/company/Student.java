package com.company;

public class Student {
    String name;
    int ID;
  public Student(String name, int id){
      this.name=name;
      this.ID=id;
  }
  public int getId(){
      return this.ID;
  }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
