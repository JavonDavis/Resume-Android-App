package com.profile.javondavis.fullportfolio.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.profile.javondavis.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 02/06/2016.
 */

public class EducationViewHolder extends RecyclerView.ViewHolder
{

    @Bind(R.id.educationTextView1) public TextView educationTextView1;
    @Bind(R.id.educationTextView2) public TextView educationTextView2;
    @Bind(R.id.universityNameView) public TextView educationUniversityNameView;
    @Bind(R.id.dateView) public TextView educationDateView;
    @Bind(R.id.major1View) public TextView educationMajor1View;
    @Bind(R.id.minor1View) public TextView educationMinor1View;
    @Bind(R.id.courseContainer) public LinearLayout educationCourseContainer;
    @Bind(R.id.courseTable) public TableLayout educationCourseList;

    public EducationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
