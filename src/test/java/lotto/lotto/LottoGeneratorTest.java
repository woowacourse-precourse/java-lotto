package lotto.lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void 로또_개수_6개_테스트() {
        LottoGenerator generator = new LottoGenerator();

        generator.convert2Lotto("1,2,3,4,5,6");
    }

    @Test
    void 로또_개수_6개_아닌경우_테스트() {
        LottoGenerator generator = new LottoGenerator();

        assertThrows(IllegalArgumentException.class, () -> generator.convert2Lotto("1,2,3,4,5,6,7"));
        assertThrows(IllegalArgumentException.class, () -> generator.convert2Lotto("1,2,3"));
    }

    @Test
    void 로또_입력이_정상적이지_않은_경우_테스트() {
        LottoGenerator generator = new LottoGenerator();

        assertThrows(IllegalArgumentException.class, () -> generator.convert2Lotto("1,2,3,4,5,,6"));
    }

}