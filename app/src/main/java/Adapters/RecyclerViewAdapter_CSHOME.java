package Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.lambda.iith.dashboard.MainActivity;
import com.lambda.iith.dashboard.R;

import java.util.ArrayList;


public class RecyclerViewAdapter_CSHOME extends RecyclerView.Adapter<RecyclerViewAdapter_CSHOME.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";


    private ArrayList<String> mEmails = new ArrayList<>();


    private Context mContext;

    public RecyclerViewAdapter_CSHOME(Context context, ArrayList<String> Emails) {


        mEmails = Emails;
        mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cs_entry_home, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");


        holder.Name.setText(mEmails.get(position));


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.bottomNavigationView.setSelectedItemId(R.id.nav_acad_info);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mEmails.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView Name, mobile, email;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.name);

            // email = itemView.findViewById(R.id.email);
            parentLayout = itemView.findViewById(R.id.ParentLayout);
        }
    }
}