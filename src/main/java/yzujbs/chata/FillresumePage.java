package yzujbs.chata;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FillresumePage extends AppCompatActivity {


    Button btnRegister;
    EditText edtName,edtNickname,edtSex,edtLocal,edtBirth,edtTalent,edtLearn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillresume_page);
        ActionBar actionBar = getSupportActionBar();    //hide the action bar
        actionBar.hide();                               //hide the action bar
        initialLayout();
    }

    void initialLayout(){

        //-------Layout-----------



        //-------logo-------------



        //-------Name--------------


        edtName=new EditText(this);
        edtName=findViewById(R.id.edtName);

        //-------NickName----------


        edtNickname=new EditText(this);
        edtNickname=findViewById(R.id.edtNickname);

        //-------Sex-------------


        edtSex=new EditText(this);
        edtSex=findViewById(R.id.edtSex);


        //-------Local-------------


        edtLocal=new EditText(this);
        edtLocal=findViewById(R.id.edtLocal);

        //-------Age----------------


        edtBirth=new EditText(this);
        edtBirth=findViewById(R.id.edtBirth);

        //-------Talent-------------


        edtTalent=new EditText(this);
        edtTalent=findViewById(R.id.edtTalent);

        //-------Learn--------------


        edtLearn=new EditText(this);
        edtLearn=findViewById(R.id.edtLearn);



        //-------button-----------


        btnRegister=new Button(this);
        btnRegister=findViewById(R.id.btnGoin);




    }
}
