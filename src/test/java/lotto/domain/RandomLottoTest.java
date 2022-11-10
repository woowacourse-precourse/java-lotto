package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomLottoTest {

    RandomLotto randomLotto = new RandomLotto();

    @DisplayName("로또를 잘 생성하는지 테스트")
    @RepeatedTest(5)
    void 로또_생성_테스트() {
        assertThat(randomLotto.getRandomLotto()).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또에 1~45사이의 값이 들어 있는지 테스트")
    @RepeatedTest(20)
    void 로또_값_테스트() {
        Lotto lotto = randomLotto.getRandomLotto();
        assertThat(lotto.getNumbers()).allMatch((ch) -> 1 <= ch && ch <= 45);
    }
}