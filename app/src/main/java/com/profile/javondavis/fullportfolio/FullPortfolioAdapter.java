package com.profile.javondavis.fullportfolio;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.profile.javondavis.R;
import com.profile.javondavis.fullportfolio.viewholders.AwardViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.CertificationViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.EducationViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.ExperienceViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.HeaderViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.ProjectViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.SectionHeaderViewHolder;
import com.profile.javondavis.fullportfolio.viewholders.SkillViewHolder;
import com.profile.javondavis.helpers.Constants;
import com.profile.javondavis.helpers.HeaderListItem;
import com.profile.javondavis.helpers.ListItem;
import com.profile.javondavis.helpers.SectionHeaderListItem;
import com.profile.javondavis.models.Education;
import com.profile.javondavis.models.Project;
import com.profile.javondavis.models.Skills;
import com.profile.javondavis.models.WorkExperience;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 02/06/2016.
 */

class FullPortfolioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String LOG_TAG = "FullPortfolioAdapter";
    private ArrayList<? extends ListItem> mItems;
    private Context mContext;

    private String mStatus = "is pursuing"; // default status
    private String gStatus = "is graduating"; // default graduation status

    private String mFirstName;

    private boolean addCourseViews = true;

    int proficientIndex = 0;
    int familiarIndex = 0;

    FullPortfolioAdapter(String firstname, Context context, ArrayList<? extends ListItem> items) {
        this.mItems = items;
        this.mContext = context;
        this.mFirstName = firstname;
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
            HeaderListItem item = (HeaderListItem) mItems.get(position);

            Glide
                    .with(mContext)
                    .load(item.getPictureUrl())
                    .into(viewHolder.picture);

            viewHolder.nameTextView.setText(item.getName());
        }
        else if (holder instanceof SectionHeaderViewHolder)
        {
            SectionHeaderViewHolder viewHolder = (SectionHeaderViewHolder) holder;
            SectionHeaderListItem item = (SectionHeaderListItem) mItems.get(position);

            viewHolder.sectionHeaderView.setText(item.getTitle());
        }
        else if (holder instanceof SkillViewHolder)
        {
            SkillViewHolder viewHolder = (SkillViewHolder) holder;
            Skills skills = (Skills) mItems.get(position).getModel();

            View row;

            int proficientSize = skills.getProficient().size();
            int familiarSize = skills.getFamiliar().size();

            boolean skillAvailable;

            do
            {
                skillAvailable = false;
                row = LayoutInflater.from(mContext)
                        .inflate(R.layout.skills_table_row,viewHolder.skillsTable,false);
                TextView skillView;

                if(proficientIndex < proficientSize)
                {
                    skillView = (TextView) row.findViewById(R.id.proficientView);
                    skillView.setText(skills.getProficient().get(proficientIndex));
                    skillAvailable = true;
                    proficientIndex++;
                }

                if(familiarIndex < familiarSize)
                {
                    skillView = (TextView) row.findViewById(R.id.familiarView);
                    skillView.setText(skills.getFamiliar().get(familiarIndex));
                    skillAvailable = true;
                    familiarIndex++;
                }

                if(skillAvailable)
                {
                    viewHolder.skillsTable.addView(row);
                }
            }while (skillAvailable);
        }
        else if (holder instanceof EducationViewHolder)
        {
            EducationViewHolder viewHolder = (EducationViewHolder) holder;
            Education mEducation = (Education) mItems.get(position).getModel();

            Resources res = mContext.getResources();

            // Fill in text for "<Firstname> <received/is pursuing> a" TextView
            processStatus(mEducation); // sets mStatus to either received or is pursuing and gStatus to either
            //graduating or graduated

            String textForEducationView1 = String.format(res.getString(R.string.text_education_1), mFirstName,mStatus);
            viewHolder.educationTextView1.setText(textForEducationView1);

            // Fill in text for "<degree title> in <area of study>" TextView
            String degreeTitle = mEducation.getDegree();
            String areaOfStudy = mEducation.getStudy();

            String textForEducationView2 = String.format(res.getString(R.string.text_education_2), degreeTitle,areaOfStudy);
            viewHolder.educationTextView2.setText(textForEducationView2);

            // Fill in University name
            viewHolder.educationUniversityNameView.setText(mEducation.getName());

            // Fill in graduation
            String textForEducationGraduationView = String.format(res.getString(R.string.text_graduate_date), gStatus, mEducation.getEnd());

            viewHolder.educationDateView.setText(textForEducationGraduationView);

            //Fill in major and minor
            String textForMajorView = String.format(res.getString(R.string.text_major_1), mEducation.getMajor());
            String textForMinorView = String.format(res.getString(R.string.text_minor_1), mEducation.getMinor());

            viewHolder.educationMajor1View.setText(textForMajorView);
            viewHolder.educationMinor1View.setText(textForMinorView);

            LinearLayout courseContainer = viewHolder.educationCourseContainer;
            TableLayout courseTable = viewHolder.educationCourseList;

            if(mEducation.getCourses().isEmpty())
            {
                courseContainer.setVisibility(View.GONE);
            }
            else if(addCourseViews)
            {
                for (String course:mEducation.getCourses())
                {
                    TextView courseView = new TextView(mContext);
                    courseView.setText(course);
                    courseTable.addView(courseView);
                }
                addCourseViews = false;
            }
        }
        else if(holder instanceof ProjectViewHolder)
        {
            ProjectViewHolder viewHolder = (ProjectViewHolder) holder;
            Project project = (Project) mItems.get(position).getModel();

            viewHolder.projectTitleView.setText(project.getTitle());
            viewHolder.projectDateView.setText(project.getDate());
            viewHolder.projectDescriptionView.setText(project.getDescription());

            ArrayList<String> relevantTechnologies = project.getTags();

            // check how many relevant technologies and set them accordingly

            //limited to 3 for now
            int numTechnologies = relevantTechnologies.size();
            numTechnologies = numTechnologies >3 ? 3: numTechnologies;

            switch (numTechnologies)
            {
                case 1:
                    viewHolder.relevantTechnologyView1.setText(relevantTechnologies.get(0));
                    break;
                case 2:
                    viewHolder.relevantTechnologyView1.setText(relevantTechnologies.get(0));
                    viewHolder.relevantTechnologyView2.setText(relevantTechnologies.get(1));
                    break;
                case 3:
                    viewHolder.relevantTechnologyView1.setText(relevantTechnologies.get(0));
                    viewHolder.relevantTechnologyView2.setText(relevantTechnologies.get(1));
                    viewHolder.relevantTechnologyView3.setText(relevantTechnologies.get(2));
                    break;
            }

            if(numTechnologies > 0)
                ButterKnife.apply(viewHolder.relevantTechnologyViews.subList(0,numTechnologies),Constants.VISIBILITY_VISIBLE);
        }
        else if(holder instanceof ExperienceViewHolder)
        {
            ExperienceViewHolder viewHolder = (ExperienceViewHolder) holder;
            WorkExperience workExperience = (WorkExperience) mItems.get(position).getModel();

            // show position
            viewHolder.organizationPositionView.setText(workExperience.getPosition());

            // show name of organization
            viewHolder.organizationNameView.setText(workExperience.getEmployer());

            String end = workExperience.getEnd();
            String start = workExperience.getStart();

            if(!end.equals("present"))
            {
                viewHolder.currentView.setVisibility(View.GONE);

                Resources res = mContext.getResources();
                String textForDurationView = String.format(res.getString(R.string.text_organization_duration), start, end);

                viewHolder.organizationDurationView.setText(textForDurationView);
            }
            else
            {
                viewHolder.organizationDurationView.setText(start);
            }

            List<String> responsibilities = workExperience.getResponsibilities();

            // holder.dutyViews is immutable since it is populated using ButterKnife
            // dutyViews is a mutable copy
            ArrayList<TextView> dutyViews = new ArrayList<>();
            dutyViews.addAll(viewHolder.dutyViews);

            // check how many responsibilities and set them accordingly
            switch (responsibilities.size())
            {
                case 0:
                    ButterKnife.apply(viewHolder.dutyViews, Constants.VISIBILITY_VISIBLE);
                    break;
                case 1:
                    viewHolder.organizationDuty1View.setText(responsibilities.get(0));
                    dutyViews.remove(0);
                    ButterKnife.apply(dutyViews,Constants.VISIBILITY_VISIBLE);
                    break;
                case 2:
                    viewHolder.organizationDuty1View.setText(responsibilities.get(0));
                    dutyViews.remove(0);
                    viewHolder.organizationDuty2View.setText(responsibilities.get(1));
                    dutyViews.remove(0);
                    ButterKnife.apply(dutyViews,Constants.VISIBILITY_VISIBLE);
                    break;
                case 3:
                    viewHolder.organizationDuty1View.setText(responsibilities.get(0));
                    dutyViews.remove(0);
                    viewHolder.organizationDuty2View.setText(responsibilities.get(1));
                    dutyViews.remove(0);
                    viewHolder.organizationDuty3View.setText(responsibilities.get(2));
                    dutyViews.remove(0);
                    break;
            }
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

    private void processStatus(Education mEducation)
    {
        Date endDate = Constants.getDateFromString(LOG_TAG, mEducation.getEnd());

        if(endDate != null)
        {
            if(Constants.isDateAfterToday(endDate))
            {
                mStatus = "is pursuing";
                gStatus = "is graduating";
            }
            else
            {
                mStatus = "received";
                gStatus = "graduated";
            }
        }
        else
        {
            Log.d(LOG_TAG, "endDate was null after parsing defaulting to 'is pursing'");
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getViewType();
    }
}

