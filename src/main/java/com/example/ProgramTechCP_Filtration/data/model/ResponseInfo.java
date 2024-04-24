package com.example.ProgramTechCP_Filtration.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class ResponseInfo <T>{
    private String info;
    private List<T> data;
}
