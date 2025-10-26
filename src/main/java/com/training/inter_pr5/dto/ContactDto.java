package com.training.inter_pr5.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ContactDto {
    private int id;
    private String name;
    private String phone;
}
