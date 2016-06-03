package com.profile.javondavis.fullportfolio.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.profile.javondavis.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 02/06/2016.
 */

public class ExperienceViewHolder extends RecyclerView.ViewHolder
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
    @Bind(R.id.linksButton) Button linksButton;

    public ExperienceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
