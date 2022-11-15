package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.constant.ErrorConstant.ERROR_DUPLICATE_NUMBER;
import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    @DisplayName("예외 처리 : 당첨 번호와 보너스 번호가 중복인지 검증")
    @Test
    void isContainBonusNumberInLotto() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6),6))
                .withMessageStartingWith(ERROR_DUPLICATE_NUMBER);
    }

    @DisplayName("예상 등수가 맞게 나오는지 검증")
    @ParameterizedTest
    @MethodSource("getResultOfLottoAndRank")
    void checkRankOfLotto(List<Integer> userLottoNumbers, Rank expected) {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        Lotto userLotto = new Lotto(userLottoNumbers);

        assertThat(winningLotto.getRankOf(userLotto)).isEqualTo(expected);
    }
    private static Stream<Arguments> getResultOfLottoAndRank() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6), SIX),
                Arguments.of(List.of(1,2,3,4,5,7), FIVE_WITH_BONUS),
                Arguments.of(List.of(1,2,3,4,5,8), FIVE),
                Arguments.of(List.of(1,2,3,4,8,9), FOUR),
                Arguments.of(List.of(8,9,10,1,2,3), THREE),
                Arguments.of(List.of(10,11,12,13,14,15), MISS)
        );
    }

}
