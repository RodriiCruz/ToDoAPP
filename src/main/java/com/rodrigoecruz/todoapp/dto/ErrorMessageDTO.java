package com.rodrigoecruz.todoapp.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author odrigo Cruz
 */
@Data
@AllArgsConstructor
public class ErrorMessageDTO {

    private List<String> message;

}
