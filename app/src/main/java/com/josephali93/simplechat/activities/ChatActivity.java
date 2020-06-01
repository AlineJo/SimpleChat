package com.josephali93.simplechat.activities;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.josephali93.simplechat.adapters.ChatRecyclerViewAdapter;
import com.josephali93.simplechat.R;
import com.josephali93.simplechat.models.Message;

import java.util.ArrayList;


public class ChatActivity extends AppCompatActivity {
    private ArrayList<Message> mMessages;
    private static final String MESSAGE_SENDER = "Sam";
    private ChatRecyclerViewAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //TODO : this is just to remember importing my_message drawable
        ImageView my_message = new ImageView(this);
        my_message.setBackgroundResource(R.drawable.my_message);

        //TODO : this is just to remember importing my_message drawable
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(R.drawable.my_message);


        recyclerView = findViewById(R.id.rv_messages_view);
        setupRecyclerView();

        final TextInputEditText tietWrittenMessage = findViewById(R.id.tiet_writen_message);
        ImageButton ibSend = findViewById(R.id.ibSend);

        ibSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(tietWrittenMessage.getText().toString())) {
                    addMessage(tietWrittenMessage.getText().toString());
                    tietWrittenMessage.setText("");
                }

            }
        });



    }

    private void addMessage(String messageContent) {
        Message m = new Message(MESSAGE_SENDER, messageContent, true);
        mMessages.add(m);
        recyclerView.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1);
        mAdapter.notifyItemChanged(mMessages.size() - 1, m);
    }

    private void setupRecyclerView() {

        mAdapter = new ChatRecyclerViewAdapter(ChatActivity.this, createDemoChat());

        // you need these codes < Start >
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(ChatActivity.this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setStackFromEnd(true);
       /*
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) layoutManager).getOrientation());
        recyclerView.addItemDecoration(mDividerItemDecoration);*/

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        scrollToLast();
    }

    private void scrollToLast() {
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v,
                                       int left, int top, int right, int bottom,
                                       int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (bottom < oldBottom) {
                    recyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.smoothScrollToPosition(
                                    recyclerView.getAdapter().getItemCount() - 1);
                        }
                    }, 100);
                }
            }
        });
    }

    private ArrayList<Message> createDemoChat() {

        mMessages = new ArrayList<>();

        mMessages.add(new Message(MESSAGE_SENDER, "Hi!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "Hello!", true));
        mMessages.add(new Message(MESSAGE_SENDER, "how are you!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "are you doing well!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "are you doing well!are you doing well!are you doing well!are you doing well!are you doing well!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "What is that huh!", true));
        mMessages.add(new Message(MESSAGE_SENDER, "man you having a bad day ?!", true));


        mMessages.add(new Message(MESSAGE_SENDER, "2Hi!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "2Hello!", true));
        mMessages.add(new Message(MESSAGE_SENDER, "2how are you!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "2are you doing well!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "2are you doing well!are you doing well!are you doing well!are you doing well!are you doing well!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "2What is that huh!", true));
        mMessages.add(new Message(MESSAGE_SENDER, "2man you having a bad day ?!", true));

        mMessages.add(new Message(MESSAGE_SENDER, "3Hi!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "3Hello!", true));
        mMessages.add(new Message(MESSAGE_SENDER, "3how are you!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "3are you doing well!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "3are you doing well!are you doing well!are you doing well!are you doing well!are you doing well!", false));
        mMessages.add(new Message(MESSAGE_SENDER, "3What is that huh!", true));
        mMessages.add(new Message(MESSAGE_SENDER, "3man you having a bad day ?!", true));


        return mMessages;
    }
}
