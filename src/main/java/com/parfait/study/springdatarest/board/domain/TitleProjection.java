package com.parfait.study.springdatarest.board.domain;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "onlyTitle", types = Board.class)
public interface TitleProjection {

    String getTitle();
}
