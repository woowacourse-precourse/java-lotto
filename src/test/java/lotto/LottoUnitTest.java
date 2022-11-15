package lotto;

import lotto.Model.*;
import lotto.Model.enums.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoUnitTest {

    @DisplayName("구매 금액에 대해 올바른 개수를 갖는지 확인")
    @Test
    void purchaseTest() {
        int money = 15000;
        Purchase purchase = new Purchase(money);
        assertThat(purchase.getLottoCount()).isEqualTo(15);
    }


    @DisplayName("로또 리스트와 당첨 번호, 보너스 번호를 비교하고 각 등수별 당첨 내역을 확인")
    @Test
    void drawTest() {
        List<Integer> winning = List.of(1,2,3,4,5,6);
        int bonus = 7;
        List<List<Integer>> lottoes = List.of(
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,5,9),
                List.of(1,2,3,4,8, 10),
                List.of(1,2,3,8,9,10)
        );
        Draw draw = new Draw(winning, bonus, lottoes);
        List<Integer> prizeCounts = new ArrayList<>();
        for(Prize prize: Prize.values()){
            prizeCounts.add(prize.getPrizeCount());
        }
        assertThat(prizeCounts).isEqualTo(List.of(1,1,1,1,1));
    }


    @DisplayName("수익률 계산 확인")
    @Test
    void yeildTest() {
        int money = 15000;
        Yeild yeild = new Yeild(money);
        Prize.FIFTH.increaseCount();
        Prize.SECOND.increaseCount();
        Prize.SECOND.increaseCount();
        Prize.FIRST.increaseCount();
        yeild.createStatistic();
        assertThat(yeild.getYeild()).isEqualTo(13733366.67);
    }
}
