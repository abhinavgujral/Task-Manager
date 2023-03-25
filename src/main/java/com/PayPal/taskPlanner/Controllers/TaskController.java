package com.PayPal.taskPlanner.Controllers;


import com.PayPal.taskPlanner.DTO.TaskDTO;
import com.PayPal.taskPlanner.Entities.Task;
import com.PayPal.taskPlanner.Exceptions.NotFoundException;
import com.PayPal.taskPlanner.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;



    @PostMapping
    public ResponseEntity<TaskDTO>  addTask(TaskDTO taskDTO){
        TaskDTO taskDTO1= taskService.addTask(taskDTO);
        return new ResponseEntity<>(taskDTO1,HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        List<TaskDTO> taskDTOList = taskService.getAllTask();
        return new ResponseEntity<>(taskDTOList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
       TaskDTO existingTask= taskService.getTaskById(id);

       if(Optional.of(existingTask).isEmpty())
           throw new NotFoundException("Data for id ="+id+" is not present in database ");
        taskService.updateTask(taskDTO);
    return new ResponseEntity<>(taskDTO,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        TaskDTO existingTask = taskService.getTaskById(id);
        if (Optional.of(existingTask).isEmpty()) {
                throw  new NotFoundException("Data for id =\"+id+\" is not present in database ");
        } else {
            taskService.deleteTask(id);
            return  new ResponseEntity<>("Task with id ="+id+"is deleted", HttpStatus.OK);
        }
    }



}
