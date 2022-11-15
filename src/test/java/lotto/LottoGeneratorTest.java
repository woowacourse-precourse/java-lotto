package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @Test
    void 로또_1개_발행() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer>[] list = lottoGenerator.createRandomNumbers(1);

        System.out.println(list[0]);
        assertThat(list.length).isEqualTo(1);
    }
    @Test
    void 로또_8개_발행() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer>[] list = lottoGenerator.createRandomNumbers(8);

        for (int i = 0; i < 8; i++) {
            System.out.println(list[i]);
        }
        assertThat(list.length).isEqualTo(8);
    }
}