package com.console.university_console.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StatisticsDto {
    private Integer assistans;
    private Integer associate_professors;
    private Integer professors;
}
