package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreValidationTest {
    private static final LottoStoreValidation lottoStoreValidation = new LottoStoreValidation();

    @DisplayName("개수가 1개 미만일 때 IllegalArgumentException 가 발생하는지 확인")
    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(ints = {-1, 0})
    void lotteryTicketCheck(int lottoCount) {
        assertThatThrownBy(() -> lottoStoreValidation.lotteryTicketCount(lottoCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있을 때 IllegalArgumentException 가 발생하는지 확인")
    @ParameterizedTest(name = "[{index}] : {0},{1},{2},{3},{4},{5} : IllegalArgumentException 발생")
    @CsvSource({"1,2,3,4,5,5", "1,1,2,3,4,5", "1,1,1,1,1,1", "45,45,45,45,45,45"})
    void winningNumberCheck(int number1, int number2, int number3, int number4, int number5, int number6) {
        List<Integer> exception = new ArrayList<>(List.of(number1, number2, number3, number4, number5, number6));
        assertThatThrownBy(() -> lottoStoreValidation.lottoNumberDuplicateCheck(exception))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 같으면 IllegalArgumentException 가 발생하는지 확인")
    @ParameterizedTest(name = "[{index}] : 당첨번호 : {0},{1},{2},{3},{4},{5}, 보너스 번호 {6} : IllegalArgumentException 발생")
    @CsvSource({"1,2,3,4,5,6,1", "1,2,3,4,5,6,2", "1,2,3,4,5,6,3", "1,2,3,4,5,6,4", "1,2,3,4,5,6,5", "1,2,3,4,5,6,6"})
    void bonusNumberCheck(int number1, int number2, int number3, int number4, int number5, int number6, int bonus) {
        List<Integer> exception = new ArrayList<>(List.of(number1, number2, number3, number4, number5, number6));
        assertThatThrownBy(() -> lottoStoreValidation.bonusNumberInWinningNumberCheck(exception, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}