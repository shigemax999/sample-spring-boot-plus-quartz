package com.example.scheduler.job;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JobParameter implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String uid;
    private final String name;
}
