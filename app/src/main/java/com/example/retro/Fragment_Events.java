package com.example.retro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Events extends Fragment {


   // private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      /*  btn = btn.findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivityTech();
            }
        });*/
        return inflater.inflate(R.layout.fragment_events,null);
    }

  /*  private void moveToActivityTech(){
        Intent intent = new Intent(getActivity().getApplication(),Tech.class);
        startActivity(intent);
    }*/
}
