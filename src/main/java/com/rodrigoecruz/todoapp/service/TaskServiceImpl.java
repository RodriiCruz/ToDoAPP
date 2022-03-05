package com.rodrigoecruz.todoapp.service;

import com.rodrigoecruz.todoapp.dto.NewTaskDTO;
import com.rodrigoecruz.todoapp.dto.TaskDTO;
import com.rodrigoecruz.todoapp.entity.Task;
import com.rodrigoecruz.todoapp.repository.ITaskRepository;
import com.rodrigoecruz.todoapp.util.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo Cruz
 */
@Service
public class TaskServiceImpl implements ITaskService {
    
    @Autowired
    private ITaskRepository repository;
    
    @Autowired
    private TaskMapper mapper;
    
    public TaskDTO createTask(NewTaskDTO newTask) {
        Task entity = mapper.newTaskToTask(newTask);
        Task saved = repository.save(entity);
        System.out.println(saved.getTitle());
        return mapper.taskToTaskDTO(saved);
    }
}
