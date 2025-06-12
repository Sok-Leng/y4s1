package com.example.crudstudentapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudstudentapp.models.Province;
import com.example.crudstudentapp.models.Student;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    protected static List<Student> studentList = new ArrayList<>();
    protected static List<Province> provinceList = new ArrayList<>();
    protected  Student  getStudentById(int id){
        Student student = new Student();
        for(Student data : studentList){
            if(data.getId()==id){
                student = data;
            }
        }
      return student;
    }
    protected List<Student> getAllStudents(){
        if(studentList.isEmpty()){
            Student student = new Student();
            student.setId(studentList.size()+1);
            student.setLastName("Ly");
            student.setFirstName("Hong");
            student.setGender("Male");
            student.setProvince(new Province(1,""));
            student.setAddress("Preyveng");
            student.setPhoneNumber("0973840562");
            studentList.add(student);
        }
        return studentList;
    }
    protected List<Province> getAllProvinces(){
        provinceList = new ArrayList<>();
        provinceList.add(new Province(1,"Preyeng"));
        provinceList.add(new Province(1,"Phnom Penh"));
        provinceList.add(new Province(1,"Kompong cheam"));
        provinceList.add(new Province(1,"Kandle"));
        return provinceList;


    }

    protected void addStudent(Student student){
        studentList.add(student);
    }
    protected Province getProvinceById(int id){
      for(Province data : provinceList){
          if(data.getId() == id){
              return data;
          }

        }
        return null;
    }
}
