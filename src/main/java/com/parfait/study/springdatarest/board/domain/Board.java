package com.parfait.study.springdatarest.board.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "board")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    @CreatedBy
    @LastModifiedBy
    private String writer;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime wroteAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    private Board(@NonNull String title, @NonNull String content) {
        this.title = title;
        this.content = content;
    }

    public static Board create(String title, String content) {
        return new Board(title, content);
    }
}
