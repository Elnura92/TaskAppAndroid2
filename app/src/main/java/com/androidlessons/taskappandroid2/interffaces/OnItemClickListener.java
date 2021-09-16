package com.androidlessons.taskappandroid2.interffaces;

import java.util.UUID;

public interface OnItemClickListener {

    void onClick(int position);
    void onLongClick(UUID taskId);

}
