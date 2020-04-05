package yzujbs.chata;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginPage extends AppCompatActivity {


    ImageView mainLogo;
    Button btnLogin;
    EditText edtAccount,edtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ActionBar actionBar = getSupportActionBar();    //hide the action bar
        actionBar.hide();                               //hide the action bar
        initialLayout();
    }

    void initialLayout(){

        btnLogin=new Button(this);
        edtAccount=new EditText(this);
        edtPassword=new EditText(this);

        btnLogin=findViewById(R.id.btnlogin);
        edtAccount=findViewById(R.id.edtAccount);
        edtPassword=findViewById(R.id.edtPassword);


        btnLogin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.signInWithEmailAndPassword(edtAccount.getText().toString(), edtPassword.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Log.d("", "登入成功");

                                Intent it =new Intent(LoginPage.this,BottomNavigation.class);
                                startActivity(it);


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("", "登入失敗，請檢查email/password");


                            }
                        });
            }
        });



    }
}
