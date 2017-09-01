package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by ICE on 2017/5/16.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    public static final int HELLO = 0;

    public static final int GOODBYE =1;

    private String message;

    private int status;

}
