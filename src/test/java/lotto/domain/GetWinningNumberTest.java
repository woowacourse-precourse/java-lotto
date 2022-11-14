package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class GetWinningNumberTest {
    GetWinningNumber getWinningNumber = new GetWinningNumber();
    @DisplayName("입력받은 당첨 번호가 리스트로 잘 만들어지는지에 대한 경우")
    @Test
    void getWinningNumber() {
        String input = "1,2,3,4,5,6";
        getWinningNumber.getWinningNumber(input);
        assertThat(getWinningNumber.winningNumber).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}