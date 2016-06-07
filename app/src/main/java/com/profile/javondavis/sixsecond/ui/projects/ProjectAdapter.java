package com.profile.javondavis.sixsecond.ui.projects;

import android.content.Context;
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

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 29/05/16.
 */
public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    private ArrayList<Project> mProjects;
    private Context mContext;

    public ProjectAdapter(Context context, ArrayList<Project> projects)
    {
        this.mContext = context;
        this.mProjects = projects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_projects, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Project project = mProjects.get(position);

        holder.projectTitleView.setText(project.getTitle());
        holder.projectDateView.setText(project.getDate());
        holder.projectDescriptionView.setText(project.getDescription());

        ArrayList<String> relevantTechnologies = project.getTags();

        // check how many relevant technologies and set them accordingly
        //limited to 3 for now
        int numTechnologies = relevantTechnologies.size();
        numTechnologies = numTechnologies >3 ? 3: numTechnologies;

        switch (numTechnologies)
        {
            case 1:
                holder.relevantTechnologyView1.setText(relevantTechnologies.get(0));
                break;
            case 2:
                holder.relevantTechnologyView1.setText(relevantTechnologies.get(0));
                holder.relevantTechnologyView2.setText(relevantTechnologies.get(1));
                break;
            case 3:
                holder.relevantTechnologyView1.setText(relevantTechnologies.get(0));
                holder.relevantTechnologyView2.setText(relevantTechnologies.get(1));
                holder.relevantTechnologyView3.setText(relevantTechnologies.get(2));
                break;
        }

        if(numTechnologies > 0)
            ButterKnife.apply(holder.relevantTechnologyViews.subList(0,numTechnologies),Constants.VISIBILITY_VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mProjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.projectTitleView) TextView projectTitleView;
        @BindView(R.id.projectDateView) TextView projectDateView;
        @BindView(R.id.projectDescriptionView) TextView projectDescriptionView;
        @BindView(R.id.relevantTechnologyView1) TextView relevantTechnologyView1;
        @BindView(R.id.relevantTechnologyView2) TextView relevantTechnologyView2;
        @BindView(R.id.relevantTechnologyView3) TextView relevantTechnologyView3;
        @BindViews({R.id.relevantTechnologyView1, R.id.relevantTechnologyView2, R.id.relevantTechnologyView3})
        List<TextView> relevantTechnologyViews;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
