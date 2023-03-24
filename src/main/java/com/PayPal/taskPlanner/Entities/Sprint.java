package com.PayPal.taskPlanner.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sprintId;
    private String sprintName;

}
