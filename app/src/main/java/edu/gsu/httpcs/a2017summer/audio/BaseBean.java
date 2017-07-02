package edu.gsu.httpcs.a2017summer.audio;

import java.io.Serializable;

/**
 * Created by supark on 6/21/17.
 */

public class BaseBean implements Serializable {
    private String name;

    public String getName() {
        return name;
    }  //getter

    public void setName(String name) {
        this.name = name;
    }  //setter
}
