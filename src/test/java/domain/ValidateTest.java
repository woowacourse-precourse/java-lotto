package domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static domain.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

    private static final Validate validate = new Validate();

    @Test
    @DisplayName("천단위 숫자 외의 모든 값을 예외처리한다.")
    public void 입력값_예외처리() throws Exception {
        //given
        String[] inputs = {"str54", "123", "1024"};

        //when then
        for (String input : inputs) {
            assertThatThrownBy(() -> validate.validateMoney(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
    @Test
    @DisplayName("6자리, 중복숫자 생성, 1 ~ 45 범위를 벗어날 시 예외처리한다.")
    public void 로또_생성_예외() throws Exception {

        //when then
        assertThatThrownBy(() -> new Lotto(List.of(2,3,4,5,6,7,8)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_LOTTO_SIZE_ERROR.getMessage());

        assertThatThrownBy(() -> new Lotto(List.of(2,2,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_LOTTO_DISTINCT_NUMBER_ERROR.getMessage());

        assertThatThrownBy(() -> new Lotto(List.of(235,32,442,51,36,7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_LOTTO_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("당첨번호 입력 요구사항 양식을 제외한 모든 값을 예외처리")
    public void 당첨_번호_입력_예외처리() throws Exception {
        //given
        String[] inputs = {"1, 2,3,4,5,6","2,,3,4,5,6,7", "11,33,24,4,21,1,5"};

        //when then
        for (String input : inputs) {
            assertThatThrownBy(() -> validate.validateWinningLottoNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_WINNING_LOTTO_INPUT_STYLE_ERROR.getMessage());
        }
    }
}