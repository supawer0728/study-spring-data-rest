package com.parfait.study.springdatarest.board.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "titleAndWriter", types = Board.class)
public interface TitleAndWriterProjection {

    @Value("#{target.title}, #{target.writer}")
    String getTitleAndWriter();
}
