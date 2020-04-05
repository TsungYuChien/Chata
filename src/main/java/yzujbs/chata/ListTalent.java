package yzujbs.chata;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import yzujbs.chata.R;

public class ListTalent extends AppCompatActivity {

    private RecyclerView blogList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_list_talent);
        initial();
        //---------------Action Bar-----------------
//        TextView tv=new TextView(getApplicationContext());
//        RelativeLayout.LayoutParams txtview=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        tv.setLayoutParams(txtview);
//        tv.setText("ChaTa");
//        tv.setTextSize(35);
//        tv.setTextColor(Color.rgb(255,253,247));
//
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(tv);


    }
    void initial(){
        blogList=findViewById(R.id.blog_list);
        blogList.setHasFixedSize(true);
        blogList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder{

        View view;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
        }

        public void setTitle(String title){
            TextView talentTitle=(TextView)view.findViewById(R.id.TalentTitle);
            talentTitle.setText(title);
        }

        public void setLocal(String local){
            TextView talentLocal=(TextView)view.findViewById(R.id.TalentLocal);
            talentLocal.setText(local);
        }

        public void setTalent(String talent){
            TextView talentTalent=(TextView)view.findViewById(R.id.TalentTalent);
            talentTalent.setText(talent);
        }

        public void setLearn(String learn){
            TextView talentLearn=(TextView)view.findViewById(R.id.TalentLearn);
            talentLearn.setText(learn);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {



        return super.onCreateOptionsMenu(menu);
    }
}
