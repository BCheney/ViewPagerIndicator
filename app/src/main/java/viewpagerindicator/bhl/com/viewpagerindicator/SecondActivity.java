package viewpagerindicator.bhl.com.viewpagerindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import viewpagerindicator.bhl.com.viewpagerindicator.com.bhl.view.VPIndicator;
import viewpagerindicator.bhl.com.viewpagerindicator.fragment.SecondFragment;

public class SecondActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private VPIndicator mIndicator;
    private List<String> titles = Arrays.asList("消息", "电话", "音乐", "设置");
    private ArrayList<SecondFragment> fragments = new ArrayList<SecondFragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mViewPager = (ViewPager) findViewById(R.id.id_second_viewpager);
        mIndicator = (VPIndicator) findViewById(R.id.id_second_indicator);
        for (String title : titles) {
            SecondFragment fragment = SecondFragment.getInstance(title);
            fragments.add(fragment);
        }
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mIndicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}