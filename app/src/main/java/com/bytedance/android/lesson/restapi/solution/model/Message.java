package com.bytedance.android.lesson.restapi.solution.model;


import com.bytedance.android.lesson.restapi.solution.R;

/**
 * 消息  data class
 */
public class Message {

    private boolean isOfficial;
    private String title;
    private String time;
    private String description;
    private String icon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIcon() {
        switch (icon){
            case "TYPE_ROBOT":return R.drawable.session_robot;
            case "TYPE_SYSTEM":return R.drawable.session_system_notice;
            case "TYPE_GAME":return R.drawable.icon_micro_game_comment;
            case "TYPE_STRANGER":return R.drawable.session_stranger;
            case "TYPE_USER":return R.drawable.icon_girl;
            default:return R.drawable.icon_girl;
        }

    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    @Override
    public String toString() {
        return "Message{" +
                "isOfficial=" + isOfficial +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
