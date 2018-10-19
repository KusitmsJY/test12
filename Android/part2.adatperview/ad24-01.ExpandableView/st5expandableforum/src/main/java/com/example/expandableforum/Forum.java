package com.example.expandableforum;

/**
 * Created by Administrator on 2017-07-02.
 */

public class Forum {

    private String title;
    private Integer postCount;
    private String category;

    // getter  and setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // toString
    @Override
    public String toString() {
        return "Forum{" +
                "title='" + title + '\'' +
                ", postCount=" + postCount +
                '}';
    }

    // constructor
    public Forum(String category, Integer postCount, String title) {
        this.category  = category;
        this.title     = title;
        this.postCount = postCount;
    }
}
