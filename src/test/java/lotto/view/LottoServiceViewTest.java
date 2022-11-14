package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceViewTest {

    LottoServiceView lottoServiceView;

    @BeforeEach
    void beforeEach() {
        lottoServiceView = new LottoServiceView();
    }

    @ParameterizedTest
    @DisplayName("유효성 검사 테스트 - 최소금액 검사")
    @CsvSource(value = {"123", "567", "4", "56", "0", "1"})
    void checkMinimumAmount(String inputMoney) {

        assertThatThrownBy(() -> lottoServiceView.validateInputMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최소 구매 금액은 1,000원 이상입니다.");
    }
}