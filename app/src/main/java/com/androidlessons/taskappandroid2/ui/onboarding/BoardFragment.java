package com.androidlessons.taskappandroid2.ui.onboarding;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidlessons.taskappandroid2.R;
import com.androidlessons.taskappandroid2.models.BoardItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class BoardFragment extends Fragment {

    private Button btnSkip;
    private Button btnStart;
    private  List<BoardItem> boardItemList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSkip = view.findViewById(R.id.btn_skip);
        btnStart = view.findViewById(R.id.btn_start);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);

        setupBoard();

        BoardAdapter adapter = new BoardAdapter(boardItemList);
        viewPager.setAdapter(adapter);




        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btn_skip || view.getId() == R.id.btn_start) {
                    NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                    navController.navigateUp();
                }

            }
        };

        btnStart.setOnClickListener(onClickListener);
        btnSkip.setOnClickListener(onClickListener);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

            }
        }).attach();


        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == boardItemList.size()-1) {
                    btnSkip.setVisibility(View.GONE);
                    btnStart.setVisibility(View.VISIBLE);
                }else {
                    btnSkip.setVisibility(View.VISIBLE);
                    btnStart.setVisibility(View.INVISIBLE);
                }
            }
        });






        // при нажатии кнопки назад выходит из приложения

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });

    }

    private void setupBoard() {
        BoardItem itemFirst = new BoardItem(R.drawable.ic_add_tasks, "Add tasks", "You don't have to remember all things to do");

        BoardItem itemSecond = new BoardItem(R.drawable.ic_priorities, "Set priorities", "Choose what is more important to you at this time");
        BoardItem itemthird = new BoardItem(R.drawable.ic_be_productive, "Be productive", "You don't have to worry you've forgotten something");
        boardItemList.add(itemFirst);
        boardItemList.add(itemSecond);
        boardItemList.add(itemthird);
    }


}