package com.profile.javondavis.fullportfolio;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.profile.javondavis.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FullPortfolioFragment extends Fragment {

    public FullPortfolioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_full_portfolio, container, false);
    }
}
