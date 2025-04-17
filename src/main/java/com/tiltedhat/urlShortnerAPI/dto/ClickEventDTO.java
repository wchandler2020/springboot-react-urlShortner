package com.tiltedhat.urlShortnerAPI.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClickEventDTO {
    LocalDate clickDate;
    private Long count;
}
