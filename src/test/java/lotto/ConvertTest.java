package lotto;

import java.util.List;
import lotto.Utils.Convert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ConvertTest {

    @Test
    void 문자열에서_숫자로_변환_정상입력() {
        assertThat(Convert.StrToInt("8000")).isEqualTo(8000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"8000d", "10e00", "addf", " "})
    void 문자열에서_숫자로_변환_예외처리(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Convert.StrToInt(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-8000", "0", "3000000000"})
    void 정수_범위와_천원단위가_아닌_예외처리(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Convert.StrToInt(input);
        });
    }

    @Test
    void 로또_당첨번호_정상입력() {
        assertThat(Convert.StrToList("1,2,3,4,5,6"))
            .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "16,20,d,14,40,30", ",7,12,17,25,50"})
    void 로또_당첨번호_예외처리(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Convert.StrToList(input);
        });
    }
}
