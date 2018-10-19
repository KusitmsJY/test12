package com.example.paginglistview;

import android.graphics.drawable.Drawable;

public class ModelItem {
    private Drawable iconItem      ; // ImageView
    private String   dataItem01    ; // TextView
    private String   dataItem02    ; // TextView
    private String   dataItem03    ; // TextView

    public Drawable getIconItem() {
        return iconItem;
    }

    public void setIconItem(Drawable iconItem) {
        this.iconItem = iconItem;
    }

    public String getDataItem01() {
        return dataItem01;
    }

    public void setDataItem01(String dataItem01) {
        this.dataItem01 = dataItem01;
    }

    public String getDataItem02() {
        return dataItem02;
    }

    public void setDataItem02(String dataItem02) {
        this.dataItem02 = dataItem02;
    }

    public String getDataItem03() {
        return dataItem03;
    }

    public void setDataItem03(String dataItem03) {
        this.dataItem03 = dataItem03;
    }

    @Override
    public String toString() {
        return "ModelItem{" +
                "iconItem=" + iconItem +
                ", dataItem01='" + dataItem01 + '\'' +
                ", dataItem02='" + dataItem02 + '\'' +
                ", dataItem03='" + dataItem03 + '\'' +
                '}';
    }

    public ModelItem() {
    }

    public ModelItem(Drawable iconItem, String dataItem01, String dataItem02, String dataItem03) {
        this.iconItem = iconItem;
        this.dataItem01 = dataItem01;
        this.dataItem02 = dataItem02;
        this.dataItem03 = dataItem03;
    }
}
