package com.cpe.brutus.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpe.brutus.R;
import com.cpe.brutus.databinding.ChallengeCardFragmentBinding;
import com.cpe.brutus.model.ChallengeView;
import com.cpe.brutus.viewmodel.ChallengeViewModel;

public class ChallengeCardFragment extends Fragment {

    /**
     * The fragment binding
     */
    private ChallengeCardFragmentBinding binding;

    /**
     * The view-model of the challenge that should be displayed
     */
    private ChallengeViewModel viewModel;

    /**
     * Constructor
     *
     * @param title the title of the challenge
     * @param challengeView the challenge itself
     */
    public ChallengeCardFragment(String title, ChallengeView challengeView) {

        viewModel = new ChallengeViewModel(title, challengeView);
    }

    /**
     * Constructor
     *
     * @param viewModel the viewModel of the challenge
     */
    public ChallengeCardFragment(ChallengeViewModel viewModel) {

        this.viewModel = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.challenge_card_fragment,
                container,
                false
        );
        binding.setChallengeViewModel(viewModel);

        return binding.getRoot();
    }
}

