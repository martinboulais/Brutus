package com.cpe.brutus.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpe.brutus.R;
import com.cpe.brutus.adapter.ChallengeCardPageAdapter;
import com.cpe.brutus.model.ChallengeView;
import com.cpe.brutus.model.Difficulty;
import com.cpe.brutus.model.EffortType;
import com.cpe.brutus.model.SecondsDuration;
import com.cpe.brutus.viewmodel.ChallengeViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This fragment only display the list of challenges card and manage the carousel that displays it
 */
public class ChallengeListFragment extends Fragment {

    /**
     * This carousel carry the display of the challenge cards
     */
    ViewPager2 challengesPager;

    List<ChallengeViewModel> challengeViewModels;

    public ChallengeListFragment() {

        challengeViewModels = new ArrayList<>();

        /*-----------------------------------------------------------------------
         *                               DEBUG
         ----------------------------------------------------------------------*/
        challengeViewModels.add(new ChallengeViewModel(
                "Challenge 1",
                new ChallengeView(
                        new SecondsDuration(0, 30),
                        3000,
                        new Difficulty("Easy", 50),
                        new EffortType(null)
                )
        ));

        challengeViewModels.add(new ChallengeViewModel(
                "Challenge 2",
                new ChallengeView(
                        new SecondsDuration(0, 40),
                        3200,
                        new Difficulty("Medium", 50),
                        new EffortType(null)
                )
        ));

        challengeViewModels.add(new ChallengeViewModel(
                "Challenge 3",
                new ChallengeView(
                        new SecondsDuration(0, 50),
                        3500,
                        new Difficulty("Hard", 50),
                        new EffortType(null)
                )
        ));

        /*-----------------------------------------------------------------------
         *                           END OF DEBUG
         ----------------------------------------------------------------------*/

    }

    public static ChallengeListFragment newInstance() {
        return new ChallengeListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.challenge_list_fragment, container, false);

        challengesPager = (ViewPager2) view.findViewById(R.id.challengesPagerView);

        ChallengeCardPageAdapter challengesPagerAdapter = new ChallengeCardPageAdapter(this);
        challengesPagerAdapter.setCardFragments(challengeViewModels);

        challengesPager.setAdapter(challengesPagerAdapter);

        challengesPager.setCurrentItem(2);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }
}
