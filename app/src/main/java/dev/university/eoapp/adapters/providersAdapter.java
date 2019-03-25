package dev.university.eoapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import dev.university.eoapp.R;
import dev.university.eoapp.models.Provider;

import java.util.List;

public class providersAdapter extends RecyclerView.Adapter<providersAdapter.providersViewHolder> {

    private Context mCtx;
    private List<Provider> providers;

    public providersAdapter(Context mCtx, List<Provider> providers) {
        this.mCtx = mCtx;
        this.providers = providers;
    }

    @NonNull
    @Override
    public providersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_categories, parent, false);
        return new providersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull providersViewHolder holder, int position) {
        final Provider provider = providers.get(position);

        holder.textViewName.setText(provider.getEmail());
        holder.textViewEmail.setText(provider.getPhoneNumber());

        holder.request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




//
                //  mCtx.sendBroadcast(new Intent("start.fragment_myitem.action").putExtra("id", user.getId()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return providers.size();
    }

    class providersViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewEmail, textViewSchool;
        ImageView seen,notseen;
        LinearLayout request;

        public providersViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewtitle);
            textViewEmail = itemView.findViewById(R.id.textViewdate);

            request = itemView.findViewById(R.id.request);

        }
    }
}
