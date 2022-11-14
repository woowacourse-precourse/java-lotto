package lotto;

import lotto.controller.InputController;
import lotto.model.LottoInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoInputTest {

    LottoInput lottoInput = new LottoInput();
    InputController inputController = new InputController(lottoInput);

    @DisplayName("입력한 구입 금액 정수로 알맞게 바꾸어 반환한다.")
    @Test
    public void inputPurchaseAmountTest(){
        String input = "8000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(lottoInput.inputPurchaseAmount()).isEqualTo(8000);
    }

    @DisplayName("구매금액 입력값이 1000으로 나눠떨어지지 않으면 오류 발생")
    @Test
    public void inputNotDividedBy1000(){
        String input = "8400";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->inputController.getPurchaseAmount()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값을 정수 리스트로 반환")
    @Test
    public void inputWinNumberTest(){
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(lottoInput.inputWinNumber()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("보너스 번호 입력값을 정수로 반환")
    @Test
    public void inputBonusNumberTest(){
        String input = "14";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(LottoInput.inputBonusNumber()).isEqualTo(14);
    }

    @DisplayName("문자열을 정수 리스트로 토큰화해주는 함수")
    @Test
    public void stringTokenizerTest(){
        String input = "1,2,3,4,5,6";
        assertThat(LottoInput.tokenizeNumber(input)).isEqualTo(List.of(1,2,3,4,5,6));
    }


    @DisplayName("보너스 번호의 범위 유효성 검사")
    @Test
    public void inputBonusNumberValidate(){
        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->lottoInput.inputBonusNumber()).isInstanceOf(IllegalArgumentException.class);
    }
}