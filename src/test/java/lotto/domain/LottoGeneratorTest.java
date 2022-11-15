package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.Test;


public class LottoGeneratorTest {
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    private LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 랜덤_로또_생성() {
        Lotto lotto = new Lotto(lottoGenerator.generateNumber());
        assertThatNoException();
    }

    @Test
    void 숫자_범위_테스트() {
        List<Integer> generateNumber = lottoGenerator.generateNumber();
        assertThat(generateNumber.stream().allMatch(number -> number >= START)).isTrue();
        assertThat(generateNumber.stream().allMatch(number -> number <= END)).isTrue();
    }

    @Test
    void 랜덤_숫자_크기_테스트() {
        List<Integer> generateNumber = lottoGenerator.generateNumber();
        assertThat(generateNumber.size()).isEqualTo(COUNT);
    }

}
