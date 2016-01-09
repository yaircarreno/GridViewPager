package com.yupiigames.gridviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DotsPageIndicator;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
public class MainActivity extends Activity {

    private GridViewPager pager;
    private DotsPageIndicator dotsPageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                pager = (GridViewPager) stub.findViewById(R.id.pager);
                dotsPageIndicator = (DotsPageIndicator) stub.findViewById(R.id.page_indicator);
                pager.setAdapter(new GridAdapter(getBaseContext(), getFragmentManager()));
                dotsPageIndicator.setPager(pager);
            }
        });
    }
}
