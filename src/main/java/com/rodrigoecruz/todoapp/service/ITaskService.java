package com.rodrigoecruz.todoapp.service;

import com.rodrigoecruz.todoapp.dto.NewTaskDTO;
import com.rodrigoecruz.todoapp.dto.TaskDTO;
import com.rodrigoecruz.todoapp.entity.TaskStatus;
import java.util.List;

/**
 *
 * @author Rodrigo Cruz
 */
public interface ITaskService {

    TaskDTO createTask(NewTaskDTO newTask);

    List<TaskDTO> getAll();

    List<TaskDTO> getAllByTaskStatus(TaskStatus status);

    void markTaskAsFinished(Long id);
}
