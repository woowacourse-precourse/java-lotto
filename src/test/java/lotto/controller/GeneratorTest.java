package lotto.controller;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
//    @Test
//    void pickUniqueNumbersInRange파악을_위한_테스트() {
//        List<Integer> nums = Generator.getNums();
//        System.out.println(nums.toString());
//    }

    @Test
    void lotto발행_테스트() {
        List<Lotto> lottos = Generator.getLottos(10000);
        assertThat(lottos.size()).isEqualTo(10000);
    }
}