package com.example.expandableforum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<String> listDataHeader;
    private Map<String, List<Forum>> listDataChild;
    private String header;
    private ForumAdapter listAdapter;
    private ExpandableListView expListView;
    private List<Forum> generalList;
    private List<Forum> offTopicList;


    private void setValue(List<Forum> forums) {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Forum>>();

        String previous_header = null;

        for (int i = 0; i < forums.size(); i++) {
            header = forums.get(i).getCategory();
            if (!header.equals(previous_header)) {
                listDataHeader.add(forums.get(i).getCategory());
            }

            if (header.equals("General")) {
                generalList.add(forums.get(i));
            } else
                offTopicList.add(forums.get(i));

            previous_header = header;
        }

        listDataChild.put(listDataHeader.get(0), generalList);
        listDataChild.put(listDataHeader.get(1), offTopicList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generalList = new ArrayList<>();
        offTopicList = new ArrayList<>();

        List<Forum> forums = new ArrayList<>();
        forums.add(new Forum("General", 2, "News and Announcements"));
        forums.add(new Forum("General", 0, "Support"));
        forums.add(new Forum("General", 0, "Suggestions"));

        forums.add(new Forum("Off-Topic", 0, "Off-Topic Discussions"));
        forums.add(new Forum("Off-Topic", 0, "Introduce Yourself"));

        setValue( forums );

        listAdapter = new ForumAdapter(this, listDataHeader, listDataChild);

        // view 찾기.
        expListView = (ExpandableListView)findViewById(R.id.forumList);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,int childPosition, long id) {
                return false;
            }
        });
    }

}
