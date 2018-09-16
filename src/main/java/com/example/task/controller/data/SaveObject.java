package com.example.task.controller.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaveObject {

    private String name;

    private Long idParent;

    private String attribute;
}
