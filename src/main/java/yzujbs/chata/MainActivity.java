package yzujbs.chata;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {


    LinearLayout ll;
    LinearLayout []llHor=new LinearLayout[3];
    ImageView mainLogo;
    Button btnRegister;
    Button btnLogin;
    RelativeLayout.LayoutParams img=new RelativeLayout.LayoutParams(700,300);
    RelativeLayout.LayoutParams btn= new RelativeLayout.LayoutParams(540,180);
    RelativeLayout.LayoutParams btnup=new RelativeLayout.LayoutParams(540,180);
    GradientDrawable btnRBorder=new GradientDrawable();
    GradientDrawable btnLBorder=new GradientDrawable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        ActionBar actionBar = getSupportActionBar();    //hide the action bar
        actionBar.hide();                               //hide the action bar

        initialLayout();
    }

    void initialLayout(){

        //-------Layout-----------
        ll=findViewById(R.id.mainLayout);
        ll.setBackgroundResource(R.drawable.login_back);
        //ll.setBackgroundColor(Color.rgb(239,167,79));
        for(int i=0;i<3;i++){
            llHor[i]=new LinearLayout(this);
            llHor[i].setOrientation(LinearLayout.HORIZONTAL);
            ll.addView(llHor[i]);
        }

        //-------logo-------------

        /*
        mainLogo=new ImageView(MainActivity.this);
        mainLogo.setBackgroundResource(R.drawable.login_icon);
        mainLogo.setLayoutParams(img);
        img.leftMargin=190;
        img.topMargin=400;
        img.bottomMargin=250;
        llHor[0].addView(mainLogo);
        */

        btn.leftMargin=270;
        btn.topMargin=50;
        btnup.leftMargin=270;
        btnup.topMargin=980;
        //btnRBorder.setStroke(5,Color.BLACK);
        btnRBorder.setCornerRadius(100);
        btnRBorder.setColor(Color.rgb(239,114,41));
        btnLBorder.setStroke(3,Color.rgb(239,114,41));
        btnLBorder.setCornerRadius(100);
        btnLBorder.setColor(Color.WHITE);

        //-------button-----------


        btnRegister=new Button(this);
        btnRegister.setLayoutParams(btnup);
        btnRegister.setText("註冊");
        btnRegister.setTextSize(20);
        btnRegister.setTextColor(Color.rgb(255,253,247));
        btnRegister.setBackgroundColor(Color.rgb(30,41,95));
        btnRegister.setBackgroundDrawable(btnRBorder);
        llHor[1].addView(btnRegister);
        btnRegister.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,RegisterPage.class);
                startActivity(it);
            }
        });

        btnLogin=new Button(this);
        btnLogin.setLayoutParams(btn);
        btnLogin.setText("登入");
        btnLogin.setTextSize(20);
        llHor[2].addView(btnLogin);
        btnLogin.setBackgroundDrawable(btnLBorder);
        btnLogin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it =new Intent(MainActivity.this,LoginPage.class);
                startActivity(it);
            }
        });


    }




}




