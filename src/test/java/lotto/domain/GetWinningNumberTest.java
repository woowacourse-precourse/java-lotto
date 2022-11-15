package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

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
    @DisplayName("입력 받은 당첨번호가 1 ~ 45 사이의 번호인지에 대한 경우")
    @Test
    void betweenRange(){
        String input = "1,3,45,6,20,33";
        getWinningNumber.getWinningNumber(input);
        for (Integer number : getWinningNumber.winningNumber) {
            assertThat(number).isBetween(1, 45);
        }
    }
    @DisplayName("당첨번호의 길이가 6인지에 대한 경우")
    @Test
    void winningNumberSize(){
        String input = "1,2,3,4,5,6";
        getWinningNumber.getWinningNumber(input);
        assertThat(getWinningNumber.winningNumber.size()).isEqualTo(6);
    }
}