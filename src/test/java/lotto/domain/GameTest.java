package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @DisplayName("로또 번호가 오름차순 정렬이 되었는지 확인한다.")
    @Test
    void getSortLotto() {
        List<Integer> unSortedLotto = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1));
        List<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));


        assertThat(game.getSortLotto(unSortedLotto)).isEqualTo(sortedList);
    }
}