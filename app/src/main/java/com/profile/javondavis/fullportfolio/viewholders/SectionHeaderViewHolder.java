package com.profile.javondavis.fullportfolio.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.profile.javondavis.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 02/06/2016.
 */

public class SectionHeaderViewHolder extends RecyclerView.ViewHolder
{

    @BindView(R.id.sectionHeader) public TextView sectionHeaderView;

    public SectionHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
