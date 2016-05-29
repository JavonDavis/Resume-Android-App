package com.profile.javondavis.sixsecond.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.profile.javondavis.R;
import com.profile.javondavis.helpers.Constants;
import com.profile.javondavis.models.Skills;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TopSkillsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TopSkillsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopSkillsFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    private String mFirstName;
    private Skills mSkills;

    @Bind(R.id.topSkillsHeaderView) TextView headerView1;
    @Bind(R.id.topSkillsHeaderView2) TextView headerView2;

    @Bind(R.id.topSkill1TextView) TextView topSkill1View;
    @Bind(R.id.topSkill2TextView) TextView topSkill2View;
    @Bind(R.id.topSkill3TextView) TextView topSkill3View;
    @Bind(R.id.topSkill4TextView) TextView topSkill4View;

    @Bind(R.id.familiarSkill1TextView) TextView familiarSkill1View;
    @Bind(R.id.familiarSkill2TextView) TextView familiarSkill2View;
    @Bind(R.id.familiarSkill3TextView) TextView familiarSkill3View;

    public TopSkillsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TopSkillsFragment.
     * @param firstname - String
     * @param skills - Skills object
     */
    public static TopSkillsFragment newInstance(String firstname, Skills skills) {
        TopSkillsFragment fragment = new TopSkillsFragment();
        Bundle args = new Bundle();

        args.putString(Constants.TAG_NAME, firstname);
        args.putParcelable(Constants.TAG_SKILLS, skills);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFirstName = getArguments().getString(Constants.TAG_NAME);
            mSkills = getArguments().getParcelable(Constants.TAG_SKILLS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_skills, container, false);
        ButterKnife.bind(this,view);

        // For now let's assume there's at least 4 top skills and 3 familiar skills

        // Set header for top skills
        String textForHeader1 = String.format(getString(R.string.text_skills_header),mFirstName);
        headerView1.setText(textForHeader1);

        // show 4 top skills
        topSkill1View.setText(mSkills.getProficient().get(0));
        topSkill2View.setText(mSkills.getProficient().get(1));
        topSkill3View.setText(mSkills.getProficient().get(2));
        topSkill4View.setText(mSkills.getProficient().get(3));


        // Set header for familiar skills
        String textForHeader2 = String.format(getString(R.string.text_skills_header_2),mFirstName);
        headerView2.setText(textForHeader2);

        // show 3 familiar skills
        familiarSkill1View.setText(mSkills.getFamiliar().get(0));
        familiarSkill2View.setText(mSkills.getFamiliar().get(1));
        familiarSkill3View.setText(mSkills.getFamiliar().get(2));

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
