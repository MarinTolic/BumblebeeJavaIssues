package com.example.bumblebeejavaissues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import io.getstream.chat.android.client.ChatClient;
import io.getstream.chat.android.client.logger.ChatLogLevel;
import io.getstream.chat.android.offline.model.message.attachments.UploadAttachmentsNetworkType;
import io.getstream.chat.android.offline.plugin.configuration.Config;
import io.getstream.chat.android.offline.plugin.factory.StreamOfflinePluginFactory;
import io.getstream.chat.android.ui.message.list.viewmodel.factory.MessageListViewModelFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StreamOfflinePluginFactory streamOfflinePluginFactory = new StreamOfflinePluginFactory(
                new Config(
                        true,
                        true,
                        true,
                        UploadAttachmentsNetworkType.NOT_ROAMING
                ),
                getApplicationContext()
        );

        ChatClient client = new ChatClient.Builder("b67pax5b2wdq", getApplicationContext())
                .withPlugin(streamOfflinePluginFactory)
                .logLevel(ChatLogLevel.ALL) // Set to NOTHING in prod
                .build();
    }

    protected void viewModelFactoryExample(){
        MessageListViewModelFactory factory = new MessageListViewModelFactory("someCid");
        ViewModelProvider provider = new ViewModelProvider(this, factory);
    }
}