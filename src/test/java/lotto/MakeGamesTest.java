package lotto;

import lotto.controller.MakeGames;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MakeGamesTest {

    @DisplayName("로또 객체가 지정한 수량 만큼 나오는지 테스트, 1부터 45까지의 값만 나오는지 테스트")
    @Test
    void lottoSortTest() {
        List<Lotto> games = new ArrayList<Lotto>();
        int count = 3;
        MakeGames makeGames = new MakeGames(count);

        makeGames.makeGames(games);
        assertAll(
            () -> assertThat(games.size()).isEqualTo(count),
            () -> assertThat(games.get(0).getLotto().stream().allMatch(v -> v >= 1 && v <= 45)).isTrue(),
            () -> assertThat(games.get(1).getLotto().stream().allMatch(v -> v >= 1 && v <= 45)).isTrue(),
            () -> assertThat(games.get(2).getLotto().stream().allMatch(v -> v >= 1 && v <= 45)).isTrue()
        );
    }
}
