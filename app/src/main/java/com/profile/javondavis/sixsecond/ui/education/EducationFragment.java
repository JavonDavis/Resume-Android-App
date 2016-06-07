package com.profile.javondavis.sixsecond.ui.education;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.profile.javondavis.R;
import com.profile.javondavis.helpers.Constants;
import com.profile.javondavis.models.Education;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EducationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EducationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EducationFragment extends Fragment {

    public static final String LOG_TAG = "EducationFragment";

    private OnFragmentInteractionListener mListener;

    private Education mEducation;
    private String mFirstName;
    private String mStatus = "is pursuing"; // default status
    private String gStatus = "is graduating"; // default graduation status

    @BindView(R.id.educationTextView1) TextView educationTextView1;
    @BindView(R.id.educationTextView2) TextView educationTextView2;
    @BindView(R.id.universityNameView) TextView educationUniversityNameView;
    @BindView(R.id.dateView) TextView educationDateView;
    @BindView(R.id.major1View) TextView educationMajor1View;
    @BindView(R.id.minor1View) TextView educationMinor1View;
    @BindView(R.id.courseContainer) LinearLayout educationCourseContainer;
    @BindView(R.id.courseList) RecyclerView educationCourseList;

    public EducationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EducationFragment.
     * @param firstname - String
     * @param education - Education object
     */
    public static EducationFragment newInstance(String firstname, Education education) {
        EducationFragment fragment = new EducationFragment();
        Bundle args = new Bundle();

        args.putString(Constants.TAG_NAME, firstname);
        args.putParcelable(Constants.TAG_EDUCATION, education);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFirstName = getArguments().getString(Constants.TAG_NAME);
            mEducation = getArguments().getParcelable(Constants.TAG_EDUCATION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education, container, false);
        ButterKnife.bind(this,view);

        Resources res = getResources();

        // Fill in text for "<Firstname> <received/is pursuing> a" TextView
        processStatus(); // sets mStatus to either received or is pursuing and gStatus to either
                         //graduating or graduated

        String textForEducationView1 = String.format(res.getString(R.string.text_education_1), mFirstName,mStatus);
        educationTextView1.setText(textForEducationView1);

        // Fill in text for "<degree title> in <area of study>" TextView
        String degreeTitle = mEducation.getDegree();
        String areaOfStudy = mEducation.getStudy();

        String textForEducationView2 = String.format(res.getString(R.string.text_education_2), degreeTitle,areaOfStudy);
        educationTextView2.setText(textForEducationView2);

        // Fill in University name
        educationUniversityNameView.setText(mEducation.getName());

        // Fill in graduation
        String textForEducationGraduationView = String.format(res.getString(R.string.text_graduate_date), gStatus, mEducation.getEnd());

        educationDateView.setText(textForEducationGraduationView);

        //Fill in major and minor
        String textForMajorView = String.format(res.getString(R.string.text_major_1), mEducation.getMajor());
        String textForMinorView = String.format(res.getString(R.string.text_minor_1), mEducation.getMinor());

        educationMajor1View.setText(textForMajorView);
        educationMinor1View.setText(textForMinorView);

        // Fill in courses if any available

        if(mEducation.getCourses().isEmpty())
        {
            educationCourseContainer.setVisibility(View.GONE);
        }
        else
        {
            educationCourseList.setHasFixedSize(true);

            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            educationCourseList.setLayoutManager(mLayoutManager);

            CourseAdapter courseAdapter = new CourseAdapter(mEducation.getCourses());
            educationCourseList.setAdapter(courseAdapter);
        }

        return view;
    }

    private void processStatus()
    {
        Date endDate = Constants.getDateFromString(LOG_TAG, mEducation.getEnd());

        if(endDate != null)
        {
            if(Constants.isDateAfterToday(endDate))
            {
                mStatus = "is pursuing";
                gStatus = "is graduating";
            }
            else
            {
                mStatus = "received";
                gStatus = "graduated";
            }
        }
        else
        {
            Log.d(LOG_TAG, "endDate was null after parsing defaulting to 'is pursing'");
        }
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
