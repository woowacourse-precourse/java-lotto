package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberGeneratorTest {

    private NumberGenerator numberGenerator;
    @BeforeEach
    void init(){
        numberGenerator = new NumberGenerator();
    }

    @Test
    @DisplayName("String -> List<Integer> 검사")
    void convertLottoNumberTest(){
        List<Integer> testNumber = List.of(1, 2, 3, 4, 5, 6);
        String testValue = "1, 2, 3, 4, 5, 6";
        assertThat(testNumber).isEqualTo(numberGenerator.convertLottoNumber(testValue));
    }

    @Test
    @DisplayName("사용자 로또 입력 검사")
    void validateInputLottoNumber(){
        assertThatThrownBy(() -> numberGenerator.validDataInputLottoNumber("ababba1324"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> numberGenerator.validDataInputLottoNumber("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> numberGenerator.validDataInputLottoNumber("2, 2, 6, 8, 10, 46"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> numberGenerator.validDataInputLottoNumber("1, 2, 6, 8, 10, 46"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("보너스 번호 입력 검사")
    void validDataBonusNumberTest(){
        assertThatThrownBy(() -> numberGenerator.validDataBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> numberGenerator.validDataBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(numberGenerator.validDataBonusNumber("3")).isEqualTo(3);
    }
}
