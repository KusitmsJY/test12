package com.example.bbs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;

import com.example.bbs.article.ArticleActivity;
import com.example.bbs.http.HttpBoard;
import com.example.bbs.model.ModelBoard;

import java.util.List;

/**
 * Created by Administrator on 2018-02-05.
 */

public abstract class SiteAsyncTask<Input, Progress, Result> extends AsyncTask<Input, Progress, Result>{

    protected ProgressDialog pdlg = null;
    protected Context mContext = null;

    public SiteAsyncTask( Context context ) {
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        pdlg = new ProgressDialog(this.mContext);
        pdlg.setMessage("기달려....");
        pdlg.show();
    }


    @Override
    protected void onPostExecute(Result list) {
        if( pdlg != null ){
            pdlg.dismiss();
            pdlg = null;
        }
    }
}