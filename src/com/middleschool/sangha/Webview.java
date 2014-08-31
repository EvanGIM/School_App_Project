package com.middleschool.sangha;

import de.keyboardsurfer.android.widget.crouton.Style;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.Window;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.EditText;
import com.tistory.whdghks913.croutonhelper.CroutonHelper;

public class Webview extends Activity
{
	private WebView webView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		
        super.onCreate(savedInstanceState);
        
        CroutonHelper mHelper = new CroutonHelper(this);
        
        setContentView(R.layout.webview);
        
		mHelper.setText("학교 홈페이지로 이동되었습니다.");
        mHelper.setStyle(Style.CONFIRM);
        mHelper.setDuration(3000);
        mHelper.show();
		
		
		webView = (WebView) this.findViewById(R.id.webView1);
		
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		webView.getSettings().setLightTouchEnabled(true);
		webView.getSettings().setSavePassword(true);
		webView.getSettings().setSaveFormData(true);
		
		webView.setWebViewClient(new MyWebViewClient());
		
	webView.loadUrl("http://www.sang-ha.ms.kr/");
		
	}
		
	private class MyWebViewClient extends WebViewClient { 
	    @Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			
			
			return true;
		}
    }
}
