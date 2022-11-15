package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConversionUtilityTest {
    private ConversionUtility conversionUtility;

    @BeforeEach
    void setUp() {
        conversionUtility = new ConversionUtility();
    }

    @DisplayName("입력한 당첨 번호 문자열을 Integer 타입의 리스트로 변환하는 기능 테스트")
    @Test
    void convertStringWinningNumbersToList() {
        String inputWinningNumbers = "1,2,3,4,5,6";

        List<Integer> winningNumbers = conversionUtility.convertStringWinningNumbersToList(inputWinningNumbers);

        Assertions.assertThat(winningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

}