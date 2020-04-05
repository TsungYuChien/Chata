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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPage extends AppCompatActivity {

    LinearLayout ll;

    Button btnRegister;
    EditText edtMail,edtPassword,edtcheckpd;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        ActionBar actionBar = getSupportActionBar();    //hide the action bar
        actionBar.hide();                               //hide the action bar
        initialLayout();
    }

    void initialLayout(){



        //-------mail-------------

        edtMail=new EditText(this);
        edtMail=findViewById(R.id.edtMail);


        //--------Password-----------

        edtPassword=new EditText(this);
        edtPassword=findViewById(R.id.edtPassword);

        //--------Password Check----------

        edtcheckpd=new EditText(this);
        edtcheckpd=findViewById(R.id.edtCheckpd);

        //-------button-----------

        btnRegister=new Button(this);
        btnRegister=findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {


                    mAuth = FirebaseAuth.getInstance();

                    mAuth.createUserWithEmailAndPassword(edtMail.getText().toString(), edtPassword.getText().toString())
                            .addOnCompleteListener(RegisterPage.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent it =new Intent(RegisterPage.this,FillresumePage.class);
                                        startActivity(it);
                                        Toast.makeText(RegisterPage.this, "success", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(RegisterPage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });




            }
        });




    }
}
