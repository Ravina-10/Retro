package com.example.retro;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Fragment_Home extends Fragment {
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    ArrayList<imageWinnerModel> showlist;
    RecyclerView rec;
    imageWinnerRec adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,null);
//        return inflater.inflate(R.layout.fragment_home,null);
        firebaseStorage=FirebaseStorage.getInstance();
        rec=view.findViewById(R.id.recimag);
        swipeRefreshLayout=view.findViewById(R.id.swipe);
        storageReference=firebaseStorage.getReference("winnerpics");
        showlist=new ArrayList<imageWinnerModel>();
        adapter=new imageWinnerRec(getContext(),showlist);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        rec.setAdapter(adapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.blue,
                R.color.green, R.color.orange, R.color.purple);
       swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               loadimages();
           }
       });
        loadimages();
        return view;
    }
    void loadimages(){
        storageReference.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override

            public void onSuccess(ListResult listResult) {
                showlist.clear();
                for (final StorageReference item : listResult.getItems()) {
                    item.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(final Uri uri) {

                            item.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
                                @Override
                                public void onSuccess(StorageMetadata storageMetadata) {
                                    imageWinnerModel im=new imageWinnerModel();
                                    im.setImagename(item.getName());
                                    im.setImageurl(uri.toString());
                                    Date d=new Date(storageMetadata.getCreationTimeMillis());
                                    im.setDate(d);
                                    showlist.add(im);
                                    adapter.update(showlist);
                                    adapter.notifyDataSetChanged();
                                }
                            });
                        }

                    });

                }
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
