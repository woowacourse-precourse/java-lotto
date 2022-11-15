package view;

import model.*;

import java.text.DecimalFormat;
import java.util.List;

public class UserOutput {

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + ConstantMessage.BUYING_LOTTO_MESSAGE.getConstant());
    }

    public void printRandomLottoList(List<List<Integer>> randomLottos) {
        for (int i = 0; i < randomLottos.size(); i++) {
            System.out.println(randomLottos.get(i));
        }
    }

    public void printWinningStats() {
        System.out.println(ConstantMessage.WINNING_STATS_MESSAGE.getConstant());
        System.out.println(setWinningStats());
        printProfitMoney();
    }

    public StringBuffer setWinningStats() {
        StringBuffer sb = new StringBuffer();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NOTHING && rank != LottoRank.SECOND) {
                sb.append(rank.getSameNumberCount() + ConstantMessage.NUMBER_MATCH_FORMAT_MESSAGE.getConstant() + decimalFormat.format(rank.getLottoReward()) + ConstantMessage.MONEY_FORMAT_MESSAGE.getConstant() + LottoResultBoard.getLottoResultBoard().get(rank) + ConstantMessage.NUMBER_FORMAT_MESSAGE.getConstant());
                sb.append("\n");
            }
            if (rank == LottoRank.SECOND) {
                sb.append(rank.getSameNumberCount() + ConstantMessage.NUMBER_BONUS_MATCH_FORMAT_MESSAGE.getConstant() + decimalFormat.format(rank.getLottoReward()) + ConstantMessage.MONEY_FORMAT_MESSAGE.getConstant() + LottoResultBoard.getLottoResultBoard().get(rank) + ConstantMessage.NUMBER_FORMAT_MESSAGE.getConstant());
                sb.append("\n");
            }
        }
        return sb;
    }

    public void printProfitMoney() {
        System.out.println(ConstantMessage.PROFIT_RATE_MESSAGE.getConstant()
                + LottoCalculator.calculateProfitRate(Money.getResultMoney(), LottoResultBoard.getProfitMoney())
                + ConstantMessage.PERCENT_MESSAGE.getConstant());
    }
}

