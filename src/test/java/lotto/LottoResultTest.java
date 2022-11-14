package lotto;

import lotto.Domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("로또 당첨 통계 계산 테스트")
    @Test
    void calculateLottoRanks() {
        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 7, 8)));

        LotteryTickets lotteryTickets = new LotteryTickets(0);
        lotteryTickets.setLottoTickets(lottos);

        WinningNumber winningNumber = new WinningNumber(List.of(2, 3, 4, 5, 6, 10));
        winningNumber.setBonusNum(7);

        LottoResult lottoResult = new LottoResult();

        lottoResult.calculateLottoRanks(lotteryTickets, winningNumber);

        Map<Rank, Integer> resultMap = Map.of(Rank.BOTTOM, 0, Rank.FIFTH, 0, Rank.FOURTH, 1, Rank.THIRD, 1, Rank.SECOND, 1, Rank.FIRST, 0);
        assertThat(lottoResult.getResult()).isEqualTo(resultMap);

    }

    @DisplayName("로또 당첨 총 금액 계산 테스트")
    @Test
    void getTotalEarnedMoney() {

        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto(List.of(5, 7, 9, 11, 13, 15)));
        lottos.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 7, 8)));

        LotteryTickets lotteryTickets = new LotteryTickets(0);
        lotteryTickets.setLottoTickets(lottos);

        WinningNumber winningNumber = new WinningNumber(List.of(5, 7, 9, 3, 4, 30));
        winningNumber.setBonusNum(8);

        LottoResult lottoResult = new LottoResult();

        lottoResult.calculateLottoRanks(lotteryTickets, winningNumber);

        int totalPrice = 55000;
        assertThat(lottoResult.getTotalEarnedMoney()).isEqualTo(totalPrice);

    }
}
