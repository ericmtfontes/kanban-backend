package com.fontes.kanban_board.handler;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String msg){
        super(msg);
    }
}
