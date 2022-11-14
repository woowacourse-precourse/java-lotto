package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("당첨 번호 String 을 받아서 List<Integer> 로 변환 테스트")
    void convertStringToNumberTest() {
        String numbers = "1,2,3,4,5,6";
        List<Integer> lottoNumbers = LottoMachine.convertStringToNumber(numbers);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        for (int i = 0; i < lottoNumbers.size(); i++) {
            assertThat(lottoNumbers.get(i)).isEqualTo(expected.get(i));
        }
    }
}
