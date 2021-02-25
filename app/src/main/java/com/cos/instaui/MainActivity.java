package com.cos.instaui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private RecyclerView rvPostList, rvStoryList;
    private StoryAdapter storyAdapter;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 최상단 컴포넌트 (수평 스크롤)
        List<String> stories = new ArrayList<>();
        for (int i=0;i<8;i++){
            String story = "Your Story";
            stories.add(story);
        }

        LinearLayoutManager topManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvStoryList = findViewById(R.id.rv_story_list);
        rvStoryList.setLayoutManager(topManager);
        storyAdapter = new StoryAdapter(stories);
        rvStoryList.setAdapter(storyAdapter);

        // 중간 컴포넌트 (수직 스크롤)
        List<Post> posts = new ArrayList<>();
        for (int i=1;i<4;i++){
            posts.add(new Post(i,"user"+i));
        }

        LinearLayoutManager middleManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvPostList = findViewById(R.id.rv_post_list);
        rvPostList.setLayoutManager(middleManager);
        postAdapter = new PostAdapter(posts);
        rvPostList.setAdapter(postAdapter);

    }
}