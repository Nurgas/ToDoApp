package kg.nurga.todoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.badoualy.stepperindicator.StepperIndicator;

public class TutorialAvtivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;
    private StepperIndicator mStepperIndicator;
    private TextView nextBtn;

    SharedPreferences mSharedPreferences;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_avtivity);
        mStepperIndicator = findViewById(R.id.intro_stepper);

        nextBtn = findViewById(R.id.next_btn);
        mSharedPreferences = getSharedPreferences("setting", MODE_PRIVATE);



        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }


            @Override
            public void onPageSelected(int i) {
                String btnText = "Next";
                if(i==2) {
                    btnText = "Finish";
                }
                nextBtn.setText(btnText);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });



        mStepperIndicator.setViewPager(mViewPager, mSectionsPagerAdapter.getCount());

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.next_btn:
                        onNextClick();
                        mSharedPreferences.edit().putBoolean("tutorial",true).apply();
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        v.getContext().startActivity(intent);
                        finish();
                        break;
                }
            }
        });

    }

    private void onNextClick() {
        if(mViewPager.getCurrentItem()==mSectionsPagerAdapter.getCount()-1){
        finish();
    } else {
        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
    }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt("page", sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tutorial_avtivity, container, false);

            TextView textView = rootView.findViewById(R.id.section_label);
            ImageView imageView = rootView.findViewById(R.id.imageView);
            int page = getArguments().getInt("page");
            switch (page) {
                case 0:
                    textView.setText("Привет");
                    imageView.setImageResource(R.drawable.spongebob);

                    break;
                case 1:
                    textView.setText("Как дела");
                    imageView.setImageResource(R.drawable.spongebob_2);

                    break;
                case 2:
                    textView.setText("Что делаешь");
                    imageView.setImageResource(R.drawable.spongebob_3);

                    break;
            }
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {

            return 3;
        }
    }
}
