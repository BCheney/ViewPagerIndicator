package viewpagerindicator.bhl.com.viewpagerindicator.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import viewpagerindicator.bhl.com.viewpagerindicator.R;

public class SecondFragment extends Fragment {
    private String title = "";
    private static final String FG_TITLE = "title";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString(FG_TITLE);
        }
        TextView mTextView = new TextView(getActivity());
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setText(title);
        mTextView.setTextSize(20f);
        return mTextView;
    }

    public static SecondFragment getInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(FG_TITLE, title);
        SecondFragment mFragment = new SecondFragment();
        mFragment.setArguments(bundle);
        return mFragment;
    }
}
