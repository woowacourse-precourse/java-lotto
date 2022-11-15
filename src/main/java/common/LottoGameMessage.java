package common;

import domain.Lotto;
import domain.LottoRank;
import domain.Player;
import lottoService.LottoService;


import java.util.*;

import static common.Constant.*;

public class LottoGameMessage {

    private static final LottoService lottoService = new LottoService();

    public static void WINNING_LOTTO_THREE_MESSAGE(int winningLottoThreeCount) {
        System.out.println("3개 일치 (5,000원) - " + winningLottoThreeCount + "개");
    }

    ;

    public static void WINNING_LOTTO_FOUR_MESSAGE(int winningLottoFourCount) {
        System.out.println("4개 일치 (50,000원) - " + winningLottoFourCount + "개");
    }

    ;

    public static void WINNING_LOTTO_FIVE_MESSAGE(int winningLottoFiveCount) {
        System.out.println("5개 일치 (1,500,000원) - " + winningLottoFiveCount + "개");
    }

    ;

    public static void WINNING_LOTTO_FIVE_BONUS_MESSAGE(int winningLottoFiveAndBonusCount) {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningLottoFiveAndBonusCount + "개");
    }

    ;

    public static void WINNING_LOTTO_SIX_MESSAGE(int winningLottoSixCount) {
        System.out.println("6개 일치 (2,000,000,000원) - " + winningLottoSixCount + "개");
    }

    ;

    public static void PLAYER_YIELD_MESSAGE(String yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    public void printPurchasePriceMessage() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
    }

    public void printPurchaseCountMessage(int lottoCount) {
        System.out.println(lottoCount + PURCHASE_COUNT_MESSAGE);
    }

    public void printWinningNumberMessage() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printPlayerRandomLottoPickNumbers(Player player) {
        Iterator<Lotto> playerLottoNumbers = player.getPlayerLottoPickNumbers().iterator();

        while (playerLottoNumbers.hasNext()) {
            Lotto playerRandomLottoNumbers = playerLottoNumbers.next();
            lottoService.printSortedPlayerLottoNumbers(playerRandomLottoNumbers.getNumbers());
        }
    }


    public void printLottoWinningStatistics(Player player) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(UNDER_SCORE_MESSAGE);
        WINNING_LOTTO_THREE_MESSAGE(player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_3, 0));
        WINNING_LOTTO_FOUR_MESSAGE(player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_4, 0));
        WINNING_LOTTO_FIVE_MESSAGE(player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_5, 0));
        WINNING_LOTTO_FIVE_BONUS_MESSAGE(player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_5_BONUS, 0));
        WINNING_LOTTO_SIX_MESSAGE(player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_6, 0));
    }

    public void printPlayerLottoYield(Player player) {
        PLAYER_YIELD_MESSAGE(lottoService.calculatePlayerYield(player));
    }
}
