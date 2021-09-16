package com.androidlessons.taskappandroid2.ui.onboarding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlessons.taskappandroid2.R;
import com.androidlessons.taskappandroid2.models.BoardItem;

import java.util.ArrayList;
import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private List<BoardItem> boardItemList = new ArrayList<>();

    public BoardAdapter(List<BoardItem> boardItemList) {
        this.boardItemList = boardItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_board, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(boardItemList.get(position));

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private TextView textDesc;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.tvBoardTitle);
            textDesc= itemView.findViewById(R.id.tv_descrip);
            imageView = itemView.findViewById(R.id.imgBoard);



        }


        public void bind(BoardItem boardItem) {

            textTitle.setText(boardItem.getTitle());
            textDesc.setText(boardItem.getDescription());
            imageView.setImageResource(boardItem.getImageView());

        }
    }



}
