package com.example.crudstudentapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crudstudentapp.R;
import com.example.crudstudentapp.activity.BaseActivity;
import com.example.crudstudentapp.models.Student;

import java.util.List;

public class CustomStudentAdapter extends BaseAdapter {
    private final Context context;
    private final List<Student>studentList;

    public CustomStudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }


    @Override
    public int getCount() {
        return studentList.size();
    }



    @Override
    public Student getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.student_card_layout, null, false);
            TextView studentName = view.findViewById(R.id.txtStudentName);
            TextView studentPhone = view.findViewById(R.id.txtStudentPhone);
            ImageView edit = view.findViewById(R.id.ivEdit);
            ImageView delete = view.findViewById(R.id.ivDelete);
            Student student = studentList.get(position);
            if(!student.getFirstName().isEmpty()){
                studentName.setText(student.getFirstName()+" "+student.getLastName());

            }
            if(!student.getPhoneNumber().isEmpty()){
                studentPhone.setText(student.getPhoneNumber().toString());
            }


        }
        return view;
    }
}
