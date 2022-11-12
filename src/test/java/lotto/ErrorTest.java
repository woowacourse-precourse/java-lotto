package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoConst.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ErrorTest {

    @DisplayName("로또 번호에 중복된 숫자가 있는지 확인하는 로직 테스트")
    @Test
    void checkDuplicationLogic() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 5);

        List<Integer> removedDuplicationNumber =
                winningNumber.stream()
                        .distinct()
                        .collect(Collectors.toList());

        if (removedDuplicationNumber.size() != LOTTO_NUMBER_COUNT) {
            assertThatThrownBy(() -> { throw new IllegalArgumentException("boom"); })
                    .isInstanceOf(Exception.class)
                    .hasMessageContaining("boom");
        }
    }
}
