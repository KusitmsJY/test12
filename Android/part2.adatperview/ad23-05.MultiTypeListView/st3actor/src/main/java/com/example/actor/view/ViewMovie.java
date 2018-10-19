package com.example.actor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.actor.R;
import com.example.actor.model.ModelMovie;

public class ViewMovie extends RelativeLayout {

    private ImageView imagePicture = null;
    private TextView textTitle = null;
    private TextView textYear = null;

    public ViewMovie(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewMovie(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewMovie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                                     .inflate(R.layout.view_movie,this,true);

        imagePicture = rowview.findViewById(R.id.image_picture);
        textTitle = rowview.findViewById(R.id.text_title);
        textYear = rowview.findViewById(R.id.text_year);

    }

    ModelMovie movie;

    public ModelMovie getMovie() {
        return movie;
    }

    public void setMovie(ModelMovie movie) {
        this.movie = movie;

        imagePicture.setImageDrawable(movie.getImagePicture());
        textTitle.setText         (movie.getTextTitle()   );
        textYear.setText         (movie.getTextYear()    );
    }
}
