package lotto.utils;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConverterTest {
    @DisplayName("문자열을 Lotto 객체로 convert 한다.")
    @Test
    void convertToLotto() {
        //given
        String inputNumbers = "1,2,3,4,5,6";

        //when
        Lotto lotto = Converter.toLotto(inputNumbers);

        //then
        assertThat(lotto.getNumbers().isEmpty()).isFalse();
    }
}
