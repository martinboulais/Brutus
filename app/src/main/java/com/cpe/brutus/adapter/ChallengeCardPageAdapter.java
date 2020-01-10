package com.cpe.brutus.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.cpe.brutus.fragment.ChallengeCardFragment;
import com.cpe.brutus.viewmodel.ChallengeViewModel;

import java.util.ArrayList;
import java.util.List;

public class ChallengeCardPageAdapter extends FragmentStateAdapter {

    /**
     * List of each challenge
     */
    List<ChallengeViewModel> cardViewModels;

    public ChallengeCardPageAdapter(Fragment fragment) {

        super(fragment);

        cardViewModels = new ArrayList<>();
    }

    // Getters and Setters

    public void setCardFragments(List<ChallengeViewModel> cardViewModels) {

        this.cardViewModels = cardViewModels;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return new ChallengeCardFragment(cardViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return cardViewModels.size();
    }
}
