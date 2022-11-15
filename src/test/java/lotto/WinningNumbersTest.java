package lotto;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("당첨 번호 값 테스트")
    @Test
    void winningNumberInputTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();

        Integer[] input = {1,2,3,4,5,6};
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input)));

        Field winningNumbersField = WinningNumbers.class.getDeclaredField("winningNumbers");
        winningNumbersField.setAccessible(true);
        Lotto winningLotto = (Lotto) winningNumbersField.get(winningNumbers);

        for (int index = 0; index < input.length; index++) {
            assertThat(winningLotto.findLottoNumber(index))
                    .isEqualTo(input[index]);
        }
    }

    @DisplayName("당첨 번호 예외 테스트")
    @Test
    void winningNumberInputExceptionTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();

        Integer[] input1 = {1,2,3,4,5,6,7};
        Integer[] input2 = {1,2,3,4,5};
        Integer[] input3 = {1,1,1,2,2,2};
        Integer[] input4 = {1,2,3,4,5,50};

        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input1))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input2))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input3))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input4))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 값 테스트")
    @Test
    void bonusNumberInputTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();
        Integer[] inputs = {1,2,3,4,5,6};
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(inputs)));

        int testNumber = 7;
        winningNumbers.newBonusNumber(testNumber);

        Field bonusNumberField = WinningNumbers.class.getDeclaredField("bonusNumber");
        bonusNumberField.setAccessible(true);
        int bonusNumber = (int) bonusNumberField.get(winningNumbers);

        assertThat(bonusNumber).isEqualTo(testNumber);
    }

    @DisplayName("보너스 번호 예외 테스트")
    @Test
    void bonusNumberInputExceptionTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();

        int testNumber1 = 0;
        int testNumber2 = 50;

        assertThatThrownBy(() -> winningNumbers.newBonusNumber(testNumber1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> winningNumbers.newBonusNumber(testNumber2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 당첨 번호와 중복 예외 테스트")
    @Test
    void bonusNumberDuplicateTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();

        Integer[] inputLotto = {1,2,3,4,5,6};
        int bonusNumber= 1;
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(inputLotto)));

        assertThatThrownBy(() -> winningNumbers.newBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 순위 반환 값 테스트")
    @Test
    void rankingLotto() {
        WinningNumbers winningNumbers = new WinningNumbers();

        Integer[] inputLotto = {1,2,3,4,5,6};
        int bonusNumber= 7;
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(inputLotto)));
        winningNumbers.newBonusNumber(bonusNumber);

        Integer[] firstNumbers = {1,2,3,4,5,6};
        Lotto firstLotto = new Lotto(new ArrayList<>(List.of(firstNumbers)));
        Integer[] secondNumbers = {1,2,3,4,5,7};
        Lotto secondLotto = new Lotto(new ArrayList<>(List.of(secondNumbers)));
        Integer[] thirdNumbers = {1,2,3,4,5,8};
        Lotto thirdLotto = new Lotto(new ArrayList<>(List.of(thirdNumbers)));
        Integer[] firthNumbers = {1,2,3,4,8,9};
        Lotto firthLotto = new Lotto(new ArrayList<>(List.of(firthNumbers)));
        Integer[] fifthNumbers = {1,2,3,8,9,10};
        Lotto fifthLotto = new Lotto(new ArrayList<>(List.of(fifthNumbers)));
        Integer[] loseNumbers = {1,2,8,9,10,11};
        Lotto loseLotto = new Lotto(new ArrayList<>(List.of(loseNumbers)));

        assertThat(winningNumbers.rankingLotto(firstLotto))
                .isEqualTo(Rank.FIRST_CLASS);
        assertThat(winningNumbers.rankingLotto(secondLotto))
                .isEqualTo(Rank.SECOND_CLASS);
        assertThat(winningNumbers.rankingLotto(thirdLotto))
                .isEqualTo(Rank.THIRD_CLASS);
        assertThat(winningNumbers.rankingLotto(firthLotto))
                .isEqualTo(Rank.FIRTH_CLASS);
        assertThat(winningNumbers.rankingLotto(fifthLotto))
                .isEqualTo(Rank.FIFTH_CLASS);
        assertThat(winningNumbers.rankingLotto(loseLotto))
                .isEqualTo(Rank.LOSE_LOTTO);
    }
}
