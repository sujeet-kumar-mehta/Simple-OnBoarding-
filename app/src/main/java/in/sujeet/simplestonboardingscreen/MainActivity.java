package in.sujeet.simplestonboardingscreen;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;

    TextView firstTextView, secondTextView;
    TabLayout tabLayout;
    String big_bullet = "\u25CF", small_bullet = "\u2022";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        firstTextView = (TextView) findViewById(R.id.first_text_view);
        secondTextView = (TextView) findViewById(R.id.second_text_view);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);


        viewPager.setAdapter(new OnBoardingAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(big_bullet);
        tabLayout.getTabAt(1).setText(small_bullet);
        tabLayout.getTabAt(2).setText(small_bullet);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                tabLayout.getTabAt(tab.getPosition()).setText(big_bullet);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                tabLayout.getTabAt(tab.getPosition()).setText(small_bullet);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                firstTextView.setText(position == 0 ? "SKIP" : "BACK");
                secondTextView.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first_text_view:
                viewPager.setCurrentItem((tabLayout.getSelectedTabPosition() == 0 ? 2 : (tabLayout.getSelectedTabPosition() - 1)), true);
                break;
            case R.id.second_text_view:
                viewPager.setCurrentItem((tabLayout.getSelectedTabPosition() + 1), true);
                break;
        }
    }
    public class OnBoardingAdapter extends FragmentPagerAdapter {

        public OnBoardingAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            OnBoardingFragment onBoardingFragment = new OnBoardingFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            onBoardingFragment.setArguments(bundle);
            return onBoardingFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


}
