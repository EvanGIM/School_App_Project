package com.middleschool.sangha;

import java.util.ArrayList;
import java.util.Collections;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class InformationActivity extends ActionBarActivity {
	
	private ListView mListView = null;
	private ListViewAdapter mAdapter = null;
	
	private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.information);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3d9970")));
	    getActionBar().setDisplayShowHomeEnabled(false);
	    
	    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	    mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close ) {

	            /** Called when a drawer has settled in a completely closed state. */
	        public void onDrawerClosed(View view) {
	            super.onDrawerClosed(view);
	        }

	            /** Called when a drawer has settled in a completely open state. */
	        public void onDrawerOpened(View drawerView) {
	            super.onDrawerOpened(drawerView);
	        }
	    };
	    mDrawerLayout.setDrawerListener(mDrawerToggle);

	    getActionBar().setDisplayHomeAsUpEnabled(true);
		
		mListView = (ListView) findViewById(R.id.left_drawer);
	    
	    mAdapter = new ListViewAdapter(this);
	    mListView.setAdapter(mAdapter);
	    
	    mAdapter.addItem(null ,
	            "목록",
	            "---------");
	    mAdapter.addItem(getResources().getDrawable(R.drawable.sangha),
	            "학교장 인사말",
	            "교장선생님의 인사말");
	    mAdapter.addItem(getResources().getDrawable(R.drawable.sangha),
	            "학교 연혁",
	            "학교가 해온 일들");
	    mAdapter.addItem(getResources().getDrawable(R.drawable.sangha),
	            "교육 목표",
	            "학교 교육의 목표");
	    mAdapter.addItem(getResources().getDrawable(R.drawable.sangha),
	            "학교 상징",
	            "작교를 상징하는 것들");
	    
	    mListView.setOnItemClickListener(new OnItemClickListener() {

	        @Override
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id){
	        	ListData mData = mAdapter.mListData.get(position);
                Toast.makeText(InformationActivity.this, mData.mTitle, Toast.LENGTH_SHORT).show();
	        }
	    });
	}
		private class ViewHolder {
			public ImageView mIcon;

			public TextView mText;

			public TextView mText1;
		}
		
		private class ListViewAdapter extends BaseAdapter {
	        private Context mContext = null;
	        private ArrayList<ListData> mListData = new ArrayList<ListData>();
	        
	        public ListViewAdapter(Context mContext) {
	            super();
	            this.mContext = mContext;
	        }
	        
	        @Override
	        public int getCount() {
	            return mListData.size();
	        }

	        @Override
	        public Object getItem(int position) {
	            return mListData.get(position);
	        }

	        @Override
	        public long getItemId(int position) {
	            return position;
	        }
	        
	        public void addItem(Drawable icon, String mTitle, String mDate){
	            ListData addInfo = null;
	            addInfo = new ListData();
	            addInfo.mIcon = icon;
	            addInfo.mTitle = mTitle;
	            addInfo.mText = mDate;
	            
	            mListData.add(addInfo);
	        }
	        
	        public void remove(int position){
	            mListData.remove(position);
	            dataChange();
	        }
	        
	        public void sort(){
	            Collections.sort(mListData, ListData.ALPHA_COMPARATOR);
	            dataChange();
	        }
	        
	        public void dataChange(){
	            mAdapter.notifyDataSetChanged();
	        }
	        
	        @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	            ViewHolder holder;
	            if (convertView == null) {
	                holder = new ViewHolder();
	                
	                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                convertView = inflater.inflate(R.layout.information_item, null);
	                
	                holder.mIcon = (ImageView) convertView.findViewById(R.id.mImage);
	                holder.mText = (TextView) convertView.findViewById(R.id.mText);
	                holder.mText1 = (TextView) convertView.findViewById(R.id.mText1);
	                
	                convertView.setTag(holder);
	            }else{
	                holder = (ViewHolder) convertView.getTag();
	            }
	            
	            ListData mData = mListData.get(position);
	            
	            if (mData.mIcon != null) {
	                holder.mIcon.setVisibility(View.VISIBLE);
	                holder.mIcon.setImageDrawable(mData.mIcon);
	            }else{
	                holder.mIcon.setVisibility(View.GONE);
	            }
	            
	            holder.mText.setText(mData.mTitle);
	            holder.mText1.setText(mData.mText);
	            
	            return convertView;
	        }
	    }
		
		
	

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
          return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.information, menu);
		return true;
	}
}
