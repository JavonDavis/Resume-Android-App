package com.profile.javondavis.fullportfolio.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.profile.javondavis.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 02/06/2016.
 */

public class ProjectViewHolder extends RecyclerView.ViewHolder
{

    @Bind(R.id.projectTitleView) TextView projectTitleView;
    @Bind(R.id.projectDateView) TextView projectDateView;
    @Bind(R.id.projectDescriptionView) TextView projectDescriptionView;
    @Bind(R.id.relevantTechnologyView1) TextView relevantTechnologyView1;
    @Bind(R.id.relevantTechnologyView2) TextView relevantTechnologyView2;
    @Bind(R.id.relevantTechnologyView3) TextView relevantTechnologyView3;
    @Bind({R.id.relevantTechnologyView1, R.id.relevantTechnologyView2, R.id.relevantTechnologyView3})
    List<TextView> relevantTechnologyViews;
    public ProjectViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}