package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import type.LottoGrade;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    List<Integer> winningNumbers;

    @BeforeEach
    void initWinningNumber() {
        winningNumbers = List.of(1, 3, 5, 7, 9, 11);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfBound() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 48)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 당첨 번호와 비교하여 일치하는 개수를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersForCountNumbersIncluded")
    void countNumbersIncluded(Integer expectedNumber, List<Integer> lottoNumbers) {
        Lotto lotto = new Lotto(lottoNumbers);
        Integer countNumbers = lotto.countNumbersIncluded(winningNumbers);
        assertThat(countNumbers).isEqualTo(expectedNumber);
    }

    @DisplayName("일치하는 로또 번호 개수에 따라 당첨 등수를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersForGetLottoGrade")
    void getLottoGrade(LottoGrade expectedGrade, Boolean containsBonusNumber, List<Integer> lottoNumbers) {
        Lotto lotto = new Lotto(lottoNumbers);
        Integer numberOfMatches = lotto.countNumbersIncluded(winningNumbers);
        LottoGrade lottoGrade = lotto.getLottoGrade(numberOfMatches, containsBonusNumber);
        assertThat(lottoGrade).isEqualTo(expectedGrade);
    }

    @DisplayName("로또 번호 중에 보너스 번호가 포함되어 있으면 true를 반환한다.")
    @Test
    void containsBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 5;
        assertThat(lotto.containsBonusNumber(bonusNumber)).isTrue();
    }

    private static Stream<Arguments> provideLottoNumbersForCountNumbersIncluded() {
        return Stream.of(
                Arguments.of(3, List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(4, List.of(1, 3, 5, 7, 13, 15)),
                Arguments.of(5, List.of(1, 3, 5, 7, 9, 13)),
                Arguments.of(6, List.of(1, 3, 5, 7, 9, 11))
        );
    }

    private static Stream<Arguments> provideLottoNumbersForGetLottoGrade() {
        return Stream.of(
                Arguments.of(LottoGrade.FIFTH, false, List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(LottoGrade.FOURTH, false , List.of(1, 3, 5, 7, 13, 15)),
                Arguments.of(LottoGrade.THIRD, false, List.of(1, 3, 5, 7, 9, 13)),
                Arguments.of(LottoGrade.SECOND, true, List.of(1, 3, 5, 7, 9, 13)),
                Arguments.of(LottoGrade.FIRST, false, List.of(1, 3, 5, 7, 9, 11))
        );
    }
}
