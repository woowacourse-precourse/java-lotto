package lotto.modelTest;

import lotto.model.RaffleNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class RaffleNumberTest {
    private static final String WRONG_QUANTITY_ERROR_MESSAGE="[ERROR] 추첨 번호가 6개가 아닙니다. 프로그램을 종료합니다.";
    @Test
    @DisplayName("추첨 번호 6개가 아니라면 에러를 출력한다.")
    public void createRaffleNumberTest(){
        List<Integer> raffleNumber = List.of(1,2,3,4,5,6,7);
        assertThatThrownBy(()->new RaffleNumber(raffleNumber)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(WRONG_QUANTITY_ERROR_MESSAGE);
    }
}
