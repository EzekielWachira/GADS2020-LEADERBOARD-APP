package com.ezzy.gadsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ezzy.gadsapp.dialogs.ConfirmSubmissionDialog;
import com.ezzy.gadsapp.dialogs.SubmissionSuccessDialog;
import com.ezzy.gadsapp.dialogs.SubmissionWarningDialog;
import com.ezzy.gadsapp.models.Project;
import com.ezzy.gadsapp.network.Api;
import com.ezzy.gadsapp.services.GetGadsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {

    private EditText fNameEditText, lNameEditText, emailEditText, linkEditText;
    private Button backButton, submitButton;

    private GetGadsService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        fNameEditText = findViewById(R.id.first_name_input);
        lNameEditText = findViewById(R.id.last_name_input);
        emailEditText = findViewById(R.id.email_input);
        linkEditText = findViewById(R.id.github_link_input);
//        backButton = findViewById(R.id.backButton);
        submitButton = findViewById(R.id.submit_btn);

//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SubmissionActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(fNameEditText.getText().toString()) || !isEmpty(lNameEditText.getText().toString())
                        || !isEmpty(emailEditText.getText().toString()) || !isEmpty(linkEditText.getText().toString())){
//                    submit();
                    ConfirmSubmissionDialog dialog = new ConfirmSubmissionDialog();
                    dialog.show(getSupportFragmentManager(), "Confirm Submission");
                }else {
                    makeToast("Please fill out all the fields");
                }
            }
        });
    }

    private boolean isEmpty(String s){
        return s.equals("");
    }

    public void submit(){
        service = Api.retrofitInstance()
                .create(GetGadsService.class);
        if (service != null){
            service.submit(fNameEditText.getText().toString(), lNameEditText.getText().toString(), emailEditText.getText().toString(),
                    linkEditText.getText().toString(), new Callback<Project>() {
                        @Override
                        public void onResponse(Call<Project> call, Response<Project> response) {
                            SubmissionSuccessDialog dialog = new SubmissionSuccessDialog();
                            dialog.show(getSupportFragmentManager(), "Submission Success");
                        }

                        @Override
                        public void onFailure(Call<Project> call, Throwable t) {
                            SubmissionWarningDialog dialog = new SubmissionWarningDialog();
                            dialog.show(getSupportFragmentManager(), "Submission Error");
                        }
                    });
        }else {
            SubmissionWarningDialog dialog = new SubmissionWarningDialog();
            dialog.show(getSupportFragmentManager(), "Error submitting");
        }
    }

    private void makeToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}