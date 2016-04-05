package viewpagerindicator.bhl.com.viewpagerindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import viewpagerindicator.bhl.com.viewpagerindicator.com.bhl.view.ViewPagerIndicator;
import viewpagerindicator.bhl.com.viewpagerindicator.fragment.SingleSampleFragment;

public class MainActivity extends FragmentActivity {
    private List<String> mList = Arrays.asList("信息", "电话", "设置");
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragments = new ArrayList<Fragment>();
    private ViewPagerIndicator mViewPagerIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (String title : mList) {
            SingleSampleFragment mFragment = SingleSampleFragment.getInstance(title);
            mFragments.add(mFragment);
        }
        mViewPagerIndicator = (ViewPagerIndicator) findViewById(R.id.id_viewPagerIndicator);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragments.get(i);
            }

            @Override
            public int getCount() {
                return mList.size();
            }
        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mViewPagerIndicator.scroll(position, positionOffset);
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
