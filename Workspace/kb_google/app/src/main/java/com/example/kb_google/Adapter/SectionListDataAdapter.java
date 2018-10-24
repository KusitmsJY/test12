package com.example.kb_google.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.kb_google.Model.Chat;
import com.example.kb_google.Model.SingleItemModel;
import com.example.kb_google.R;
import com.example.kb_google.Utils.DateFormat;

import java.util.ArrayList;


import static com.example.kb_google.Activity.ChatBotActivity.current_room_no;
import static com.example.kb_google.Utils.Constant.ACTION_TEXT;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemList;
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemList) {
        this.itemList = itemList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_single, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleItemModel singleItem = itemList.get(i);

        holder.tvTitle.setText(singleItem.getName());
        holder.tvCode.setText(singleItem.getUrl());


    }


    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle, tvCode;


        public SingleItemRowHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.tvCode = (TextView) view.findViewById(R.id.tvCode);
            // this.itemImage = (ImageView) view.findViewById(R.id.itemImage);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(v.getContext(), tvCode.getText(), Toast.LENGTH_SHORT).show();

                    Chat chat_mine = new Chat("11", current_room_no, DateFormat.date_apm(), tvTitle.getText().toString(), true, ACTION_TEXT);
                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat_mine));
                    Chat chat = new Chat("11", current_room_no, DateFormat.date_apm(), tvTitle.getText().toString(), true, tvCode.getText().toString());
                    //mWebSocketClient.send(ChatUtils.chat_to_json_text(chat));

                    // messages_adapter.notifyDataSetChanged();

                }
            });


        }

    }
}
