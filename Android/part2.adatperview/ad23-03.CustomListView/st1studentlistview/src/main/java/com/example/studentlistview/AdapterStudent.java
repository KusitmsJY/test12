package com.example.studentlistview;

import android.content.*;
import android.support.annotation.*;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.*;

import java.util.List;

public class AdapterStudent extends ArrayAdapter<ModelStudent> {

    private Context context;

    public AdapterStudent(@NonNull Context context, int resource, @NonNull List<ModelStudent> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    /**
     * ViewHolder 란 커스텀뷰의 위젯을 닫는 클래스다
     */
    private class ViewHolder {
        TextView name       ;
        TextView number     ;
        TextView department ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemLayout = LayoutInflater.from( context )
                                        .inflate(R.layout.view_student, parent, false );

        ViewHolder holder = (ViewHolder) itemLayout.getTag();

        if( holder == null ) {
            holder = new ViewHolder();

            holder.name       = itemLayout.findViewById(R.id.text_name      );
            holder.number     = itemLayout.findViewById(R.id.text_number    );
            holder.department = itemLayout.findViewById(R.id.text_department);

            itemLayout.setTag( holder );
        }

        holder.name      .setText( getItem(position).getName      () );
        holder.number    .setText( getItem(position).getNumber    () );
        holder.department.setText( getItem(position).getDepartment() );

        return itemLayout;
    }
}
