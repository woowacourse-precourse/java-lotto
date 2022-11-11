package Util;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static domain.ErrorMessage.NOT_WINNING_LOTTO_INPUT_STYLE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputUtilsTest {
    final static InputUtils utils = new InputUtils();
    @Test
    @DisplayName("천단위 숫자 외의 모든 값을 예외처리한다.")
    public void 입력값_예외처리() throws Exception {
        //given
        String[] inputs = {"str54", "123", "1024"};

        //when then
        for (String input : inputs) {
            assertThatThrownBy(() -> utils.validateMoney(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("금액 입력 시 int 형식으로 반환")
    public void 금액_반환_확인() throws Exception {
        //given
        String input = "5000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        int money = utils.StringToMoney();

        //then
        assertThat(money).isEqualTo(5000);
    }

    @Test
    @DisplayName("당첨번호 입력 요구사항 양식을 제외한 모든 값을 예외처리")
    public void 당첨_번호_입력_예외처리() throws Exception {
        //given
        String[] inputs = {"1, 2,3,4,5,6","2,,3,4,5,6,7", "11,33,24,4,21,1,5"};

        //when then
        for (String input : inputs) {
            assertThatThrownBy(() -> utils.validateWinningLottoNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_WINNING_LOTTO_INPUT_STYLE_ERROR.getMessage());
        }
    }

    @Test
    @DisplayName("번호 입력 시 Lotto 리스트 반환 확인")
    public void 당첨_로또_생성() throws Exception {
        //given
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        Lotto winningLotto = utils.StringToWinningLottoNumber();

        //then
        assertThat(winningLotto.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("숫자 확인, 1 ~ 45 범위 확인, 당첨 번호와 중복x")
    public void 보너스_번호_입력_예외처리() throws Exception {
        //given
        String[] inputs = {"숫자", "46", "11"};
        Lotto winningNumbers = new Lotto(List.of(11,4,32,33,22,28));

        //when then
        for (String input : inputs) {
            assertThatThrownBy(() -> utils.validateBonus(input, winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("번호 입력시 int 반환")
    public void 보너스_번호_생성() throws Exception {
        //given
        String input = "15";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Lotto winningNumbers = new Lotto(List.of(11,4,32,33,22,28));

        //when
        int bonus = utils.StringToBonus(winningNumbers);

        //then
        assertThat(bonus).isEqualTo(15);
    }
}