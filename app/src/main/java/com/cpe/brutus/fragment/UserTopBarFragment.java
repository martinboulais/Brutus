package com.cpe.brutus.fragment;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpe.brutus.R;
import com.cpe.brutus.databinding.UserTopBarFragmentBinding;
import com.cpe.brutus.model.User;
import com.cpe.brutus.model.UserView;
import com.cpe.brutus.viewmodel.UserViewModel;

public class UserTopBarFragment extends Fragment {

    /**
     * The user view model
     */
    private UserViewModel mUserViewModel;

    private UserTopBarFragmentBinding binding;

    public UserTopBarFragment() {

        mUserViewModel = new UserViewModel(
                new UserView(
                        new User(0, 30, 1)
                )
        );
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.user_top_bar_fragment, container, false);
        binding.setUserViewModel(mUserViewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }
}
