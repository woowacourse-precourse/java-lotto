package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import lotto.domain.LottoWinNumbers;
import lotto.utils.InputPreprocessUtils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinNumberTest {

    @DisplayName("1,2,3,4,5,6 문자열을 받아 [1,2,3,4,5,6] 리스트를 반환한다.")
    @Test
    void correctInputPreprocessUtilsTest(){
        assertThat(InputPreprocessUtils.preprocess("1,2,3,4,5,6")).containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("잘못된 문자열 입력시 익셉션을 발생한다.")
    @Test
    void invalidInputPreprocessUtilsTest(){
        assertThatThrownBy(()-> InputPreprocessUtils.preprocess("asd")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 당첨 번호 입력 시 익셉션 발생")
    @Test
    void caseDuplicatedWinNumberInput(){
        assertThatThrownBy(()-> new LottoWinNumbers(List.of(1,1,2,2,3,3))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개 이상의 당첨 번호 입력 시 익셉션 발생")
    @Test
    void caseWinNumberLengthOver(){
        assertThatThrownBy(()-> new LottoWinNumbers(List.of(1,2,3,4,5,6,7))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 이외의 숫자를 입력 시 익셉션 발생")
    @Test
    void caseWinNumberRangeOver(){
        assertThatThrownBy(()-> new LottoWinNumbers(List.of(1,2,3,4,5,46))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 로또 당첨 번호를 입력받을 경우 정상적으로 객체 생성")
    @Test
    void caseCorrectWinNumberInput(){
        assertThat(new LottoWinNumbers(List.of(1,2,3,4,5,6)).getNumbers()).containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("전달 받은 보너스 번호가 이미 당첨번호 안에 있을 경우 익셉션 발생")
    @Test
    void caseBonusAlreadyInWinNumber(){
        assertThatThrownBy(()->new LottoWinNumbers(List.of(1,2,3,4,5,6)).setBonus(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전달 받은 보너스 번호의 범위가 1~45 이외일 때 익셉션 발생")
    @Test
    void caseBonusNumberRangeOver(){
        assertThatThrownBy(()->new LottoWinNumbers(List.of(1,2,3,4,5,6)).setBonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 보너스 번호를 받을 경우 정상적으로 보너스 값 할당")
    @Test
    void caseCorrectBonusNumberInput(){
        LottoWinNumbers winNumbers = new LottoWinNumbers(List.of(1,2,3,4,5,6));
        winNumbers.setBonus(45);
        assertThat(winNumbers.getBonus()).isEqualTo(45);
    }
}
