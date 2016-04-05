package viewpagerindicator.bhl.com.viewpagerindicator.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SingleSampleFragment extends Fragment {

    public static final String FG_TITLE = "title";
    private String title = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString(FG_TITLE);
        }

        TextView mTextViewTitle = new TextView(getActivity());

        mTextViewTitle.setText(title);

        mTextViewTitle.setGravity(Gravity.CENTER);

        return mTextViewTitle;
    }

    public static SingleSampleFragment getInstance(String title) {

        Bundle bundle = new Bundle();
        bundle.putString(FG_TITLE, title);
        SingleSampleFragment mFragment = new SingleSampleFragment();
        mFragment.setArguments(bundle);

        return mFragment;
    }

}
