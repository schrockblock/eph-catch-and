package com.julintani.ephcatchreunion.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.julintani.ephcatchreunion.R;
import com.julintani.ephcatchreunion.models.Message;
import com.julintani.ephcatchreunion.models.User;
import com.julintani.ephcatchreunion.views.MessageViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ell on 12/13/15.
 */
public class ConversationAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    private User mUser;
    private List<Message> mMessages = new ArrayList<>();

    public ConversationAdapter(List<Message> messages, User otherUser){
        mMessages = messages;
        mUser = otherUser;
    }

    @Override
    public int getItemViewType(int position) {
        return mMessages.get(position).getUserId() == mUser.getId() ? 1 : 0;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MessageViewHolder(
                inflater.inflate(viewType == 0 ? R.layout.item_message_from_self : R.layout.item_message_from_other,
                        parent, false),
                mUser);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = mMessages.get(position);
        holder.display(message, message.getUserId() == mUser.getId() ? mUser : null);
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }
}
