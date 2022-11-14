package lotto.service.executeLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LotteryTicketsIssuanceTest {
    @DisplayName("입력한 금액만큼 복권을 발급하는지 테스트 1")
    @Test
    void issueTest1() {
        LotteryTicketsIssuance issue = new LotteryTicketsIssuance(11000);
        List<List<Integer>> numbers = issue.getLotteries();
        int EXPECTED_RESULT = 11;
        assertThat(numbers.size()).isEqualTo(EXPECTED_RESULT);
    }


    @DisplayName("입력한 금액만큼 복권을 발급하는지 테스트 2")
    @Test
    void issueTest2() {
        LotteryTicketsIssuance issue = new LotteryTicketsIssuance(5000);
        List<List<Integer>> numbers = issue.getLotteries();
        int EXPECTED_RESULT = 5;
        assertThat(numbers.size()).isEqualTo(EXPECTED_RESULT);
    }
}
