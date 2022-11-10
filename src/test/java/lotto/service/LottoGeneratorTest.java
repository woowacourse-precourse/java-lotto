package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    private LottoGenerator generator = new LottoGenerator();

        @Test
        @DisplayName("로또 발행 및 출력 테스트")
        void lotto_generator_test() {
            Lotto lotto = generator.forTest_getLotto();
            System.out.println(lotto.toString());
        }
}