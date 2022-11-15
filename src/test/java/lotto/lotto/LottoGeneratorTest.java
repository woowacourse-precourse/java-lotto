package lotto.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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

    @Test
    void 로또_중복_테스트() {
        LottoGenerator generator = new LottoGenerator();
        for(int iter = 0; iter < 10000; iter++) {
            Lotto lotto = generator.getLotto();
            List<Integer> numbers = lotto.getNumbers();
            for(int i = 0; i < numbers.size(); i++) {
                for (int j = 0; j < numbers.size(); j++) {
                    if (i != j)
                        assertNotEquals(numbers.get(i), numbers.get(j));
                }
            }
        }
    }
}