package com.rz.customnavigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragTutorial extends Fragment {
    private Activity activity;
    private Context context;

    public static FragTutorial newInstance(String title) {
        FragTutorial fragment = new FragTutorial();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater argInflater, ViewGroup argContainer, Bundle argSavedInstanceState) {
        //|------------------------------------------------------------|
        View rootView = argInflater.inflate(R.layout.frag_tutorial, argContainer, false);
        return rootView;
    }
}
