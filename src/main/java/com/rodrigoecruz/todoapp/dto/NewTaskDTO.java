package com.rodrigoecruz.todoapp.dto;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author Rodrigo Cruz
 */
@Data
public class NewTaskDTO {

    private String title;
    private String description;
    private LocalDateTime eta;
}
