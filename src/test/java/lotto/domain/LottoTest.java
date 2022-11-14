package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("기본흐름: 1~45까지의 번호 6개를 중복되지 않게 입력하는 경우")
    void Lotto_ValidInput1_Success() {
        Lotto lotto = new Lotto(Arrays.asList(3, 11, 17, 23, 34, 41));
        assertThat(lotto.toString()).isEqualTo("[3, 11, 17, 23, 34, 41]");
    }

    @Test
    @DisplayName("기본흐름: 1~45까지의 번호 6개를 중복되지 않게 순서 없이 입력하는 경우")
    void Lotto_ValidInput2_Success() {
        Lotto lotto = new Lotto(Arrays.asList(41, 17, 11, 34, 23, 3));
        assertThat(lotto.toString()).isEqualTo("[3, 11, 17, 23, 34, 41]");
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 범위의 숫자를 입력한 경우1")
    void Lotto_InvalidRange1_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(0, 11, 17, 23, 34, 41)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 범위의 숫자를 입력한 경우2")
    void Lotto_InvalidRange2_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(3, 11, 17, 23, 34, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 개수의 숫자를 입력한 경우1")
    void Lotto_InvalidCount1_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(3, 11, 17, 23, 34)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_SIZE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 개수의 숫자를 입력한 경우2")
    void Lotto_InvalidCount2_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(3, 11, 17, 23, 34, 41, 45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_SIZE.toString());
    }

    @Test
    @DisplayName("예외흐름: 중복된 숫자를 입력한 경우")
    void Lotto_DuplicateNumber_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(3, 11, 17, 23, 23, 45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.DUPLICATE_LOTTO_NUMBER.toString());
    }
}