package com.example.actor;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.actor.model.ModelActor;
import com.example.actor.model.ModelComment;
import com.example.actor.model.ModelDrama;
import com.example.actor.model.ModelMovie;
import com.example.actor.view.ViewActor;
import com.example.actor.view.ViewComment;
import com.example.actor.view.ViewDrama;
import com.example.actor.view.ViewMovie;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterActor extends ArrayAdapter {

    // ViewType 선언.
    public static final  int VIEW_TYPE_ACTOR   = 0;
    public static final  int VIEW_TYPE_TITLE   = 1;
    public static final  int VIEW_TYPE_MOVIE   = 2;
    public static final  int VIEW_TYPE_DRAMA   = 3;
    public static final  int VIEW_TYPE_COMMENT = 4;

    // Adapter 데이터 설정
    private ModelActor actor;

    public ModelActor getActor() {
        return actor;
    }

    public void setActor(ModelActor actor) {
        this.actor = actor;

        // 앱 실행중 데이터 변경시 화면 새로고침.
        notifyDataSetChanged();
    }

    private final Context context;
    private final LayoutInflater inflater;

    public AdapterActor(@NonNull Context context) {
        super(context, -1);

        this.context = context;
        this.inflater = LayoutInflater.from( context );
    }

    public AdapterActor(@NonNull Context context, ModelActor actor) {
        super(context, -1);

        this.context = context;
        this.actor   = actor;
        this.inflater = LayoutInflater.from( context );
    }

    @Override
    public int getCount() {
        // title 이 추가되면서 갯수 변경되는 문제가 발생.
        // 따라서, title 갯수를 빼주어야 된다.
        int count = 0;

        // actor 갯수 계산
        if( actor == null )
            return 0;
        else
            count = count + 1;

        // movie 갯수 계산
        if( actor.getMovies().size() > 0 ) {
            // 1 : title 갯수
            count = count + (  1  + actor.getMovies().size()  );
        }

        // drama 갯수 계산
        if( actor.getDramas().size() > 0 ) {
            // 1 : title 갯수
            count = count + (  1  + actor.getDramas().size()  );
        }

        // comment 갯수 계산
        if( actor.getComments().size() > 0 ) {
            // 1 : title 갯수
            count = count + (  1  + actor.getComments().size()  );
        }

        return count;
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }


    @Override
    public int getItemViewType(int position) {
        int VIEW_TYPE = -1;

        if(position == 0)
            return VIEW_TYPE_ACTOR;

        position = position -1; // actor 때문에 -1

        if( actor.getMovies().size() > 0 ) {
            if( position == 0 ) {
                return VIEW_TYPE_TITLE;
            }

            position = position -1 ; // movie의 title  때문에 -1

            if( position  < actor.getMovies().size() ) {
                return VIEW_TYPE_MOVIE;
            }

            position = position - actor.getMovies().size();
        }

        if( actor.getDramas().size() > 0 ) {
            if( position == 0 ) {
                return VIEW_TYPE_TITLE;
            }

            position = position -1 ; // drama의 title  때문에 -1

            if( position  < actor.getDramas().size() ) {
                return VIEW_TYPE_DRAMA;
            }

            position = position - actor.getDramas().size();
        }

        if( actor.getComments().size() > 0 ) {
            if( position == 0 ) {
                return VIEW_TYPE_TITLE;
            }

            position = position -1 ; // comment의 title  때문에 -1

            if( position  < actor.getComments().size() ) {
                return VIEW_TYPE_COMMENT;
            }

            position = position - actor.getComments().size();
        }

        return VIEW_TYPE;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        if( position == 0 ) {
            return actor;
        }
        position = position  -1 ;  // position == 0

        if( actor.getMovies().size() > 0 ){
            if( position == 0 ) {
                return "Movie ...";  // movie의 타이틀값을 리턴.
            }
            position = position - 1; // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0

            if( position< actor.getMovies().size() ) {
                return actor.getMovies().get( position );
            }
            position = position - actor.getMovies().size();  // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0
        }

        if( actor.getDramas().size() > 0 ){
            if( position == 0 ) {
                return "Drama ...";  // drama의 타이틀값을 리턴.
            }
            position = position - 1; // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0

            if( position< actor.getDramas().size() ) {
                return actor.getDramas().get( position );
            }
            position = position - actor.getDramas().size();  // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0
        }

        if( actor.getComments().size() > 0 ){
            if( position == 0 ) {
                return "Comment ...";  // comment의 타이틀값을 리턴.
            }
            position = position - 1; // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0

            if( position< actor.getComments().size() ) {
                return actor.getComments().get( position );
            }
            position = position - actor.getComments().size();  // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0
        }

        return null;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if( position == 0 ) {
            ViewActor view = null;

            if( convertView!=null && convertView instanceof ViewActor ) {
                view = (ViewActor) convertView;
            }
            else {
                // inflation
                view = new ViewActor( parent.getContext() );
            }

            // 데이터 입력 & 화면 새로 고침.
            view.setActor( actor );

            return view;
        }

        // position 의 0점 조정.
        position = position -1; // -1 : actor 로우를 제거하기 위한 것.

        if( actor.getMovies().size() > 0 ){

            // movie의 title 처리
            if( position == 0 ) { // title

                TextView view;
                if( convertView != null && convertView instanceof TextView ) {
                    view = (TextView) convertView;
                }
                else {
                    view = (TextView) inflater.inflate( android.R.layout.simple_list_item_1, parent, false);
                }

                // 데이터 설정 및 새로고침
                view.setText( "Movies ..." );
                return view;
            }

            // position 의 0점 조정.
            position = position -1; // -1 : movie의 title 로우를 제거하기 위한 것.

            // movie의 data 처리
            if( position < actor.getMovies().size() ){
                ViewMovie view = null;
                if( convertView != null && convertView instanceof ViewMovie ){
                    view = (ViewMovie) convertView;
                }
                else {
                    view = new ViewMovie( parent.getContext() );
                }

                // 데이터 설정 & 새로고침
                ModelMovie m = actor.getMovies().get( position );
                view.setMovie( m );

                return view;
            }

            // position 의 0점 조정.
            position = position - actor.getMovies().size() ; // movie의 로우 갯수를 제거하기 위한 것.
        }

        if( actor.getDramas().size() > 0 ) {

            // drama 의 title 처리
            if( position == 0) {
                TextView view = null;

                if( convertView != null && convertView instanceof  TextView ) {
                    view = (TextView) convertView; // 재사용
                }
                else {
                    view = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                }

                // 데이터 설정
                view.setText( "Drama ...");

                return view;
            }

            // position 의 0점 조정.
            position = position -1; // -1 : movie의 title 로우를 제거하기 위한 것.

            // drama 의 row 데이터 처러
            if( position < actor.getDramas().size() ) {
                ViewDrama view = null;
                if( convertView != null && convertView instanceof ViewDrama  ) {
                    view = (ViewDrama) convertView; // 재사용
                }
                else {
                    view = new ViewDrama( parent.getContext() );
                }

                // 데이터 설정
                ModelDrama d = actor.getDramas().get( position );
                view.setDrama( d );  // 화면 새로고침이 발생.

                return  view;
            }

            // position 의 0점 조정.
            position = position - actor.getDramas().size(); // drama 의 로우 갯수를 제거하기 위한 것.
        }

        if( actor.getComments().size() > 0 ) {

            // comment의 title 처리
            if( position == 0 ) {
                TextView view = null;

                if( convertView != null && convertView instanceof  TextView ) {
                    view = (TextView) convertView; // 재사용
                }
                else {
                    //view = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                    view = new TextView(parent.getContext());
                    ViewGroup.LayoutParams lp = new LinearLayout.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT
                                                                             , ViewGroup.LayoutParams.WRAP_CONTENT);
                    view.setLayoutParams( lp );
                }

                // 데이터 설정
                view.setText( "Comments ..." );

                return view;
            }

            // position 의 0점 조정.
            position = position -1; // -1 : comment의 title 로우를 제거하기 위한 것.

            // comment의 data 처리
            if( position < actor.getComments().size() ) {

                // 뷰 가져오거나 만들기.
                ViewComment view = null;
                if( convertView != null && convertView instanceof ViewComment ) {
                    view = (ViewComment) convertView; // 재사용
                }
                else {
                    view = new ViewComment( parent.getContext() );
                }

                // 데이터 설정 & 화면새로고침
                ModelComment c = actor.getComments().get( position );
                view.setComment( c );

                return view;
            }

            // position 의 0점 조정.
            position = position - actor.getComments().size(); // comment 의 로우 갯수를 제거하기 위한 것.
        }

        throw new IllegalArgumentException( "Invalid poistion");
    }
}












