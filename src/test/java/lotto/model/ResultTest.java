package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

// TODO Parameterized Tests 적용 방법 공부하기
class ResultTest {

    // 다양한 Test Case는 `ApplicationTest`에서 Integration Test로 진행

    @Test
    void getResultByFirstPrize() {
        Purchase purchase = new Purchase(1000);
        LottoTickets lottoTickets = new LottoTickets(purchase);
        WinningNumbers winningNumbers = new WinningNumbers(lottoTickets.getTickets().get(0).getNumbers());
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);

        Result result = new Result(lottoTickets, winningNumbers, bonusNumber);
        assertThat(result.getPrizeCount())
                .isNotEmpty()
                .containsKey(Prize.SECOND)
                .contains(entry(Prize.FIRST, 1));
    }

    @Test
    void getResultByNoneOfPrize() {
        Purchase purchase = new Purchase(8000);
        LottoTickets lottoTickets = new LottoTickets(purchase);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(7,8,9,10,11,12));
        BonusNumber bonusNumber = new BonusNumber(13, winningNumbers);
        Result result = new Result(lottoTickets, winningNumbers, bonusNumber);
        assertThat(result.getPrizeCount())
                .isNotEmpty()
                .containsKey(Prize.FIRST)
                .containsKey(Prize.SECOND)
                .containsKey(Prize.THIRD)
                .containsKey(Prize.FOURTH)
                .containsKey(Prize.FIFTH);
    }
}