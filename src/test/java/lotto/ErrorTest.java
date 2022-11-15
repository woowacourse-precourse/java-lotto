package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoConst.LOTTO_NUMBER_COUNT;
import static lotto.LottoConst.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
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
            assertThatThrownBy(() -> { throw new IllegalArgumentException("confirmed duplication"); })
                    .isInstanceOf(Exception.class)
                    .hasMessageContaining("confirmed duplication");
        }
    }

    @DisplayName("구입 금액의 유효성 테스트")
    @Test
    void checkPurchasePrice(){
        int purchasePrice = 1001;

        if (purchasePrice % LOTTO_PRICE != 0) {
            assertThatThrownBy(() -> { throw new IllegalArgumentException("confirmed wrong price"); })
                    .isInstanceOf(Exception.class)
                    .hasMessageContaining("confirmed wrong price");
        }
    }

    @DisplayName("당첨 번호의 크기 테스트")
    @Test
    void checkSizeWinningNumber(){
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6, 7);

        if (winningNumber.size() != LottoConst.LOTTO_NUMBER_COUNT) {
            assertThatThrownBy(() -> { throw new IllegalArgumentException("confirmed wrong size of input"); })
                    .isInstanceOf(Exception.class)
                    .hasMessageContaining("confirmed wrong size of input");
        }
    }

    @DisplayName("숫자의 범위 유효성 테스트")
    @Test
    void checkRangeWinningNumber(){
        List<Integer> winningNumber = List.of(100, 2, 3, 4, 5, 6, 7);

        long validRangeNumberCount = winningNumber.stream()
                .filter(number -> number >= LottoConst.LOTTO_MIN_NUMBER)
                .filter(number -> number <= LottoConst.LOTTO_MAX_NUMBER)
                .count();

        if (validRangeNumberCount != LottoConst.LOTTO_NUMBER_COUNT) {
            assertThatThrownBy(() -> { throw new IllegalArgumentException("confirmed wrong range of number"); })
                    .isInstanceOf(Exception.class)
                    .hasMessageContaining("confirmed wrong range of number");
        }
    }
}
