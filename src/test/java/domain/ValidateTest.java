package domain;

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
        //given
        List<Integer> sizeError = List.of(2,3,4,5,6,7,8);
        List<Integer> duplication = List.of(2,2,4,5,6,7);
        List<Integer> outOfRange = List.of(235,32,442,51,36,7);

        //when then
        assertThatThrownBy(() -> Validate.validateLottoNumber(sizeError))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_LOTTO_SIZE_ERROR.getMessage());

        assertThatThrownBy(() -> Validate.validateLottoNumber(duplication))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_LOTTO_DISTINCT_NUMBER_ERROR.getMessage());

        assertThatThrownBy(() -> Validate.validateLottoNumber(outOfRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_LOTTO_RANGE_ERROR.getMessage());
    }

}