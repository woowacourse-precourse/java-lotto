package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawTest {
    @DisplayName("당첨 숫자와 5개 일치하고 보너스 번호와 1개 일치하는 경우")
    @Test
    void findCorrectTypeTest() {
        Enum<CorrectNum> correctType = Draw.findCorrectType
                (List.of(1, 2, 3, 4, 5, 6), List.of("1", "2", "3", "4", "5", "7"), 6);
        Assertions.assertThat(correctType).isEqualTo(CorrectNum.FIVE_BONUS);
    }
}