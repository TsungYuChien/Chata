package yzujbs.chata;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BottomNavigation extends AppCompatActivity {

    private TextView mTextMessage;

    private FindTalent ft=new FindTalent();
    private DrawCard dc=new DrawCard();
    private Chat ct=new Chat();
    private Settings st=new Settings();

    //------------insideSetting----------------
    private ChangePersonalFile cpf =new ChangePersonalFile();
    private ChangePassword cpd =new ChangePassword();
    private AboutUs aboutus=new AboutUs();
    private ContactUs contactus=new ContactUs();
    private Version version=new Version();


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_find:
                    //mTextMessage.setText(R.string.title_find);
                    showNav(R.id.navigation_find);
                    return true;
                case R.id.navigation_draw:
                    //mTextMessage.setText(R.string.title_draw);
                    showNav(R.id.navigation_draw);
                    return true;
                case R.id.navigation_chat:
                    //mTextMessage.setText(R.string.title_chat);
                    showNav(R.id.navigation_chat);
                    return true;
                case R.id.navigation_settings:
                    //mTextMessage.setText(R.string.title_settings);
                    showNav(R.id.navigation_settings);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_navigation);

        //---------------Action Bar-----------------
        TextView tv=new TextView(getApplicationContext());
        RelativeLayout.LayoutParams txtview=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(txtview);
        tv.setText("ChaTa");
        tv.setTextSize(35);
        tv.setTextColor(Color.rgb(255,253,247));

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(getResources().getDrawable(R.drawable.title));

        //---------------------------------------


        initial();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.notification,menu);
        return super.onCreateOptionsMenu(menu);
    }

    void initial(){

        //--------------------------------------
        FragmentTransaction beginTrans=getSupportFragmentManager().beginTransaction();
        beginTrans.add(R.id.content,ft).add(R.id.content,dc).add(R.id.content,ct).add(R.id.content,st);
        beginTrans.hide(dc).hide(ct).hide(st);

            //-----------insideSetting--------------

             beginTrans.add(R.id.content,cpf);
             beginTrans.hide(cpf);

             beginTrans.add(R.id.content,cpd);
             beginTrans.hide(cpd);

             beginTrans.add(R.id.content,aboutus);
             beginTrans.hide(aboutus);

             beginTrans.add(R.id.content,contactus);
             beginTrans.hide(contactus);

             beginTrans.add(R.id.content,version);
             beginTrans.hide(version);

        //beginTrans.addToBackStack(null);
        beginTrans.commit();
        showNav(R.id.navigation_find);



    }

    void showNav(int nav){
        FragmentTransaction beginTrans=getSupportFragmentManager().beginTransaction();
        switch (nav){
            case R.id.navigation_find:
                beginTrans.hide(dc).hide(ct).hide(st).hide(cpf).hide(cpd).hide(aboutus).hide(contactus).hide(version);
                beginTrans.show(ft);
                beginTrans.addToBackStack(null);
                beginTrans.commit();
                break;
            case R.id.navigation_draw:
                beginTrans.hide(ft).hide(ct).hide(st).hide(cpf).hide(cpd).hide(aboutus).hide(contactus).hide(version);
                beginTrans.show(dc);
                beginTrans.addToBackStack(null);
                beginTrans.commit();
                break;
            case R.id.navigation_chat:
                beginTrans.hide(ft).hide(dc).hide(st).hide(cpf).hide(cpd).hide(aboutus).hide(contactus).hide(version);
                beginTrans.show(ct);
                beginTrans.addToBackStack(null);
                beginTrans.commit();
                break;
            case R.id.navigation_settings:
                beginTrans.hide(ft).hide(dc).hide(ct).hide(cpf).hide(cpd).hide(aboutus).hide(contactus).hide(version);
                beginTrans.show(st);
                beginTrans.addToBackStack(null);
                beginTrans.commit();
                break;

        }
    }

    void showChangePersonalFile(){
        FragmentTransaction beginTrans=getSupportFragmentManager().beginTransaction();
        beginTrans.hide(ft).hide(dc).hide(ct).hide(st).hide(cpd).hide(aboutus).hide(contactus).hide(version);
        beginTrans.show(cpf);
        beginTrans.addToBackStack(null);
        beginTrans.commit();
    }

    void showChangePassword(){
        FragmentTransaction beginTrans=getSupportFragmentManager().beginTransaction();
        beginTrans.hide(ft).hide(dc).hide(ct).hide(st).hide(cpf).hide(aboutus).hide(contactus).hide(version);
        beginTrans.show(cpd);
        beginTrans.addToBackStack(null);
        beginTrans.commit();
    }
    void showAboutUs(){
        FragmentTransaction beginTrans=getSupportFragmentManager().beginTransaction();
        beginTrans.hide(ft).hide(dc).hide(ct).hide(st).hide(cpf).hide(cpd).hide(contactus).hide(version);
        beginTrans.show(aboutus);
        beginTrans.addToBackStack(null);
        beginTrans.commit();
    }
    void showContactUs(){
        FragmentTransaction beginTrans=getSupportFragmentManager().beginTransaction();
        beginTrans.hide(ft).hide(dc).hide(ct).hide(st).hide(cpf).hide(cpd).hide(aboutus).hide(version);
        beginTrans.show(contactus);
        beginTrans.addToBackStack(null);
        beginTrans.commit();
    }
    void showVersion(){
        FragmentTransaction beginTrans=getSupportFragmentManager().beginTransaction();
        beginTrans.hide(ft).hide(dc).hide(ct).hide(st).hide(cpf).hide(cpd).hide(aboutus).hide(contactus);
        beginTrans.show(version);
        beginTrans.addToBackStack(null);
        beginTrans.commit();
    }

    void showListTalent(){
        Intent it=new Intent(BottomNavigation.this, ListTalent.class);
        startActivity(it);
    }


}
