package com.example.radiobuttonsingleselection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.radiobuttonsingleselectionUserModel.UserModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<UserModel> users = new ArrayList<>();
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        users.add(new UserModel("A", false));
        users.add(new UserModel("B", false));
        users.add(new UserModel("C", false));
        users.add(new UserModel("D", false));
        users.add(new UserModel("E", false));
        users.add(new UserModel("q", false));
        users.add(new UserModel("w", false));
        users.add(new UserModel("w", false));
        users.add(new UserModel("w", false));
        users.add(new UserModel("w", false));
        users.add(new UserModel("w", false));
        users.add(new UserModel("w", false));
        users.add(new UserModel("w", false));
        users.add(new UserModel("w", false));
        users.add(new UserModel("A", false));
        users.add(new UserModel("B", false));
        users.add(new UserModel("C", false));
        users.add(new UserModel("D", false));
        users.add(new UserModel("E", false));
        users.add(new UserModel("q", false));

        userAdapter = new UserAdapter(users);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(userAdapter);

        Log.e("yy","ppp");

    }

    public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
        private List<UserModel> listdata;
        int currentIndex = -1;

        // RecyclerView recyclerView;
        public UserAdapter(List<UserModel> listdata)
        {
            this.listdata = listdata;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            UserModel myListData = getItem(position);

            holder.radio_btn.setText(myListData.getName());

            holder.radio_btn.setChecked(currentIndex == position);
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public UserModel getItem(int position) {
            return listdata.get(position);
        }

        public int getItemCount() {
            return listdata.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            RadioButton radio_btn;

            public ViewHolder(View itemView) {
                super(itemView);
                radio_btn = itemView.findViewById(R.id.radio_btn);
                this.setIsRecyclable(true);

                radio_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        int p1 = currentIndex;
                        currentIndex = getAdapterPosition();
                        notifyItemChanged(p1);
                    }
                });
            }
        }
    }
}

