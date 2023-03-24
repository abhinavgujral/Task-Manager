package com.PayPal.taskPlanner.Services;

import com.PayPal.taskPlanner.DTO.SprintDTO;
import com.PayPal.taskPlanner.Entities.Sprint;
import com.PayPal.taskPlanner.Exceptions.NotFoundException;
import com.PayPal.taskPlanner.Repositories.SprintRepository;
import com.PayPal.taskPlanner.Utils.ModelMapperClass;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SprintService {

    @Autowired
    SprintRepository sprintRepository;
    @Autowired
    ModelMapper modelMapper;
    public SprintDTO addSprint(SprintDTO sprintDTO) {
        Sprint sprint = new Sprint();
        modelMapper.map(sprintDTO,sprint);

            sprintRepository.save(sprint);
        // add exceptions if not saved
        return sprintDTO;
    }

    public List<SprintDTO> getAllSprint() {
       List<Sprint> sprintList= sprintRepository.findAll();
      List<SprintDTO> sprintDTOList = modelMapper.map(sprintList,
              new TypeToken<List<SprintDTO>>() {}.getType());
              return sprintDTOList;
    }

    public SprintDTO getSprintById(Long id) {
         Optional<Sprint> optionalSprint= sprintRepository.findById(id);
         if(optionalSprint.isEmpty())
             throw new NotFoundException("Sprint with id ="+id+"doesn't exist");
         SprintDTO sprintDTO = new SprintDTO();
         modelMapper.map(optionalSprint.get(),sprintDTO);
         return sprintDTO;


    }
}
