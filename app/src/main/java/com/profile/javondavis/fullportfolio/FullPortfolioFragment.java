package com.profile.javondavis.fullportfolio;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.profile.javondavis.R;
import com.profile.javondavis.helpers.Constants;
import com.profile.javondavis.helpers.HeaderListItem;
import com.profile.javondavis.helpers.ListItem;
import com.profile.javondavis.models.Profile;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class FullPortfolioFragment extends Fragment {

    @Bind(R.id.profileList) RecyclerView profileList;

    private Profile mProfile;

    public static FullPortfolioFragment newInstance(Profile profile)
    {
        FullPortfolioFragment fragment = new FullPortfolioFragment();
        Bundle args = new Bundle();

        args.putParcelable(Constants.TAG_PROFILE, profile);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
        {
            mProfile = getArguments().getParcelable(Constants.TAG_PROFILE);
        }
    }

    public FullPortfolioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_portfolio, container, false);
        ButterKnife.bind(this, view);

        profileList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        profileList.setLayoutManager(mLayoutManager);

        ArrayList<ListItem> items = new ArrayList<>();

        HeaderListItem listItem = new HeaderListItem(mProfile.getImageurl(), mProfile.getName());

        items.add(listItem);

        //TODO - generify the order in which the rest of the items are added to the list

        return view;
    }
}
