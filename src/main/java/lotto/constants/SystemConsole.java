package lotto.constants;

import java.util.List;

public class SystemConsole {

    public void GAME_START_MESSAGE() {
        System.out.println(SystemMessage.PURCHASE_AMOUNT_MESSAGE);
    }

    public void COMPLETED_PURCHASE(int lottos) {
        System.out.println();
        System.out.println(lottos + SystemMessage.BUY_LOTTO_MESSAGE);
    }

    public void WINNING_NUMBERS() {
        System.out.println();
        System.out.println(SystemMessage.PRIZE_AMOUNT_MESSAGE);
    }

    public void BONUS_NUMBER() {
        System.out.println();
        System.out.println(SystemMessage.BONUS_NUMBER_MESSAGE);
    }

    public void WINNING_STATISTICS() {
        System.out.println();
        System.out.println(SystemMessage.WINNING_STATISTICS_MESSAGE);
        System.out.println(SystemMessage.LINE_MESSAGE);
    }

    public void WINNING_RANKING_FIFTH(List<Integer> winningRanking, int i) {
        System.out.println(Rank.FIFTH.getMatch() + SystemMessage.THIRD_CORRECT_RANK_MESSAGE + winningRanking.get(i) + SystemMessage.UNIT_MESSAGE);
    }

    public void WINNING_RANKING_FOURTH(List<Integer> winningRanking, int i) {
        System.out.println(Rank.FOURTH.getMatch() + SystemMessage.FOURTH_CORRECT_RANK_MESSAGE + winningRanking.get(i) + SystemMessage.UNIT_MESSAGE);
    }

    public void WINNING_RANKING_THIRD(List<Integer> winningRanking, int i) {
        System.out.println(Rank.THIRD.getMatch() + SystemMessage.FIFTH_CORRECT_RANK_MESSAGE + winningRanking.get(i) + SystemMessage.UNIT_MESSAGE);
    }

    public void WINNING_RANKING_SECOND(List<Integer> winningRanking, int i) {
        System.out.println(Rank.SECOND.getMatch() + SystemMessage.SECOND_CORRECT_RANK_MESSAGE + winningRanking.get(i) + SystemMessage.UNIT_MESSAGE);
    }

    public void WINNING_RANKING_FIRST(List<Integer> winningRanking, int i) {
        System.out.println(Rank.FIRST.getMatch() + SystemMessage.FIRST_CORRECT_RANK_MESSAGE + winningRanking.get(i) + SystemMessage.UNIT_MESSAGE);
    }

    public void GROSS_YIELDS(double revenue) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", revenue));
    }

}