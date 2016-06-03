package com.profile.javondavis.fullportfolio.viewholders;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.profile.javondavis.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 02/06/2016.
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder
{
    @Bind(R.id.profile_picture) ImageView picture;
    @Bind(R.id.nameTextView) TextView nameTextView;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}