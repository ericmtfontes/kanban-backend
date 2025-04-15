package com.fontes.kanban_board.domain.dtos;

import com.fontes.kanban_board.domain.enums.StatusEnum;

import java.time.LocalDate;

public record TaskDto(Long id,
                      String title,
                      String description,
                      StatusEnum status,
                      LocalDate expire) {
}
