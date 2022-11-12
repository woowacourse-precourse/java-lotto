package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("로또 당첨 번호와 사용자의 로또 번호의 일치 여부에 따른 1위 순위 반환 확인")
    @Test
    public void countCorrespondingNumbersTest_FirstPlace() throws Exception {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningPlace expectedValue = WinningPlace.FIRST_PLACE;

        //when
        Lotto lotto = new Lotto(winnerNumber);
        WinningPlace actualValue = lotto.countCorrespondingNumbers(winnerNumber, checkTargetNumber, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("로또 당첨 번호와 사용자의 로또 번호의 일치 여부에 따른 2위 순위 반환 확인")
    @Test
    public void countCorrespondingNumbersTest_SecondPlace() throws Exception {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 7;
        WinningPlace expectedValue = WinningPlace.SECOND_PLACE;

        //when
        Lotto lotto = new Lotto(winnerNumber);
        WinningPlace actualValue = lotto.countCorrespondingNumbers(winnerNumber, checkTargetNumber, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("로또 당첨 번호와 사용자의 로또 번호의 일치 여부에 따른 3위 순위 반환 확인")
    @Test
    public void countCorrespondingNumbersTest_ThirdPlace() throws Exception {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 8;
        WinningPlace expectedValue = WinningPlace.THIRD_PLACE;

        //when
        Lotto lotto = new Lotto(winnerNumber);
        WinningPlace actualValue = lotto.countCorrespondingNumbers(winnerNumber, checkTargetNumber, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("보너스 번호 일치로 인한 3위 인정은 예외가 발생한다.")
    @Test
    public void countCorrespondingNumbersTest_ThirdPlace_BonusNumberException() throws Exception {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 4, 7, 8);
        int bonusNumber = 8;
        //when

        //then
        assertThatThrownBy(() -> new Lotto(winnerNumber).countCorrespondingNumbers(winnerNumber, checkTargetNumber, bonusNumber))
                .isInstanceOf(Exception.class);
    }

    @DisplayName("로또 당첨 번호와 사용자의 로또 번호의 일치 여부에 따른 4위 순위 반환 확인")
    @Test
    public void countCorrespondingNumbersTest_FourthPlace() throws Exception {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 4, 7, 8);
        int bonusNumber = 9;
        WinningPlace expectedValue = WinningPlace.FOURTH_PLACE;

        //when
        Lotto lotto = new Lotto(winnerNumber);
        WinningPlace actualValue = lotto.countCorrespondingNumbers(winnerNumber, checkTargetNumber, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("보너스 번호 일치로 인한 4위 인정은 예외가 발생한다.")
    @Test
    public void countCorrespondingNumbersTest_FourthPlace_BonusNumberException() throws Exception {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 7, 8, 9);
        int bonusNumber = 9;
        //when

        //then
        assertThatThrownBy(() -> new Lotto(winnerNumber).countCorrespondingNumbers(winnerNumber, checkTargetNumber, bonusNumber))
                .isInstanceOf(Exception.class);
    }

    @DisplayName("로또 당첨 번호와 사용자의 로또 번호의 일치 여부에 따른 5위 순위 반환 확인")
    @Test
    public void countCorrespondingNumbersTest_FifthPlace() throws Exception {
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 3, 7, 8, 9);
        int bonusNumber = 10;
        WinningPlace expectedValue = WinningPlace.FIFTH_PLACE;

        //when
        Lotto lotto = new Lotto(winnerNumber);
        WinningPlace actualValue = lotto.countCorrespondingNumbers(winnerNumber, checkTargetNumber, bonusNumber);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("당첨되지 않은 경우에는 NOT_IN_LIST 예외가 발생한다.")
    @Test
    public void countCorrespondingNumbersTest_NotInList() throws Exception{
        //given
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> checkTargetNumber = Arrays.asList(1, 2, 10, 11, 12, 13);
        int bonusNumber = 14;
        //when

        //then
        assertThatThrownBy(() -> new Lotto(winnerNumber).countCorrespondingNumbers(winnerNumber, checkTargetNumber, bonusNumber))
                .isInstanceOf(Exception.class);
    }
}
