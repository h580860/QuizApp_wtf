package com.example.quizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ImageViewHolder>{

    private List<Upload> mUpl;
    private Context mCont;

    public PictureAdapter(Context context, List<Upload> uploads) {
        mUpl = uploads;
        mCont = context;
    }

    //generated stuff
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view2electribogaloo = LayoutInflater.from(mCont).inflate(R.layout.picture_display, parent, false);
        return new ImageViewHolder(view2electribogaloo);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Upload uploadCur = mUpl.get(position);
        holder.textViewname.setText(uploadCur.getName());
        Picasso.with(mCont).load(uploadCur.getImageUrl()).fit().centerCrop().into(holder.imageViewname);

    }

    @Override
    public int getItemCount() {
       return mUpl.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewname;
        public ImageView imageViewname;


        public ImageViewHolder(View itemView) {

            super(itemView);

            textViewname = itemView.findViewById(R.id.text_picture_name);
            imageViewname = itemView.findViewById(R.id.picture_view_entry);
        }
    }

}
