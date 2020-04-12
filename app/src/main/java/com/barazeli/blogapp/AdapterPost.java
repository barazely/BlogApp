package com.barazeli.blogapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.ViewHolder> {
    private Context context;
    private List<Blog> blogs;

    public AdapterPost(Context context, List<Blog> blogs) {
        this.context = context;
        this.blogs = blogs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_post,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Blog blog=blogs.get(position);
        holder.comment.setText(blog.getComment());
        java.text.DateFormat dateFormat= java.text.DateFormat.getDateInstance();
        String df=dateFormat.format(new Date(Long.valueOf(blog.getDate_post())));
        holder.date_post.setText(df);
        Picasso.with(context).load(blog.getImage())
                .into(holder.imgBlog);


    }

    @Override
    public int getItemCount() {
        return blogs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imgBlog;
        public TextView comment,date_post;
        String uid;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBlog=itemView.findViewById(R.id.img_post);
            comment=itemView.findViewById(R.id.txt_post_comment);
            date_post=itemView.findViewById(R.id.date_post);
            uid=null;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

        }
    }
}
