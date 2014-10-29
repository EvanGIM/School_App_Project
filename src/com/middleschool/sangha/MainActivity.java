package com.middleschool.sangha;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tistory.whdghks913.croutonhelper.CroutonHelper;

import de.keyboardsurfer.android.widget.crouton.Style;

//이 앱의 테마는 초록으로@@
public class MainActivity extends ActionBarActivity {
	
	CroutonHelper mHelper = new CroutonHelper(this);
	
	Button button1;
	Button button2;
	Button button3;
	Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		startActivity(new Intent(this, SplashActivity.class));
		
		boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true); 
		if (firstrun){ 
		//여기다가 메소드를 적으세요! 

		getSharedPreferences("PREFERENCE", MODE_PRIVATE) 
		.edit() 
		.putBoolean("firstrun", false) 
		.commit(); 
		}
        
        setContentView(R.layout.main);
        
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3d9970")));
        getActionBar().setDisplayShowHomeEnabled(false);
        
        mHelper.setText("상하중학교 어플에 들어오신것을 환영합니다!");
        mHelper.setStyle(Style.INFO);
        mHelper.setDuration(6000);
        mHelper.show();
        
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(listener);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(listener);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(listener);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(listener);
    }
    
        Button.OnClickListener listener = new Button.OnClickListener()
         {
          public void onClick(View v)
           {
        	switch (v.getId()) {
        	case R.id.button1:
        	    Intent myIntent = new Intent(MainActivity.this, Webview.class);
        	    startActivity(myIntent);
        	    break;


            case R.id.button2:
        	    Intent mIntent = new Intent(MainActivity.this, com.middleschool.sangha.bap.Bap.class);
        	    startActivity(mIntent);
        	    break;
        	    
            case R.id.button3:
            	Intent mIntent1 = new Intent(MainActivity.this, InformationActivity.class);
        	    startActivity(mIntent1);
        	    break;
        	
        	    
            case R.id.button4:
            	mHelper.setText("아직 준비되지 않았습니다.");
                mHelper.setStyle(Style.ALERT);
                mHelper.setDuration(3000);
                mHelper.show();
        	    break;
            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	if(item.getItemId()==R.id.mymenu){
    		Intent myIntent = new Intent(MainActivity.this, MyActivity.class);
    	    startActivity(myIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
