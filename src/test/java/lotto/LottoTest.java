package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("당첨 숫자랑 비교")
    @CsvSource({
            "1-2-3-4-5-6, 6",
            "2-3-4-5-6-8, 5",
            "1-2-3-7-8-9, 3",
            "5-2-7-35-3-4, 4",
            "34-45-2-24-13-26, 1"
    })
    void testMatchCountOfWinningNumbers(String lottoList, int expectedAnswer) {
        //given : 당첨숫자, lotto numbers
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> collect = Arrays.stream(lottoList.split("-"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(collect);

        //when
        int countOfWinningNumbers = lotto.matchCountOfWinningNumbers(winNumbers);

        //then
        assertThat(countOfWinningNumbers).isEqualTo(expectedAnswer);
    }

    @ParameterizedTest
    @DisplayName("보너스 숫자 비교")
    @CsvSource({
            "10, true",
            "11, false"
    })
    void testIsBonusNumber(int bonusNumber, boolean expectedAnswer) {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        //when
        boolean matchBonusNumber = lotto.isMatchBonusNumber(bonusNumber);

        //then
        assertThat(matchBonusNumber).isEqualTo(expectedAnswer);
    }
}
