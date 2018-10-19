package com.example.actor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.actor.R;
import com.example.actor.model.ModelComment;


public class ViewComment extends RelativeLayout{

    private TextView textMessage = null;
    private TextView textWriter = null;

    public ViewComment(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewComment(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewComment(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                                     .inflate(R.layout.view_comment,this,true);

        textMessage = rowview.findViewById(R.id.text_message);
        textWriter = rowview.findViewById(R.id.text_writer);

    }

    ModelComment comment;

    public ModelComment getComment() {
        return comment;
    }

    public void setComment(ModelComment comment) {
        this.comment = comment;

        textMessage.setText(comment.getTextMessage());
        textWriter.setText(comment.getTextWriter());
    }
}
