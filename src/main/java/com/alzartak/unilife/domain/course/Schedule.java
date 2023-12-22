package com.alzartak.unilife.domain.course;

import lombok.Data;

import java.util.Map;

@Data
public class Schedule {
    private String day;

    private Map<String, Integer> time;

    private String room;
}
