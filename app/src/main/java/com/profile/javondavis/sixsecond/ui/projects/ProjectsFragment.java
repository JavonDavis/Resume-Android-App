package com.profile.javondavis.sixsecond.ui.projects;

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
import com.profile.javondavis.models.Project;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProjectsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProjectsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProjectsFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    private String mFirstName;
    private ArrayList<Project> mProjects;

    @Bind(R.id.projectList) RecyclerView projectList;
    @Bind(R.id.projectHeaderView) TextView projectsHeaderView;

    public ProjectsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProjectsFragment.
     * @param firstname - String
     * @param projects - List of Project objects
     */
    public static ProjectsFragment newInstance(String firstname, List<Project> projects) {
        ProjectsFragment fragment = new ProjectsFragment();
        Bundle args = new Bundle();

        args.putString(Constants.TAG_NAME, firstname);
        args.putParcelableArrayList(Constants.TAG_PROJECTS, (ArrayList<? extends Parcelable>) projects);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mFirstName = getArguments().getString(Constants.TAG_NAME);
            mProjects = getArguments().getParcelableArrayList(Constants.TAG_PROJECTS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_projects, container, false);
        ButterKnife.bind(this, view);

        Resources res = getResources();
        String textForProjectsHeader = String.format(res.getString(R.string.text_project_header), mFirstName);

        projectsHeaderView.setText(textForProjectsHeader);

        projectList.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        projectList.setLayoutManager(mLayoutManager);

        int numProjects = mProjects.size();
        int end = numProjects > 3 ? 3:numProjects;

        ArrayList<Project> filteredProjects = new ArrayList<>(); // result of ArrayList.subList could not be cast to ArrayList
        for(int index = 0; index<end; index++)
        {
            filteredProjects.add(mProjects.get(index));
        }

        ProjectAdapter organizationAdapter = new ProjectAdapter(getContext(), filteredProjects);
        projectList.setAdapter(organizationAdapter);

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
