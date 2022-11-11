package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LotteryNumberTest extends NsTest {
    @DisplayName("추첨 번호는 사용자가 구매한 수량만큼 생성되어야 한다.")
    @Test
    void createLotteryNumberByPurchaseQuantity() {
        LotteryNumber lotteryNumber = new LotteryNumber(3000);
        assertThat(lotteryNumber.getNumbers().size() == 3);
    }

    @DisplayName("추첨 번호들은 각각 오름차순으로 정렬되어야 한다.")
    @Test
    void createLotteryNumberByAscendingOrder() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LotteryNumber lotteryNumber = new LotteryNumber(3000);
                    List<List<Integer>> orderedNumbers = new ArrayList<>();

                    orderedNumbers.add(List.of(1, 3, 5, 7, 9));
                    orderedNumbers.add(List.of(11, 13, 17, 23, 32, 42));
                    orderedNumbers.add(List.of(1, 3, 5, 7, 9));

                    assertThat(lotteryNumber.getNumbers().equals(orderedNumbers));
                },
                List.of(11, 9, 7, 5, 3, 1),
                List.of(13, 23, 42, 11, 32, 17),
                List.of(3, 6, 1, 5, 4, 2)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
