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
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 7, 8)));

        LotteryTickets lotteryTickets = new LotteryTickets(0);
        lotteryTickets.setLottoTickets(lottos);

        WinningNumber winningNumber = new WinningNumber(List.of(5, 7, 9, 3, 4, 30));
        winningNumber.setBonusNum(8);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoRanks(lotteryTickets, winningNumber);

        assertThat(lottoResult.getTotalEarnedMoney()).isEqualTo(55000);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void getEarnedRatio() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(5, 7, 9, 11, 13, 15)));
        lottos.add(new Lotto(List.of(2, 4, 6, 8, 10, 12)));
        lottos.add(new Lotto(List.of(3, 4, 6, 7, 9, 10)));

        LotteryTickets lotteryTickets = new LotteryTickets(0);
        lotteryTickets.setLottoTickets(lottos);

        WinningNumber winningNumber = new WinningNumber(List.of(3, 4, 5, 7, 9, 30));
        winningNumber.setBonusNum(8);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoRanks(lotteryTickets, winningNumber);

        assertThat(String.format("%.1f", lottoResult.calcEarnedRatio(3000) * 100)).isEqualTo("1833.3");
    }

    @DisplayName("수익률 계산 테스트2")
    @Test
    void getEarnedRatio2() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 11)));
        LotteryTickets lotteryTickets = new LotteryTickets(0);
        lotteryTickets.setLottoTickets(lottos);

        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.setBonusNum(7);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoRanks(lotteryTickets, winningNumber);

        assertThat(String.format("%.1f", lottoResult.calcEarnedRatio(3000) * 100)).isEqualTo("67716666.7");
    }

    @DisplayName("수익률 계산 테스트3")
    @Test
    void getEarnedRatio3() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        lottos.add(new Lotto(List.of(13, 14, 15, 16, 17, 18)));

        LotteryTickets lotteryTickets = new LotteryTickets(0);
        lotteryTickets.setLottoTickets(lottos);

        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 7, 8, 9));
        winningNumber.setBonusNum(33);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoRanks(lotteryTickets, winningNumber);

        assertThat(String.format("%.1f", lottoResult.calcEarnedRatio(6000) * 100)).isEqualTo("166.7");
    }

}
