package com.example.paginglistview;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterItem extends ArrayAdapter<ModelItem> {

    private Context         context  = null ;
    private List<ModelItem> list     = null ;

    public AdapterItem(@NonNull Context context, int resource, @NonNull List<ModelItem> objects) {
        super(context, resource, objects);

        this.context = context;
        this.list    = objects;
    }

    /**
     * ViewHolder 란 커스텀뷰의 위젯을 닫는 클래스다
     */
    private class ViewHolder {
        ImageView iconItem   ;
        TextView  dataItem01 ;
        TextView  dataItem02 ;
        TextView  dataItem03 ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;

        ViewHolder holder = null;

        if( itemView == null ){

            // 뷰 inflation
            itemView = LayoutInflater.from( context )
                                     .inflate(R.layout.customview_item, parent, false );

            // ViewHolder 생성
            holder = new ViewHolder();

            holder.iconItem   = itemView.findViewById(R.id.iconItem);
            holder.dataItem01 = itemView.findViewById(R.id.dataItem01);
            holder.dataItem02 = itemView.findViewById(R.id.dataItem02);
            holder.dataItem03 = itemView.findViewById(R.id.dataItem03);

            itemView.setTag( holder );
        }
        else {
            // 재사용
            holder = (ViewHolder) itemView.getTag();
        }

        // 데이터 설정
        final ModelItem item = getItem(position);

        holder.iconItem  .setImageDrawable(  item.getIconItem() );
        holder.dataItem01.setText( item.getDataItem01() );
        holder.dataItem02.setText( item.getDataItem02() );
        holder.dataItem03.setText( item.getDataItem03() );

        // ListView의 행을 클릭하면.
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder( AdapterItem.this.context );
                builder.setMessage( item.toString() );
                builder.setTitle  ( item.getDataItem01() );
                builder.setIcon( R.mipmap.ic_launcher );
                builder.setPositiveButton("확인", null);
                builder.show();
            }
        });

        return itemView;
    }

}
