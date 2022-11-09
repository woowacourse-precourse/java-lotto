package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    private LottoGenerator generator = new LottoGenerator();

    @Test
    @DisplayName("6개의 중복 안 되는 랜덤 숫자 발행하는지")
    void generateLotto() {
        System.out.println(generator.generateLotto());
    }
}