package com.example.tabpagerfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentTab1 extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private List<String>         mData     = null;
    private ArrayAdapter<String> mAdapter  = null;
    private ListView             mListview = null;

    private View inflatedView = null;

    private Button   btnAdd   = null;
    private EditText edtInput = null;

    public FragmentTab1() {
        // Required empty public constructor
    }

    public static FragmentTab1 newInstance(String param1, String param2) {
        FragmentTab1 fragment = new FragmentTab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflatedView = inflater.inflate(R.layout.fragment_tab1, container, false);
        return inflatedView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // ListView 찾기
        // ArrayAdapter 생성
        // ListView와 ArrayAdapter 연결
        mListview = inflatedView.findViewById(R.id.list_view);
        mData = makeData();
        mAdapter = new ArrayAdapter<String>(getContext()
                                                                 , android.R.layout.simple_list_item_1
                                                                 , mData);
        mListview.setAdapter( mAdapter );

        edtInput = inflatedView.findViewById( R.id.edit_input);

        btnAdd   = inflatedView.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.add( edtInput.getText().toString() );
                mAdapter.notifyDataSetChanged();
                mListview.smoothScrollByOffset( mAdapter.getCount() - 1 - mListview.getHeaderViewsCount() );
            }
        });
    }

    private List<String> makeData() {
        List<String> data = new ArrayList<>();
        data.add("item 01");
        data.add("item 02");
        data.add("item 03");
        data.add("item 04");
        data.add("item 05");
        data.add("item 06");
        data.add("item 07");
        data.add("item 08");
        data.add("item 09");
        data.add("item 10");
        data.add("item 11");
        data.add("item 12");
        data.add("item 13");
        data.add("item 14");
        data.add("item 15");
        data.add("item 16");
        data.add("item 17");
        data.add("item 18");
        data.add("item 19");
        data.add("item 20");
        return data;
    }
}
