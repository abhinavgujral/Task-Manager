package com.PayPal.taskPlanner.Controllers;


import com.PayPal.taskPlanner.DTO.SprintDTO;
import com.PayPal.taskPlanner.Services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SprintController {
    @Autowired
    private SprintService sprintService;

    @PostMapping()
    public ResponseEntity<SprintDTO> addSprint(@RequestBody SprintDTO sprintDTO) {
        SprintDTO sprintAdded = sprintService.addSprint(sprintDTO);
        return new ResponseEntity<>(sprintAdded, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<SprintDTO> getSprintById(@PathVariable Long id){
        SprintDTO sprintDTO = sprintService.getSprintById(id);
        return new ResponseEntity<>(sprintDTO, HttpStatus.OK);
    }



    @GetMapping()
    public ResponseEntity<List<SprintDTO>> getAllSprint(){
        List<SprintDTO> sprints = sprintService.getAllSprint();
        return new ResponseEntity<>(sprints, HttpStatus.OK);
    }


}
