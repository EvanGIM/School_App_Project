package com.middleschool.sangha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	Button button1;
	Button button2;
	Button button3;
	Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(listener);
    }

        Button.OnClickListener listener = new Button.OnClickListener()
         {
          public void onClick(View v)
           {
        	Toast.makeText(getApplicationContext(), "학교 홈페이지로 이동합니다.",
        			Toast.LENGTH_LONG).show();
        		
        	switch(v.getId()){
     	    case R.id.button1:
      		    Intent myIntent = new Intent(MainActivity.this, Webview.class);
        		startActivity(myIntent);
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
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
