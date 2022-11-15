package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetBonusNumberTest {
    GetBonusNumber getBonusNumber = new GetBonusNumber();
    @DisplayName("보너스 번호가 잘 생성되는 지에 대한 경우")
    @Test
    void getBonusNumber() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 45, 6, 7));
        String input = "5";
        getBonusNumber.getBonusNumber(winningNumber, input);
        assertThat(getBonusNumber.bonus).isEqualTo(5);
    }
}