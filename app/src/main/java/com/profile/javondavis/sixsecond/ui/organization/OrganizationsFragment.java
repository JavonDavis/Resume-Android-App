package com.profile.javondavis.sixsecond.ui.organization;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.profile.javondavis.R;
import com.profile.javondavis.helpers.Constants;
import com.profile.javondavis.models.WorkExperience;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrganizationsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrganizationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrganizationsFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    private String mFirstName;
    private ArrayList<WorkExperience> mWorkExperiences;

    @Bind(R.id.organizationHeader) TextView organizationHeader;
    @Bind(R.id.organizationList) RecyclerView organizationList;

    public OrganizationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OrganizationsFragment.
     * @param firstname - String
     * @param workexperiences - List of WorkExperience Objects
     */
    public static OrganizationsFragment newInstance(String firstname, List<WorkExperience> workexperiences) {
        OrganizationsFragment fragment = new OrganizationsFragment();
        Bundle args = new Bundle();

        args.putString(Constants.TAG_NAME, firstname);
        args.putParcelableArrayList(Constants.TAG_ORGANIZATIONS, (ArrayList<? extends Parcelable>) workexperiences);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFirstName = getArguments().getString(Constants.TAG_NAME);
            mWorkExperiences = getArguments().getParcelableArrayList(Constants.TAG_ORGANIZATIONS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_organizations, container, false);
        ButterKnife.bind(this,view);

        Resources res = getResources();
        String textForHeader = String.format(res.getString(R.string.text_organization_header),mFirstName);

        organizationHeader.setText(textForHeader);

        organizationList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        organizationList.setLayoutManager(mLayoutManager);

        int numExperiences = mWorkExperiences.size();
        int end = numExperiences > 3 ? 3:numExperiences;

        ArrayList<WorkExperience> filteredWorkExperiences = new ArrayList<>(); // result of ArrayList.subList could not be cast to ArrayList
        for(int index = 0; index<end; index++)
        {
            filteredWorkExperiences.add(mWorkExperiences.get(index));
        }

        OrganizationAdapter organizationAdapter = new OrganizationAdapter(getContext(), filteredWorkExperiences);
        organizationList.setAdapter(organizationAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
    }
}
