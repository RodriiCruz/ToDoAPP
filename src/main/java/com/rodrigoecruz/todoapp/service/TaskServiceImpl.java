package com.rodrigoecruz.todoapp.service;

import com.rodrigoecruz.todoapp.dto.NewTaskDTO;
import com.rodrigoecruz.todoapp.dto.TaskDTO;
import com.rodrigoecruz.todoapp.entity.Task;
import com.rodrigoecruz.todoapp.entity.TaskStatus;
import com.rodrigoecruz.todoapp.repository.ITaskRepository;
import com.rodrigoecruz.todoapp.util.TaskMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    @Override
    @Transactional
    public TaskDTO createTask(NewTaskDTO newTask) {
        Task entity = mapper.newTaskToTask(newTask);
        Task saved = repository.save(entity);
        
        return mapper.taskToTaskDTO(saved);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<TaskDTO> getAll() {
        List<Task> tasks = repository.findAll();
        
        return mapper.listTaskToDto(tasks);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<TaskDTO> getAllByTaskStatus(TaskStatus status) {
        List<Task> tasks = repository.findAllByTaskStatus(status);
        
        return mapper.listTaskToDto(tasks);
    }
}
