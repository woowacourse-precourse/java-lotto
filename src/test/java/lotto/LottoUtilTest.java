package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoUtilTest {
    private static LottoUtil lottoUtil;

    @BeforeAll
    public static void setUp() {
        lottoUtil = new LottoUtil();
    }

    @DisplayName("문자열을 정수로 변환.")
    @Test
    void convertStringToInt() {
        String input1 = "1234";
        String input2 = "3000";

        assertAll(() -> assertThat(this.lottoUtil.StringToInt(input1)).isEqualTo(1234),
                () -> assertThat(this.lottoUtil.StringToInt(input2)).isEqualTo(3000));
    }

    @DisplayName("정수로 변환이 불가능한 문자열이 들어오면 예외가 발생한다.")
    @Test
    void convertStringToIntException() {
        assertThatThrownBy(() -> this.lottoUtil.StringToInt("q143"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
