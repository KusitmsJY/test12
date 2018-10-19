package com.example.actor.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.actor.R;
import com.example.actor.model.ModelDrama;


public class ViewDrama extends RelativeLayout {

    private ImageView imagePicture = null;
    private TextView textTitle = null;
    private TextView textInterval = null;

    public ViewDrama(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewDrama(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewDrama(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                                .inflate(R.layout.view_drama,this,true);

        imagePicture = rowview.findViewById(R.id.image_picture);
        textTitle = rowview.findViewById(R.id.text_title);
        textInterval = rowview.findViewById(R.id.text_interval);
    }

    ModelDrama drama;

    public ModelDrama getDrama() {
        return drama;
    }

    public void setDrama(ModelDrama drama) {
        this.drama = drama;

        imagePicture.setImageDrawable(drama.getImagePicture());
        textTitle.setText         (drama.getTextTitle()   );
        textInterval.setText         (drama.getTextInterval());
    }
}
