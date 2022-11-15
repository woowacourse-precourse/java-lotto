package lotto.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    private LottoValidator lottoValidator;

    @BeforeEach
    void setUp() {
        lottoValidator = new LottoValidator();
    }
    @DisplayName("로또 번호가 1~45사이의 숫자라면 true를 반환한다")
    @Test
    void checkNumber() {
        assertThat(lottoValidator.checkLottoRange(45)).isTrue();
    }


    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 예외가 발생한다.")
    @Test
    void createNotNaturalNumber1() {
        assertThatThrownBy(() -> {
            lottoValidator.checkBonusContain(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createNotNaturalNumber2() {
        assertThatThrownBy(() -> {
            lottoValidator.checkBonusRange(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void createNotNaturalNumber4() {
        assertThatThrownBy(() -> {
            lottoValidator.checkNumberCount("1,2,3,4,5,6,7");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 입력이 들어오면 예외가 발생한다.")
    @Test
    void createNotNaturalNumber5() {
        assertThatThrownBy(() -> {
            lottoValidator.checkInputForm("a,b,c,d,e,f");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}