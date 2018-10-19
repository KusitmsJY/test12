package com.example.fragmenttransaction;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment {

    public static final String KEY_INPUT = "fragment one";
    private String inputtext = "";

    public FragmentOne() {
        // Required empty public constructor
    }

    public static FragmentOne newInstance(String input ){
        FragmentOne fragment = new FragmentOne();

        Bundle b = new Bundle();
        b.putString( KEY_INPUT, input );
        fragment.setArguments( b );

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activity에서 넘겨 받은 Bundle에서 값을 추출하기.
        Bundle b = getArguments();
        inputtext = b.getString( KEY_INPUT );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

}
