package com.example.actor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.actor.R;
import com.example.actor.model.ModelActor;

public class ViewActor extends RelativeLayout{

    private ImageView imagePhoto = null;
    private TextView textName = null;
    private TextView textAge = null;
    private TextView textDescription = null;

    public ViewActor(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewActor(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewActor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                                     .inflate(R.layout.view_actor,this,true);

        imagePhoto = rowview.findViewById(R.id.image_photo);
        textName = rowview.findViewById(R.id.text_name);
        textAge = rowview.findViewById(R.id.text_age);
        textDescription = rowview.findViewById(R.id.text_description);
    }

    ModelActor actor;

    public ModelActor getActor() {
        return actor;
    }

    public void setActor(ModelActor actor) {
        this.actor = actor;

        imagePhoto.setImageDrawable(actor.getImagePhoto());
        textName.setText         (actor.getTextName());
        textAge.setText         (actor.getTextAge());
        textDescription.setText         (actor.getTextDescription());
    }
}
