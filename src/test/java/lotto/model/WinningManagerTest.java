package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningManagerTest {

    private static Stream<Arguments> provideUserLottosAndResultList() {
        return Stream.of(
                Arguments.of(
                        Lottos.of(List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 9)),
                                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                                new Lotto(List.of(1, 2, 3, 9, 10, 11)))
                        ),
                        List.of(Rank.from(1),Rank.from(2),Rank.from(3),Rank.from(4),Rank.from(5))
                ),
                Arguments.of(
                        Lottos.of(List.of(
                                new Lotto(List.of(6, 5, 4, 3, 2, 1)),
                                new Lotto(List.of(7, 5, 4, 3, 2, 1)),
                                new Lotto(List.of(9, 5, 4, 3, 2, 1)),
                                new Lotto(List.of(9, 8, 4, 3, 2, 1)),
                                new Lotto(List.of(9, 8, 7, 3, 2, 1))))
                        ,
                        List.of(Rank.from(1),Rank.from(2),Rank.from(3),Rank.from(4),Rank.from(5))
                ),
                Arguments.of(
                        Lottos.of(List.of(
                                new Lotto(List.of(16, 15, 14, 13, 12, 11))
                        ))
                        ,List.of()
                )
        );
    }

    @ParameterizedTest
    @DisplayName("정답 로또와 보너스볼을 기준으로 주어진 사용자 로또 목록의 결과를 확인한다.")
    @MethodSource("provideUserLottosAndResultList")
    void countContainedLottoNumbers(Lottos userLottos, List<Integer> resultList) {
        //given
        String answerInput = "1,2,3,4,5,6";
        String bonusBallInput = "7";
        BonusBall bonusBall = BonusBall.from(bonusBallInput);
        //when
        WinningManager wm = WinningManager.from(answerInput);
        wm.initBonusBall(bonusBall);
        //then
        Assertions.assertThat(wm.resultBy(userLottos)).isEqualTo(resultList);
    }
}
