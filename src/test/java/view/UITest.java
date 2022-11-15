package view;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.Winning.SECOND_PLACE;
import static lotto.Winning.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UITest {

    UI ui = new UI();

    @Test
    @DisplayName("입력한 금액이 1000단위로 떨어지지 않을 때")
    void noMatchPurchaseAmount() {
        assertThrows(IllegalArgumentException.class, () ->{
            ui.lottoCount(13200);
        });
    }

    @Test
    @DisplayName("입력한 금액이 1000단위로 떨어질 때")
    void matchPurchaseAmount() {
        assertThatCode(() -> ui.lottoCount(13000))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력한 당첨 번호를 List<Integer>에 저장")
    void printLottoInfo() {
        String input = "1,2,3,4,5,6";
        String[] inputArr = input.split(",");
        Lotto getLottoNums = ui.convertInteger(inputArr);
        assertEquals(Arrays.toString(inputArr), getLottoNums.getNumbers().toString());
    }

    @Test
    @DisplayName("상금 확인")
    void checkYield(){
        SECOND_PLACE.setCount(2);
        THIRD_PLACE.setCount(4);
        int earnings = ui.getPrizeMoney();
        assertEquals(earnings, 66000000);
    }

}