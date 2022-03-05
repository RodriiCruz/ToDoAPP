package com.rodrigoecruz.todoapp.util;

import com.rodrigoecruz.todoapp.dto.NewTaskDTO;
import com.rodrigoecruz.todoapp.dto.TaskDTO;
import com.rodrigoecruz.todoapp.entity.Task;
import com.rodrigoecruz.todoapp.entity.TaskStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author rodri
 */
@Component
public class TaskMapper {

    public Task newTaskToTask(NewTaskDTO in) {

        return Task.builder()
                .title(in.getTitle())
                .description(in.getDescription())
                .eta(in.getEta())
                .createdDate(LocalDateTime.now())
                .finished(false)
                .taskStatus(TaskStatus.ON_TIME)
                .build();
    }

    public TaskDTO taskToTaskDTO(Task in) {
        return TaskDTO.builder()
                .id(in.getId())
                .title(in.getTitle())
                .description(in.getDescription())
                .createdDate(in.getCreatedDate())
                .eta(in.getEta())
                .finished(in.isFinished())
                .taskStatus(in.getTaskStatus())
                .build();
    }

    public List<TaskDTO> listTaskToDto(List<Task> in) {
        List<TaskDTO> out = new ArrayList();

        for (Task task : in) {
            TaskDTO dto = taskToTaskDTO(task);
            out.add(dto);
        }

        return out;
    }
}
