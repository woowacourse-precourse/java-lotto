package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

// TODO test 수정 필요!
// TODO integration test와 합칠지 고민해보기
class ResultTest {
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
    void getResultBySecondPrize() {
        Purchase purchase = new Purchase(1000);
        LottoTickets lottoTickets = new LottoTickets(purchase);
        List<Integer> lotto = lottoTickets.getTickets().get(0).getNumbers();
        lotto.set(5, lotto.get(5) + 1);
        WinningNumbers winningNumbers = new WinningNumbers(lotto);
        BonusNumber bonusNumber = new BonusNumber(lotto.get(5), winningNumbers);

        Result result = new Result(lottoTickets, winningNumbers, bonusNumber);

        assertThat(result.getPrizeCount())
                .isNotEmpty()
                .containsKey(Prize.FIFTH)
                .contains(entry(Prize.SECOND, 1))
                .contains(entry(Prize.THIRD, 0));
    }

    @Test
    void getResultByThirdPrize() {
        Purchase purchase = new Purchase(1000);
        LottoTickets lottoTickets = new LottoTickets(purchase);
        List<Integer> lotto = lottoTickets.getTickets().get(0).getNumbers();
        lotto.set(5, lotto.get(5) + 1);
        WinningNumbers winningNumbers = new WinningNumbers(lottoTickets.getTickets().get(0).getNumbers());
        BonusNumber bonusNumber = new BonusNumber(lotto.get(5) - 1, winningNumbers);

        Result result = new Result(lottoTickets, winningNumbers, bonusNumber);

        assertThat(result.getPrizeCount())
                .isNotEmpty()
                .containsKey(Prize.FOURTH)
                .contains(entry(Prize.THIRD, 1))
                .contains(entry(Prize.SECOND, 0));
    }

    @Test
    void getResultByNoneOfPrize() {
        Purchase purchase = new Purchase(1000);
        LottoTickets lottoTickets = new LottoTickets(purchase);
        List<Integer> lotto = lottoTickets.getTickets().get(0).getNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(7,8,9,10,11,12));
        BonusNumber bonusNumber = new BonusNumber(13, winningNumbers);
        Result result = new Result(lottoTickets, winningNumbers, bonusNumber);

        assertThat(result.getPrizeCount())
                .isNotEmpty()
                .doesNotContainValue(1);
    }
}