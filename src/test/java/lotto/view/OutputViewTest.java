package lotto.view;

import lotto.LottoWinningRank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    OutputView outputView = new OutputView();

    @BeforeEach
    public void setUpStreamsAndInit() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 로또_구매_개수_출력() {
        String purchaseLottoCountMessage = "8개를 구매했습니다.\n";
        outputView.printPurchaseLottoCount(8);

        assertThat(output.toString()).isEqualTo(purchaseLottoCountMessage);
    }

    @Test
    void 로또_발행_번호_출력() {
        List<Integer> issuedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        outputView.printIssuedLottoNumbers(issuedLottoNumbers);
        String purchaseLottoCountMessage = "[1, 2, 3, 4, 5, 6]\n";

        assertThat(output.toString()).isEqualTo(purchaseLottoCountMessage);
    }

    @Test
    void 로또_당첨_내역_출력() {
        Map<LottoWinningRank, Integer> lottoWinningRankMap = new HashMap<>();
        lottoWinningRankMap.put(LottoWinningRank.FIRST, 0);
        lottoWinningRankMap.put(LottoWinningRank.SECOND, 0);
        lottoWinningRankMap.put(LottoWinningRank.THIRD, 0);
        lottoWinningRankMap.put(LottoWinningRank.FOURTH, 0);
        lottoWinningRankMap.put(LottoWinningRank.FIFTH, 1);
        outputView.printLottoWinningStatistics(lottoWinningRankMap);
        String lottoWinningStatisticsMessage = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n";

        assertThat(output.toString()).isEqualTo(lottoWinningStatisticsMessage);
    }

    @Test
    void 수익률_출력() {
        String earningsRatio = "62.5%";
        outputView.printEarningsRatio(earningsRatio);
        String earningsRatioMessage = "총 수익률은 62.5%입니다.\n";

        assertThat(output.toString()).isEqualTo(earningsRatioMessage);
    }
}