package com.sami;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    RelativeLayout rl1;
    WebView wb;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    rl1.setVisibility(View.VISIBLE);
                    wb.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    rl1.setVisibility(View.INVISIBLE);
                    wb.setVisibility(View.VISIBLE);
                    wb.setWebViewClient(new WebViewClient());
                    wb.loadUrl("https://m.youtube.com/watch?v=aatr_2MstrI");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl1 = (RelativeLayout) findViewById(R.id.rl1);
        mTextMessage = (TextView) findViewById(R.id.message);
        wb = (WebView) findViewById(R.id.wb);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
}
