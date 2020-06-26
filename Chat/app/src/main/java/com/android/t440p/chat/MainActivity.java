package com.android.t440p.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<Message> messageList = new ArrayList<>();
    private EditText etChat;
    private Button btnSend, btnReceive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageList = new ArrayList<>();
        etChat = findViewById(R.id.edittext_chatbox);
        btnSend = findViewById(R.id.button_chatbox_send);
        btnReceive = findViewById(R.id.button_receive);
        btnSend.setOnClickListener(this);
        btnReceive.setOnClickListener(this);


        mMessageRecycler = findViewById(R.id.recyclerview_message_list);
        mMessageAdapter = new MessageListAdapter(this, messageList);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setStackFromEnd(true);
        mMessageRecycler.setLayoutManager(mLayoutManager);
        mMessageRecycler.setAdapter(mMessageAdapter);
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        mMessageRecycler.addItemDecoration(decoration);

    }
    @Override
    public void onClick(View view){
        int viewId = view.getId();
        switch (viewId){
            case R.id.button_chatbox_send:
                String message = etChat.getText().toString();
                if(message.length() > 0){
                    User sender = new User("sender");
                    mMessageAdapter.updateData(new Message(message, sender));
                    if(messageList.size() >= 1 ){
                        mMessageRecycler.smoothScrollToPosition(messageList.size() - 1);
                    }
                }
                break;
            case R.id.button_receive:
                String recMessage = etChat.getText().toString();
                if(recMessage.length() > 0){
                    User receiver = new User("receiver");
                    mMessageAdapter.updateData(new Message(recMessage, receiver));
                    if(messageList.size() >= 1 ){
                        mMessageRecycler.smoothScrollToPosition(messageList.size() - 1);
                    }
                }
                break;
        }
    }

}
