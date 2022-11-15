package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @DisplayName("로또 생성 기능 개수 테스트")
    @Test
    void generateLotto_test1() {
        List<Integer> lotto = LottoGenerator.generateLotto();
        Assertions.assertThat(lotto.size()).isEqualTo(6);
    }

    @DisplayName("로또 생성 기능 범위 테스트")
    @Test
    void generateLotto_test2() {
        List<Integer> lotto = LottoGenerator.generateLotto();
        Assertions.assertThat(lotto.stream().allMatch(num -> num >= MIN_NUMBER && num <= MAX_NUMBER)).isTrue();
    }
}