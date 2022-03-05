package com.rodrigoecruz.todoapp.dto;

import com.rodrigoecruz.todoapp.entity.*;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Rodrigo Cruz
 */
@Data
@Builder
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
