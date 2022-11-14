package lotto;

import controller.InputNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputNumberTest {
    @DisplayName("당첨번호가 제대로 파싱되는지 확인")
    @Test
    void 당첨번호_파싱_확인_테스트() {
        assertThat(InputNumber.parseWinningNumber("1,2,3,4,5,6")).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 제대로 파싱되는지 확인")
    @Test
    void 보너스번호_파싱_확인_테스트() {
        assertThat(InputNumber.parseWinningNumber("7")).isEqualTo(List.of(7));
    }
}
