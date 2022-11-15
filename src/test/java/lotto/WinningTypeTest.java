package lotto;

import lotto.utils.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTypeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 당첨_타입_테스트_숫자_3개_미만(int matchCount) {
        assertThat(WinningType.of(matchCount, false)).isEqualTo(WinningType.NOTHING);
    }
    @Test
    void 당첨_타입_숫자_5개_보너스볼(){
        assertThat(WinningType.of(5,true)).isEqualTo(WinningType.SECOND_PLACE);
    }
}
