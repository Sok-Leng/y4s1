package com.example.crudstudentapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.crudstudentapp.R;
import com.example.crudstudentapp.adapters.CustomProvinceAdapter;
import com.example.crudstudentapp.adapters.CustomStudentAdapter;
import com.example.crudstudentapp.models.Province;
import com.example.crudstudentapp.models.Student;

public class StudentFormActivity extends BaseActivity {
private EditText etFirstName, etLastName, etAddress, etPhoneNumber;
private Button btnCreate, btnBack;
private RadioButton rbMale, rbFemale;
private Spinner spinnerprovince;
CustomProvinceAdapter provinceAdapter;
private Province selectProvince;
    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_form);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etAddress = findViewById(R.id.etAddress);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        btnBack = findViewById(R.id.btnBack);
        btnCreate = findViewById(R.id.btnCreate);
        spinnerprovince = findViewById(R.id.spinnerprovince);

        // Load provinces
        provinceList = getAllProvinces();
        provinceAdapter = new CustomProvinceAdapter(this, provinceList);
        spinnerprovince.setAdapter(provinceAdapter);

        spinnerprovince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectProvince = provinceList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectProvince = null;
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String phoneNumber = etPhoneNumber.getText().toString().trim();

                if (firstName.isEmpty()) {
                    showMessage("Please Enter student's first name");
                    return;
                }
                if (lastName.isEmpty()) {
                    showMessage("Please Enter student's last name");
                    return;
                }
                if (phoneNumber.isEmpty()) {
                    showMessage("Please Enter student's phone number");
                    return;
                }
                if (address.isEmpty()) {
                    showMessage("Please Enter student's address");
                    return;
                }

                Student student = new Student();
                student.setId(getAllStudents().size() + 1);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setPhoneNumber(phoneNumber);
                student.setGender(rbMale.isChecked() ? "Male" : "Female");
                student.setProvince(selectProvince);
                student.setAddress(address);

                addStudent(student); // Important!

                showMessage("Student Created");
                finish();
            }
        });
    }

}