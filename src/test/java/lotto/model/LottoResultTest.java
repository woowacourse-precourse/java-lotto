package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultTest {
    @Test
    void 당첨번호_테스트(){
        String input = "1,2,33,4,5,45";
        LottoResult lottoResult = new LottoResult(input);
        assertThat(lottoResult.getWinningNumbers()).contains(1,2,33,4,5,45);
    }

    @Test
    void 보너스번호_테스트(){
        String input = "30";
        LottoResult lottoResult = new LottoResult("1,2,3,4,5,6");
        lottoResult.setBonusNumber("10");
        assertThat(lottoResult.getBonusNumber()).isEqualTo(10);
    }

    @DisplayName("형식에 맞지 않는 당첨 번호가 입력되면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"1,a,2,3,4,5", "1,,2,3,4,5,6", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void createInvalidWinningNumberPattern(String input){
        assertThatThrownBy(() -> new LottoResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호로 중복된 숫자가 입력되면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1,2,3,4,5", "1,1,1,1,1,1"})
    void createDuplicatedWinningNumber(String input){
        assertThatThrownBy(() -> new LottoResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 1~45 이내의 숫자가 입력되지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    void createOutRangeWinningNumber(String input){
        assertThatThrownBy(() -> new LottoResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("형식에 맞지 않는 보너스번호가 입력되면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6", "#", "1,2,3,4,5,6", "1,2,3"})
    void createInvalidBonusNumberPattern(String bonusNumber){
        LottoResult lottoResult = new LottoResult("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoResult.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호로 당첨번호와 중복된 숫자가 입력되면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4", "5", "6"})
    void createDuplicatedBonusNumber(String bonusNumber){
        LottoResult lottoResult = new LottoResult("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoResult.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호에 1~45 이내의 숫자가 입력되지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"0", "46"})
    void createOutRangeBonusNumber(String bonusNumber){
        LottoResult lottoResult = new LottoResult("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoResult.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}