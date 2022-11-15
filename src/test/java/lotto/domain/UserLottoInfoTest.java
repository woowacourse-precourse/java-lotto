package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class UserLottoInfoTest {

    private UserLottoInfo userLottoInfo;

    @Test
    @DisplayName("숫자 형식 아니면 예외 발생")
    void lottoPriceNonNumeric() {
        String lottoPrice = "abc01";
        assertThatThrownBy(() -> {
            userLottoInfo = new UserLottoInfo(lottoPrice);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "7890", "2500", "10001"})
    @DisplayName("1000의 배수가 아니면 예외 발생")
    void lottoPriceNotMultiplesof1000(String lottoPrice) {
        assertThatThrownBy(() -> {
            userLottoInfo = new UserLottoInfo(lottoPrice);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000:10000", "14000:14000", "8000:8000"}, delimiter = ':')
    @DisplayName("정상 입력 시, Lotto 정보 저장")
    void validLottoPrice(String lottoPrice, Integer storedPrice) {
        userLottoInfo = new UserLottoInfo(lottoPrice);
        assertThat(userLottoInfo.getLottoPrice()).isEqualTo(storedPrice);
    }

}