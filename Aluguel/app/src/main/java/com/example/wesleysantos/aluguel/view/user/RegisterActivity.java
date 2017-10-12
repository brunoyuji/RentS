package com.example.wesleysantos.aluguel.view.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wesleysantos.aluguel.view.fragments.MainActivity;
import com.example.wesleysantos.aluguel.R;
import com.example.wesleysantos.aluguel.database.DataBase;

public class RegisterActivity extends AppCompatActivity {
    private TextView txtWarningEmail;
    private TextView txtWarningPassword;
    private TextView txtNext;
    private TextView txtBack;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtPasswordConfirmation;
    public static  int EVENT_BTN_NEXT = 1;
    public static final int EVENT_BTN_BACK = 0;
    private int respBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        txtWarningEmail = (TextView)findViewById(R.id.txt_warning_email);
        txtWarningPassword = (TextView)findViewById(R.id.txt_warning_password);
        txtNext = (TextView)findViewById(R.id.txt_btn_next);
        txtBack= (TextView)findViewById(R.id.txt_btn_back);

        edtEmail = (EditText)findViewById(R.id.edt_email);
        edtPassword = (EditText)findViewById(R.id.edt_password);
        edtPasswordConfirmation = (EditText)findViewById(R.id.edt_password_confirmation);
    }


    // Voltar para a tela principal usando o botão fisico
    @Override
    public void onBackPressed() {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        finish();
        startActivity(it);
    }

    // Voltar para a tela principal usando o botão back
    public void closeAndBack() {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        finish();
        startActivity(it);
    }

    // Se as senhas e o email estão corretos, avança no cadastro
    public void nextStep() {
        Intent it = new Intent(getApplicationContext(), RegisterData.class);
        finish();
        startActivity(it);
    }


    // Leitura dos botoes NEXT e BACK
    private void updateResp(View view) {
        if (view == txtNext)
            respBtn = EVENT_BTN_NEXT;
        if (view == txtBack)
            respBtn = EVENT_BTN_BACK;
    }
    public int returnButtons() {

        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResp(view);
            }
        });
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResp(view);
            }
        });
        return respBtn;
    }





    // Recuperação dos dados nos editTexts
    public String[] getRegisterData() {
        String[] data = {returnEmail(), returnPassword(), returnConfirmationPassword()};
        return data;
    }
    private String returnPassword() {
        String password = edtPassword.getText().toString().trim();
        return password;
    }

    private String returnConfirmationPassword() {
        String confirmationPassword = edtPasswordConfirmation.getText().toString().trim();
        return confirmationPassword;
    }

    private String returnEmail() {
        String email = edtEmail.getText().toString().trim();
        return email;
    }


    //Avisos sobre erros
    public void setWarningEmailEmpty() {
        txtWarningPassword.setText("");
        edtEmail.requestFocus();
        txtWarningEmail.setText(R.string.txt_warning_email);
    }
    public void setWarningEmailInvalid() {
        txtWarningPassword.setText("");
        edtEmail.requestFocus();
        txtWarningEmail.setText(R.string.txt_warning_email_invalid);
    }
    public void setWarningPasswordEmpty() {
        txtWarningEmail.setText("");
        edtPassword.requestFocus();
        txtWarningPassword.setText(R.string.txt_warning_password);
    }

    public void setWarningPasswordConfirmationEmpty() {
        txtWarningEmail.setText("");
        edtPassword.requestFocus();
        txtWarningPassword.setText(R.string.txt_warning_password_confirmation);
    }

    public void setWarningPasswordNoMatch() {
        txtWarningEmail.setText("");
        edtPassword.requestFocus();
        txtWarningPassword.setText(R.string.txt_warning_passwords_no_match);
    }

}
