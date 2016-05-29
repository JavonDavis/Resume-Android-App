package com.profile.javondavis.sixsecond.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.profile.javondavis.R;
import com.profile.javondavis.helpers.Constants;
import com.profile.javondavis.models.Education;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
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

    @Bind(R.id.educationTextView1) TextView educationTextView1;
    @Bind(R.id.educationTextView2) TextView educationTextView2;
    @Bind(R.id.dateView) TextView educationDateView;
    @Bind(R.id.major1View) TextView educationMajor1;
    @Bind(R.id.minor1View) TextView educationMinor1;
    @Bind(R.id.courseContainer) LinearLayout educationCourseContainer;
    @Bind(R.id.courseList) RecyclerView educationCourseList;

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

        String status = getDateText();

        Resources res = getResources();
        String textForEducationView1 = String.format(res.getString(R.string.text_education_1), mFirstName,status);

        educationTextView1.setText(textForEducationView1);
        return view;
    }

    public String getDateText()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT, Constants.LOCALE);

        String endDateString = mEducation.getEnd();
        Date endDate = null;

        try {
            endDate = dateFormat.parse(endDateString);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Could not parse "+endDateString+". Current format is:"+Constants.DATE_FORMAT);
        }

        if(endDate != null)
        {
            if(Constants.isDateAfterToday(endDate))
            {
                return "is pursuing";
            }
            else
            {
                return "received";
            }
        }
        else
        {
            Log.d(LOG_TAG, "endate was null after parsing defaulting to is pursing");
            return "is pursuing";
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
