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
    void createInvalidPattern(String input){
        assertThatThrownBy(() -> new LottoResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호로 중복된 숫자가 입력되면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1,2,3,4,5", "1,1,1,1,1,1"})
    void createDuplicatedNumber(String input){
        assertThatThrownBy(() -> new LottoResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 1~45 이내의 숫자가 입력되지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    void createOutRangeNumber(String input){
        assertThatThrownBy(() -> new LottoResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}