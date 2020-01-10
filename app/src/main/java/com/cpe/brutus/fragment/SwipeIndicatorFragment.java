package com.cpe.brutus.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.cpe.brutus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SwipeIndicatorFragment extends Fragment {


    public SwipeIndicatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_swipe_indicator, container, false);

        int duration = 500;
        int start_offset = 0;

        view.startAnimation(
                generateAppropriateAlphaAnimation(duration, start_offset)
        );

        return view;
    }

    private AlphaAnimation generateAppropriateAlphaAnimation(int duration, int offset) {

        AlphaAnimation animation = new AlphaAnimation(0.2f, 0.45f);
        animation.setDuration(duration);
        animation.setStartOffset(offset);
        animation.setRepeatMode(AlphaAnimation.REVERSE);
        animation.setRepeatCount(8);
        animation.setFillAfter(true);

        return animation;
    }
}
