package com.profile.javondavis.fullportfolio.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.profile.javondavis.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 02/06/2016.
 */

public class ExperienceViewHolder extends RecyclerView.ViewHolder
{

    @BindView(R.id.organizationTitleView) public TextView organizationNameView;
    @BindView(R.id.positionView) public TextView organizationPositionView;
    @BindView(R.id.organizationDurationView) public TextView organizationDurationView;
    @BindView(R.id.organizationDuty1) public TextView organizationDuty1View;
    @BindView(R.id.organizationDuty2) public TextView organizationDuty2View;
    @BindView(R.id.organizationDuty3) public TextView organizationDuty3View;
    @BindViews({R.id.organizationDuty1,R.id.organizationDuty2,R.id.organizationDuty3})
    public List<TextView> dutyViews;
    @BindView(R.id.currentlyView) public TextView currentView;
    @BindView(R.id.linksButton) public Button linksButton;

    public ExperienceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
