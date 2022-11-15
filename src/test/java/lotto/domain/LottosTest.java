package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static lotto.domain.LottoWin.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @ParameterizedTest(name = "[{index}] lottoWin = {2}")
    @MethodSource("whenFindLottoWinThenSuccessDummy")
    @DisplayName("다수 로또 당첨 판별 성공 테스트")
    void whenFindLottoWinThenSuccessTest(LottoWinNumber lottoWinNumber, List<Lotto> lottos, Map<LottoWin, Integer> lottoWin) {
        Lottos newLottos = new Lottos(lottos);
        Map<LottoWin, Integer> lottoResults = newLottos.lottoResults(lottoWinNumber);
        assertThat(lottoResults).isEqualTo(lottoWin);
    }

    static Stream<Arguments> whenFindLottoWinThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(
                        new LottoWinNumber(Set.of(1, 2, 3, 4, 5, 6), 45),
                        List.of(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 20, 22))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 40, 4, 5, 6))),
                                new Lotto(new ArrayList<>(List.of(6, 12, 18, 23, 36, 43))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 20, 22))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 40, 4, 5, 6))),
                                new Lotto(new ArrayList<>(List.of(6, 12, 18, 23, 36, 43))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 20, 22))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 40, 4, 5, 6))),
                                new Lotto(new ArrayList<>(List.of(6, 12, 18, 23, 36, 43))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 20, 22)))),
                        Map.of(LOSER, 3,
                                FIFTH_PRICE_WINNER, 0,
                                FOURTH_PRICE_WINNER, 4,
                                THIRD_PRICE_WINNER, 6,
                                SECOND_PRICE_WINNER, 0,
                                FIRST_PRICE_WINNER, 2)
                ),
                Arguments.arguments(
                        new LottoWinNumber(Set.of(10, 14, 32, 42, 15, 23), 45),
                        List.of(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 20, 22))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 20, 22))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 40, 4, 5, 6))),
                                new Lotto(new ArrayList<>(List.of(6, 12, 18, 23, 36, 43))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 20, 22))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 40, 4, 5, 6))),
                                new Lotto(new ArrayList<>(List.of(6, 12, 18, 23, 36, 43))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10))),
                                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 20, 22)))),
                        Map.of(LOSER, 14,
                                FIFTH_PRICE_WINNER, 0,
                                FOURTH_PRICE_WINNER, 0,
                                THIRD_PRICE_WINNER, 0,
                                SECOND_PRICE_WINNER, 0,
                                FIRST_PRICE_WINNER, 0)
                )
        );
    }
}