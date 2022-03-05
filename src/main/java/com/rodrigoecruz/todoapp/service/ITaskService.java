package com.rodrigoecruz.todoapp.service;

import com.rodrigoecruz.todoapp.dto.NewTaskDTO;
import com.rodrigoecruz.todoapp.dto.TaskDTO;

/**
 *
 * @author Rodrigo Cruz
 */
public interface ITaskService {

    TaskDTO createTask(NewTaskDTO newTask);
}
