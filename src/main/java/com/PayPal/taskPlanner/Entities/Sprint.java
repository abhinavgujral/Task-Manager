package com.PayPal.taskPlanner.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sprintId;
    private String sprintName;

    @OneToMany(mappedBy = "sprint")
    private List<Task> tasks;

}
