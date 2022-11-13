package lotto.service.executeLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LotteryNumberIssuanceTest {
    @DisplayName("1-45사이 숫자를 가진 6개의 배열 생성 테스트")
    @Test
    void checkLotteryNumberIssuance() {
        LotteryNumbersIssuance issue = new LotteryNumbersIssuance();
        List<Integer> numbers = issue.issueLotteryNumbers();

        int EXPECTED_SIZE = 6;

        System.out.println(numbers);
        assertThat(numbers.size()).isEqualTo(EXPECTED_SIZE);
    }

    // TODO: validation 테스트 코드 짜기
}
