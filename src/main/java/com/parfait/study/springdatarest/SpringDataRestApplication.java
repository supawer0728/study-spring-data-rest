package com.parfait.study.springdatarest;

import com.parfait.study.springdatarest.board.domain.Board;
import com.parfait.study.springdatarest.board.domain.BoardRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@RequiredArgsConstructor
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class SpringDataRestApplication implements ApplicationRunner {

    private final BoardRepository boardRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("testWriter");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Board> boards = IntStream.range(1, 100).mapToObj(num -> Board.create("title" + num, "content" + num)).collect(Collectors.toList());
        boardRepository.saveAll(boards);
        log.info("dummy data is saved");
    }
}
