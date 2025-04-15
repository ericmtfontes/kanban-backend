package com.fontes.kanban_board.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fontes.kanban_board.domain.dtos.TaskDto;
import com.fontes.kanban_board.domain.entities.Task;
import com.fontes.kanban_board.handler.TaskNotFoundException;
import com.fontes.kanban_board.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDto> findAll(){
        return taskRepository.findAll()
                .stream()
                .map(t -> new TaskDto(t.getId(),
                        t.getTitle(),
                        t.getDescription(),
                        t.getStatus(),
                        t.getExpire()))
                .collect(Collectors.toList());
    }

    public void create(TaskDto taskDto){
        var task = new Task();

        BeanUtils.copyProperties(taskDto, task);

        task.setCreatedAt(LocalDate.now());

        taskRepository.save(task);
    }

    public TaskDto update(Long id, TaskDto taskDto){
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task " + id + " not found"));

        task.setTitle(taskDto.title());
        task.setDescription(taskDto.description());
        task.setStatus(taskDto.status());
        task.setExpire(taskDto.expire());
        task.setUpdatedAt(LocalDate.now());

        taskRepository.save(task);

        return new TaskDto(task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getExpire());
    }

    public void delete(Long id){
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task " + id + " not found"));

        taskRepository.delete(task);
    }
}
