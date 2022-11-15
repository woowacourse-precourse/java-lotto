package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.InputPreprocessUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinNumberTest {

    @DisplayName("1,2,3,4,5,6 문자열을 받아 [1,2,3,4,5,6] 리스트를 반환한다.")
    @Test
    void correctInputPreprocessUtilsTest(){
        assertThat(InputPreprocessUtils.preprocess("1,2,3,4,5,6")).containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("잘못된 문자열 입력시 익셉션을 발생한다.")
    @Test
    void invalidInputPreprocessUtilsTest(){
        assertThatThrownBy(()-> InputPreprocessUtils.preprocess("asd")).isInstanceOf(IllegalArgumentException.class);
    }
}
