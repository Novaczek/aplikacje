package com.example.lekcja12_recyclerview3;

import android.view.LayoutInflater;
import android.widget.Toast;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User currentUser = userList.get(position);
        holder.firstNameText.setText(currentUser.getFirstName());
        holder.lastNameText.setText(currentUser.getLastName());

        int imageResId = holder.itemView.getContext().getResources().getIdentifier(
                currentUser.getImageId(),
                "drawable",
                holder.itemView.getContext().getPackageName()
        );

        holder.imageView.setImageResource(imageResId);

        holder.imageView.setOnClickListener(v ->{
            Toast.makeText(
                    v.getContext(),currentUser.getFirstName() + " " + currentUser.getLastName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView firstNameText;
        public TextView lastNameText;
        public ImageView imageView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            firstNameText = itemView.findViewById(R.id.firstNameText);
            lastNameText = itemView.findViewById(R.id.lastNameText);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
