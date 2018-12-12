package com.parfait.study.springdatarest.board.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/boards")
public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findAllByTitleContains(@Param("title") String title, Pageable pageable);
}
