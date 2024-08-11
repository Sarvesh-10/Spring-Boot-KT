package com.example.demo.services;

import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private List<Task> list = new ArrayList<>();

    // add a task
    public Task addTask(Task task) {
        try {
            logger.info("upcoming task: {}", task);
            Task task1 = new Task();
            task1.setDescription(task.getDescription());
            task1.setId(task.getId());
            list.add(task1);
            logger.info("Adding task: {}" , task1);
            logger.info("Task added successfully with ID: {}", task1.getId());
            return task1;
        } catch (Exception e) {
            logger.error("Data integrity violation occurred while adding task: {}", e.getMessage());
            return null;
        }
    }

    // delete a task
    public List<Task> delete(int id){
        for (Task task : list) {
            if (task.getId() == id) {
                list.remove(task);
                break;
            }else {
                logger.error("Task not found with ID: {}", id);
            }
        }
        return list;
    }

    public List<Task> getAllTasks() {
        return list;
    }


//    @Autowired
//    private TaskRepository taskRepository;

    // add a task function without repository
}
