package lotto.domain;

import lotto.exception.LottoWinNumberExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static lotto.domain.LottoWin.*;
import static lotto.exception.LottoWinNumberExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoWinNumberTest {
    @ParameterizedTest(name = "[{index}] winNumber = {0}, bonusNumber = {1}, exception = {2}")
    @MethodSource("whenWrongArgumentsThenExceptionDummy")
    @DisplayName("당첨 번호 생성 중복, 개수, 범위로 인한 예외처리 테스트")
    void whenWrongArgumentsThenExceptionTest(Set<Integer> winNumbers, int bonusNumber, LottoWinNumberExceptionMessage exceptionMessage) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoWinNumber(winNumbers, bonusNumber))
                .withMessage(exceptionMessage.getMessage());
    }

    @ParameterizedTest(name = "[{index}] winNumber = {0}, bonusNumber = {1}, autoNumbers = {2}, lottoWin = {3}")
    @MethodSource("whenCompareLottoWinThenSuccessDummy")
    @DisplayName("당첨 번호를 통한 당첨 순위 검색 성공 테스트")
    void whenCompareLottoWinThenSuccessTest(Set<Integer> winNumbers, int bonusNumber, List<Integer> autoNumbers, LottoWin lottoWin) {
        Lotto lotto = new Lotto(autoNumbers);
        LottoWinNumber lottoWinNumber = new LottoWinNumber(winNumbers, bonusNumber);
        LottoWin lottoWinResult = lottoWinNumber.compareWith(lotto);
        assertThat(lottoWinResult).isEqualTo(lottoWin);
    }

    static Stream<Arguments> whenWrongArgumentsThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments(Set.of(1, 2, 3, 4, 5), 45, LOTTO_NUMBER_WRONG_SIZE),
                Arguments.arguments(Set.of(1, 2, 3, 4), 45, LOTTO_NUMBER_WRONG_SIZE),
                Arguments.arguments(Set.of(1, 2, 3), 45, LOTTO_NUMBER_WRONG_SIZE),
                Arguments.arguments(Set.of(1, 2), 45, LOTTO_NUMBER_WRONG_SIZE),
                Arguments.arguments(Set.of(1), 45, LOTTO_NUMBER_WRONG_SIZE),
                Arguments.arguments(Set.of(), 45, LOTTO_NUMBER_WRONG_SIZE),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6, 7), 45, LOTTO_NUMBER_WRONG_SIZE),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6, 7, 8), 45, LOTTO_NUMBER_WRONG_SIZE),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6, 7, 9), 45, LOTTO_NUMBER_WRONG_SIZE),
                Arguments.arguments(Set.of(0, 2, 3, 4, 5, 6), 45, LOTTO_NUMBER_OVER_RANGE),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 46), 45, LOTTO_NUMBER_OVER_RANGE),
                Arguments.arguments(Set.of(-1, 2, 3, 4, 5, 6), 45, LOTTO_NUMBER_OVER_RANGE),
                Arguments.arguments(Set.of(-1, 2, 3, 4, 5, 6), 45, LOTTO_NUMBER_OVER_RANGE),
                Arguments.arguments(Set.of(-1, -2, -3, -4, -5, -6), 45, LOTTO_NUMBER_OVER_RANGE),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), -1, LOTTO_NUMBER_OVER_RANGE),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 0, LOTTO_NUMBER_OVER_RANGE),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 46, LOTTO_NUMBER_OVER_RANGE),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 1, LOTTO_NUMBER_DUPLICATED),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 2, LOTTO_NUMBER_DUPLICATED),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 3, LOTTO_NUMBER_DUPLICATED),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 4, LOTTO_NUMBER_DUPLICATED),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 5, LOTTO_NUMBER_DUPLICATED),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 6, LOTTO_NUMBER_DUPLICATED));
    }

    static Stream<Arguments> whenCompareLottoWinThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)), FIRST_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 10), 45, new ArrayList<>(List.of(1, 2, 3, 4, 5, 10)), FIRST_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 20, 22), 45, new ArrayList<>(List.of(1, 2, 3, 4, 20, 22)), FIRST_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 40, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 40, 4, 5, 6)), FIRST_PRICE_WINNER),
                Arguments.arguments(Set.of(6, 12, 18, 23, 36, 43), 45, new ArrayList<>(List.of(6, 12, 18, 23, 36, 43)), FIRST_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 3, 4, 45, 6)), SECOND_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 10), 45, new ArrayList<>(List.of(1, 2, 3, 4, 45, 10)), SECOND_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 20, 22), 45, new ArrayList<>(List.of(1, 2, 3, 4, 45, 22)), SECOND_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 40, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 40, 4, 45, 6)), SECOND_PRICE_WINNER),
                Arguments.arguments(Set.of(6, 12, 18, 23, 36, 43), 45, new ArrayList<>(List.of(6, 12, 18, 23, 45, 43)), SECOND_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 3, 4, 44, 6)), THIRD_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 10), 45, new ArrayList<>(List.of(1, 2, 3, 4, 44, 10)), THIRD_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 20, 22), 45, new ArrayList<>(List.of(1, 2, 3, 4, 44, 22)), THIRD_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 40, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 40, 4, 44, 6)), THIRD_PRICE_WINNER),
                Arguments.arguments(Set.of(6, 12, 18, 23, 36, 43), 45, new ArrayList<>(List.of(6, 12, 18, 23, 44, 43)), THIRD_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 3, 4, 44, 42)), FOURTH_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 10), 45, new ArrayList<>(List.of(1, 2, 3, 4, 44, 42)), FOURTH_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 20, 22), 45, new ArrayList<>(List.of(1, 2, 3, 4, 44, 42)), FOURTH_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 40, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 40, 4, 44, 42)), FOURTH_PRICE_WINNER),
                Arguments.arguments(Set.of(6, 12, 18, 23, 36, 43), 45, new ArrayList<>(List.of(6, 12, 18, 23, 44, 42)), FOURTH_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 3, 41, 44, 42)), FIFTH_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 10), 45, new ArrayList<>(List.of(1, 2, 3, 41, 44, 42)), FIFTH_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 20, 22), 45, new ArrayList<>(List.of(1, 2, 3, 41, 44, 42)), FIFTH_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 40, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 40, 41, 44, 42)), FIFTH_PRICE_WINNER),
                Arguments.arguments(Set.of(6, 12, 18, 23, 36, 43), 45, new ArrayList<>(List.of(6, 12, 18, 41, 44, 42)), FIFTH_PRICE_WINNER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), 45, new ArrayList<>(List.of(1, 2, 10, 41, 44, 42)), LOSER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 10), 45, new ArrayList<>(List.of(1, 2, 11, 41, 44, 42)), LOSER),
                Arguments.arguments(Set.of(1, 2, 3, 4, 20, 22), 45, new ArrayList<>(List.of(1, 2, 10, 41, 44, 42)), LOSER),
                Arguments.arguments(Set.of(1, 2, 40, 4, 5, 6), 45, new ArrayList<>(List.of(1, 10, 40, 41, 44, 42)), LOSER),
                Arguments.arguments(Set.of(6, 12, 18, 23, 36, 43), 45, new ArrayList<>(List.of(10, 12, 18, 41, 44, 42)), LOSER)
        );
    }
}