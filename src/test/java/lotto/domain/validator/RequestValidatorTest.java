package lotto.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.domain.model.request.MoneyRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestValidatorTest {

    @Test
    @DisplayName("넣은 돈이 형식에 맞는지 확인하는 테스트")
    void REQUEST_TYPE_VALIDATION_CHECK() {
        MoneyRequest moneyRequest1 = new MoneyRequest(1);
        MoneyRequest moneyRequest2 = new MoneyRequest(1200);

        assertAll(
                () -> assertThatThrownBy(() -> RequestValidator.moneyValidation(moneyRequest1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("최소 구매금액은 1000원 입니다."),
                () -> assertThatThrownBy(() -> RequestValidator.moneyValidation(moneyRequest2))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1000원 단위로 입력해주세요.")
        );
    }
}