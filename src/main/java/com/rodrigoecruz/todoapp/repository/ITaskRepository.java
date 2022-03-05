package com.rodrigoecruz.todoapp.repository;

import com.rodrigoecruz.todoapp.entity.Task;
import com.rodrigoecruz.todoapp.entity.TaskStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodrigo Cruz
 */
@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE tasks SET finished=true WHERE id=:id", nativeQuery = true)
    void markTaskAsFinished(@Param("id") Long id);

}
