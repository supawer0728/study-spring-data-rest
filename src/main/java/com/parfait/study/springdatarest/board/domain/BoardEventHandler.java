package com.parfait.study.springdatarest.board.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@Slf4j
@RepositoryEventHandler
public class BoardEventHandler {

    @HandleBeforeCreate
    public void handleBoardCreated(Board board) {
        log.info("created: {}", board);
    }
}
