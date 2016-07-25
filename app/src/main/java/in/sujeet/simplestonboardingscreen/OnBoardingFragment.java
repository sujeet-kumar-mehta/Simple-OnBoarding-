package in.sujeet.simplestonboardingscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dailyroundsvalencia on 23/07/16.
 */
public class OnBoardingFragment extends Fragment {

    public OnBoardingFragment() {
    }


    View view;
    String[] main_message_titles = new String[]{"This is a tasty cake.", "This is a tasty tea.", "This is Rajnikanth auto."};

    int[] images = new int[]{R.drawable.first, R.drawable.second, R.drawable.third};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_onboarding, container, false);
        int position = getArguments().getInt("position");
        ((TextView) view.findViewById(R.id.title_text_view)).setText(main_message_titles[position]);
        ((ImageView) view.findViewById(R.id.image)).setImageResource(images[position]);
        (view.findViewById(R.id.button)).setVisibility(position == 2 ? View.VISIBLE : View.GONE);
        return view;
    }
}
