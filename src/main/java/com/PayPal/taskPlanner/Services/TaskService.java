package com.PayPal.taskPlanner.Services;

import com.PayPal.taskPlanner.DTO.TaskDTO;
import com.PayPal.taskPlanner.Entities.Task;
import com.PayPal.taskPlanner.Exceptions.NotFoundException;
import com.PayPal.taskPlanner.Repositories.TaskRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
     @Autowired
    ModelMapper modelMapper;




    public TaskDTO addTask(TaskDTO taskDTO) {
        Task task = new Task();
        modelMapper.map(taskDTO,task);
        taskRepository.save(task);
        return taskDTO;
    }
    public TaskDTO getTaskById(Long id) {
        Optional<Task> optionalTask= taskRepository.findById(id);
        if(optionalTask.isEmpty())
            throw new NotFoundException("Task with id ="+id+"doesn't exist");
        TaskDTO taskDTO = new TaskDTO();
        modelMapper.map(optionalTask.get(),taskDTO);
        return taskDTO;
    }


     public List<TaskDTO> getAllTask() {
      List<Task> taskList=  taskRepository.findAll();
      List<TaskDTO> taskDTOS= new ArrayList<>();
      modelMapper.map(taskList, new TypeToken<List<TaskDTO>>() {}.getType());
      return  taskDTOS;
    }


    public TaskDTO updateTask(TaskDTO taskDTO) {
        Task task = new Task();
        modelMapper.map(taskDTO,task);
         taskRepository.save(task);
          return taskDTO;
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    public List<Task> getTasksBySprintId(Long sprintId) {
        return taskRepository.findBySprintId(sprintId);
    }

//    public List<Task> getTasksByAssignee(String assignee) {
//        return taskRepository.findByAssignee(assignee);
//    }
}
