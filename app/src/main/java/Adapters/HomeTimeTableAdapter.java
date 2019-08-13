package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lambda.iith.dashboard.MainActivity;
import com.lambda.iith.dashboard.R;

import java.util.ArrayList;

import Model.Lecture;


public class HomeTimeTableAdapter extends RecyclerView.Adapter<HomeTimeTableAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Lecture> mCourse = new ArrayList<>();
    private ArrayList<String> mTime1 = new ArrayList<>();
    private ArrayList<String> mTime2 = new ArrayList<>();

    private Context mContext;

    public HomeTimeTableAdapter(Context context, ArrayList<Lecture> Names, ArrayList<String> Emails  , ArrayList<String> Time2 ) {
        mCourse = Names;

        mTime1 = Emails;
        mTime2 = Time2;
        mContext = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.timetable_home_recycler, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");



        holder.course.setText(mCourse.get(position).getCourse());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.bottomNavigationView.setSelectedItemId(R.id.nav_acads);
            }
        });
        if(!mTime1.get(position).isEmpty()) {
            holder.time.setText(mTime1.get(position) + " to " + mTime2.get(position));
        }
        else{
            holder.time.setVisibility(View.GONE);

        }
        System.out.println("XXX");



    }

    @Override
    public int getItemCount() {
        return mCourse.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView course , time;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            course= itemView.findViewById(R.id.CourseName);

            time = itemView.findViewById(R.id.CourseTime);
            parentLayout = itemView.findViewById(R.id.HomeTimeTableParent);
        }
    }
}