package com.example.wesleysantos.aluguel.view.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.wesleysantos.aluguel.R;

public class RegisterData extends AppCompatActivity {
    private TextView txtWarningUserName;
    private TextView txtWarningBirthday;
    private TextView txtWarningCPF;
    private TextView txtWarningRG;
    private TextView txtBtnNext;
    private EditText edtUserName;
    private EditText edtCPF;
    private EditText edtRG;
    private Spinner spnDay;
    private Spinner spnMonth;
    private Spinner spnYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_data);

        txtBtnNext = (TextView)findViewById(R.id.txt_btn_next);
        txtWarningUserName = (TextView)findViewById(R.id.txt_warning_user_name);
        txtWarningBirthday = (TextView)findViewById(R.id.txt_warning_birthday);
        txtWarningCPF = (TextView)findViewById(R.id.txt_warning_cpf);
        txtWarningRG = (TextView)findViewById(R.id.txt_warning_rg);
        edtCPF = (EditText)findViewById(R.id.edt_cpf);
        edtRG = (EditText)findViewById(R.id.edt_rg);
        edtUserName = (EditText)findViewById(R.id.edt_user_name);
        spnDay = (Spinner)findViewById(R.id.spn_day);
        spnMonth = (Spinner)findViewById(R.id.spn_month);
        spnYear = (Spinner)findViewById(R.id.spn_year);


        createSpinners();

    }

    private void createSpinners() {
        ArrayAdapter<Integer> spinnerDays = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1);
        for (int i = 1; i < 32; i ++) {
            spinnerDays.add(i);
        }
        spnDay.setAdapter(spinnerDays);

        ArrayAdapter<String> spinnerMonthsArray= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.months));
        spnMonth.setAdapter(spinnerMonthsArray);

        ArrayAdapter<Integer> spinneryears = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1);
        for (int i = 2017; i > 1900; i --) {
            spinneryears.add(i);
        }
        spnYear.setAdapter(spinneryears);
    }

    // obtem os dados do usuario
    public String[] getUserDatas() {
        String[] data = {returnUserName(), returnRG(), returnCPF()};
        return data;
    }
    private String returnUserName() {
        String username = edtUserName.getText().toString().trim();
        return username;
    }
    private String returnRG() {
        String rg = edtRG.getText().toString().trim();
        return rg;
    }
    private String returnCPF() {
        String cpf = edtCPF.getText().toString().trim();
        return cpf;
    }


    // Mensagens de erro
    public void setTxtWarningUserNamelEmpty() {
        txtWarningCPF.setText("");
        txtWarningRG.setText("");
        txtWarningBirthday.setText("");
        txtWarningUserName.setText(R.string.txt_warning_user_name_empty);
    }
    public void setTxtWarningUserBirthdayInvalid() {
        txtWarningCPF.setText("");
        txtWarningRG.setText("");
        txtWarningUserName.setText("");
        txtWarningBirthday.setText(R.string.txt_warning_birthday_invalid);
    }
    public void setTxtWarningRGEmpty() {
        txtWarningCPF.setText("");
        txtWarningUserName.setText("");
        txtWarningBirthday.setText("");
        txtWarningRG.setText(R.string.txt_warning_rg_empty);
    }
    public void setTxtWarningRGInvalid() {
        txtWarningCPF.setText("");
        txtWarningUserName.setText("");
        txtWarningBirthday.setText("");
        txtWarningRG.setText(R.string.txt_warning_rg_invalid);
    }

    public void setTxtWarningCPFEmpty() {
        txtWarningRG.setText("");
        txtWarningUserName.setText("");
        txtWarningBirthday.setText("");
        txtWarningCPF.setText(R.string.txt_warning_cpf_empty);
    }
    public void setTxtWarningCPFInvalid() {
        txtWarningRG.setText("");
        txtWarningUserName.setText("");
        txtWarningBirthday.setText("");
        txtWarningCPF.setText(R.string.txt_warning_cpf_invalid);
    }
}
