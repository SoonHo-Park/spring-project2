package com.fastcampusallinone.project3.mycontact.repository;

import com.fastcampusallinone.project3.mycontact.domain.Block;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockRepositoryTest {
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void crud(){
        Block block = new Block();
        block.setName("MARTIN");
        block.setReason("친하지않음");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now());

        blockRepository.save(block);

        List<Block> blocks = blockRepository.findAll();
        Assertions.assertThat(blocks.size()).isEqualTo(1);
        Assertions.assertThat(blocks.get(0).getName()).isEqualTo("MARTIN");
    }
}