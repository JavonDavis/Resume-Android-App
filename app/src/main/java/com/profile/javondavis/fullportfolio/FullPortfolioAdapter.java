package com.profile.javondavis.fullportfolio;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.profile.javondavis.R;
import com.profile.javondavis.fullportfolio.viewholders.AwardViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.CertificationViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.EducationViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.ExperienceViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.HeaderViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.ProjectViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.SectionHeaderViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.SkillViewHolder;
import com.profile.javondavis.helpers.ListItem;

import java.util.ArrayList;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 02/06/2016.
 */

public class FullPortfolioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String LOG_TAG = "FullPortfolioAdapter";
    private ArrayList<? extends ListItem> mItems;

    public FullPortfolioAdapter(ArrayList<? extends ListItem> items) {
        this.mItems = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        switch (viewType)
        {
            case ListItem.VIEW_TYPE_HEADER:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.profile_list_item_header, parent, false);
                return new HeaderViewHolder(v);
            case ListItem.VIEW_TYPE_SECTION_HEADER:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.profile_list_item_section_header, parent, false);
                return new SectionHeaderViewHolder(v);
            case ListItem.VIEW_TYPE_SKILLS:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.profile_list_item_skills, parent, false);
                return new SkillViewHolder(v);
            case ListItem.VIEW_TYPE_AWARD:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.profile_list_item_award, parent, false);
                return new AwardViewHolder(v);
            case ListItem.VIEW_TYPE_CERTIFICATION:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.profile_list_item_certification, parent, false);
                return new CertificationViewHolder(v);
            case ListItem.VIEW_TYPE_EDUCATION:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.profile_list_item_education, parent, false);
                return new EducationViewHolder(v);
            case ListItem.VIEW_TYPE_PROJECT:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.profile_list_item_project, parent, false);
                return new ProjectViewHolder(v);
            case ListItem.VIEW_TYPE_EXPERIENCE:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.profile_list_item_experience, parent, false);
                return new ExperienceViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderViewHolder)
        {
            HeaderViewHolder viewHolder = (HeaderViewHolder) holder;
        }
        else if (holder instanceof SectionHeaderViewHolder)
        {
            SectionHeaderViewHolder viewHolder = (SectionHeaderViewHolder) holder;
        }
        else if (holder instanceof SkillViewHolder)
        {
            SkillViewHolder viewHolder = (SkillViewHolder) holder;
        }
        else if (holder instanceof EducationViewHolder)
        {
            EducationViewHolder viewHolder = (EducationViewHolder) holder;
        }
        else if(holder instanceof ProjectViewHolder)
        {
            ProjectViewHolder viewHolder = (ProjectViewHolder) holder;
        }
        else if(holder instanceof ExperienceViewHolder)
        {
            ExperienceViewHolder viewHolder = (ExperienceViewHolder) holder;
        }
        else if(holder instanceof CertificationViewHolder)
        {
            Log.e(LOG_TAG, "ViewHolder for Certification not implemented as yet");
        }
        else if(holder instanceof AwardViewHolder)
        {
            Log.e(LOG_TAG, "ViewHolder for Award not implemented as yet");
        }
        else
        {
            Log.e(LOG_TAG, "No Valid ViewHolder found for item");
        }
    }

    @Override
    public int getItemCount() {
        return ListItem.ITEM_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getViewType();
    }
}

