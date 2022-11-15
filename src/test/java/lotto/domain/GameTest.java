package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @DisplayName("로또 구입 금액을 1000으로 나누어 몇 개의 로또를 샀는지 구한다")
    @Test
    void getLottoCount() {
        int countTwo = 2000;
        int countThirteen = 13000;

        assertAll(
                () -> assertThat(game.getLottoCount(countTwo)).isEqualTo(2),
                () -> assertThat(game.getLottoCount(countThirteen)).isEqualTo(13)
        );
    }
}