package edu.gsu.httpcs.a2017summer;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedPreferenceActivity extends BaseActivity {

    private final String EMAIL ="email", PASSWROD = "password", USER = "user";


    @BindView(R.id.activity_sharedpreference_email)
    EditText emailEditText;

    @BindView(R.id.activity_sharedpreference_password)
    EditText passwordEditText;

    @OnClick(R.id.activity_sharedpreference_login)
    public void login(View v) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if(check(email, password)) {
            shortToast("Login Success");
        }
    }
    private boolean check(String email, String password) {
        boolean passwordCorrect = true;  //we will add check process later
        if(passwordCorrect) {
            SharedPreferences sp = getSharedPreferences(USER, MODE_PRIVATE); //SharedPreference is to store previous
            // input  //it's like hashmap key and value
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(EMAIL, email); //key and value
            editor.putString(PASSWROD, password);
            editor.commit();
            return true;
        }
        else return false;
    }


    @OnClick(R.id.activity_sharedpreference_clear)
    public void clear(View v) {
        SharedPreferences sp = getSharedPreferences(USER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
       // editor.remove(EMAIL);
        //editor.remove(PASSWROD);
        editor.commit();
        emailEditText.setText("");
        passwordEditText.setText("");
        shortToast("You cleaned all the content!");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        ButterKnife.bind(this);

        retriveLoginInfo();
    }

    private void retriveLoginInfo() {  //save previous input
        SharedPreferences sp = getSharedPreferences(USER, MODE_PRIVATE);
        String email = sp.getString(EMAIL, "null");
        String password = sp.getString(PASSWROD, "null");

        if (!email.equals("null")) {
            emailEditText.setText(email);
            passwordEditText.setText(password);
        }
    }

}
