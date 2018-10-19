package com.example.actor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.actor.model.ModelActor;
import com.example.actor.model.ModelComment;
import com.example.actor.model.ModelDrama;
import com.example.actor.model.ModelMovie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    ListView listview = null;
    private AdapterActor adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯찾기
        listview = findViewById(R.id.listView5 );

        // 위젯 설정. 리스너 포함. 없음.

        // 데이터 만들기
        ModelActor data = makeData();;

        // adapter 만들기
        adapter = new AdapterActor(MainActivity.this, data );

        // listview와 adapter 연결하기
        listview.setAdapter( adapter );
    }

    private ModelActor makeData() {
        ModelActor actor  = new ModelActor();
        actor.setImagePhoto( getResources().getDrawable(R.drawable.sample_0, null) );
        actor.setTextAge( "42" ) ;
        actor.setTextName("ysi");
        actor.setTextDescription("desc......");

        List<ModelMovie> movies = new ArrayList<>();
        movies.add( new ModelMovie(getResources().getDrawable(R.drawable.sample_1), "movie title 1", "2015") );
        movies.add( new ModelMovie(getResources().getDrawable(R.drawable.sample_2), "movie title 2", "2016") );
        movies.add( new ModelMovie(getResources().getDrawable(R.drawable.sample_3), "movie title 3", "2017") );

        // actor에 movies 추가하기
        actor.setMovies( movies );

        List<ModelDrama> dramas = new ArrayList<>();
        dramas.add( new ModelDrama(getResources().getDrawable(R.drawable.sample_4), "drama title 1", "1~3") );
        dramas.add( new ModelDrama(getResources().getDrawable(R.drawable.sample_5), "drama title 1", "4~6") );

        // actor에 dramas 추가하기
        actor.setDramas( dramas );

        List<ModelComment> comments = new ArrayList<>();
        comments.add( new ModelComment("comments ... 1", "writer 1") );
        comments.add( new ModelComment("comments ... 2", "writer 2") );

        // actor에 comments 추가하기
        actor.setComments( comments );

        return actor;
    }
}
