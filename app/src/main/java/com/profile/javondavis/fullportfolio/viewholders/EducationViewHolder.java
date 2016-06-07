package com.profile.javondavis.fullportfolio.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.profile.javondavis.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 02/06/2016.
 */

public class EducationViewHolder extends RecyclerView.ViewHolder
{

    @BindView(R.id.educationTextView1) public TextView educationTextView1;
    @BindView(R.id.educationTextView2) public TextView educationTextView2;
    @BindView(R.id.universityNameView) public TextView educationUniversityNameView;
    @BindView(R.id.dateView) public TextView educationDateView;
    @BindView(R.id.major1View) public TextView educationMajor1View;
    @BindView(R.id.minor1View) public TextView educationMinor1View;
    @BindView(R.id.courseContainer) public LinearLayout educationCourseContainer;
    @BindView(R.id.courseTable) public TableLayout educationCourseList;

    public EducationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
