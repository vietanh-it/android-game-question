/*
 * Copyright (c) 2014. <a href="http://facebook.com/vietanh.sgu">Viet Anh</a>.
 */

package Database;

/**
 * Created by VietAnh on 19/11/2014.
 */
public class UserObject {
    private int id;
    private String name;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name;
    }
}
