package com.profile.javondavis.sixsecond.ui.organization;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.profile.javondavis.R;
import com.profile.javondavis.models.WorkExperience;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 29/05/16.
 */
public class OrganizationAdapter extends RecyclerView.Adapter<OrganizationAdapter.ViewHolder> {

    private ArrayList<WorkExperience> mWorkExperiences;
    private Context mContext;

    public OrganizationAdapter(Context context, ArrayList<WorkExperience> workExperiences)
    {
        this.mWorkExperiences = workExperiences;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_organization, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WorkExperience workExperience = mWorkExperiences.get(position);

        // show position
        holder.organizationPositionView.setText(workExperience.getPosition());

        // show name of organization
        holder.organizationNameView.setText(workExperience.getEmployer());

        String end = workExperience.getEnd();
        String start = workExperience.getStart();

        if(!end.equals("present"))
        {
            holder.currentView.setVisibility(View.GONE);

            Resources res = mContext.getResources();
            String textForDurationView = String.format(res.getString(R.string.text_organization_duration), start, end);

            holder.organizationDurationView.setText(textForDurationView);
        }
        else
        {
            holder.organizationDurationView.setText(start);
        }

        List<String> responsibilities = workExperience.getResponsibilities();

        // holder.dutyViews is immutable since it is populated using ButterKnife
        // dutyViews is a mutable copy
        ArrayList<TextView> dutyViews = new ArrayList<>();
        dutyViews.addAll(holder.dutyViews);

        // check how many responsibilities and set them accordingly
        switch (responsibilities.size())
        {
            case 0:
                ButterKnife.apply(holder.dutyViews,VISIBILITY_GONE);
                break;
            case 1:
                holder.organizationDuty1View.setText(responsibilities.get(0));
                dutyViews.remove(0);
                ButterKnife.apply(dutyViews,VISIBILITY_GONE);
                break;
            case 2:
                holder.organizationDuty1View.setText(responsibilities.get(0));
                dutyViews.remove(0);
                holder.organizationDuty2View.setText(responsibilities.get(1));
                dutyViews.remove(0);
                ButterKnife.apply(dutyViews,VISIBILITY_GONE);
                break;
            case 3:
                holder.organizationDuty1View.setText(responsibilities.get(0));
                dutyViews.remove(0);
                holder.organizationDuty2View.setText(responsibilities.get(1));
                dutyViews.remove(0);
                holder.organizationDuty3View.setText(responsibilities.get(2));
                dutyViews.remove(0);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mWorkExperiences.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        @Bind(R.id.organizationTitleView) TextView organizationNameView;
        @Bind(R.id.positionView) TextView organizationPositionView;
        @Bind(R.id.organizationDurationView) TextView organizationDurationView;
        @Bind(R.id.organizationDuty1) TextView organizationDuty1View;
        @Bind(R.id.organizationDuty2) TextView organizationDuty2View;
        @Bind(R.id.organizationDuty3) TextView organizationDuty3View;
        @Bind({R.id.organizationDuty1,R.id.organizationDuty2,R.id.organizationDuty3})
        List<TextView> dutyViews;
        @Bind(R.id.currentlyView) TextView currentView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static final ButterKnife.Action<View> VISIBILITY_GONE = new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
            view.setVisibility(View.GONE);
        }
    };
}
