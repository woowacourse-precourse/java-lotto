package view;

import lotto.LottoCalculator;
import lotto.LottoRank;
import lotto.LottoResultBoard;
import lotto.Money;

import java.text.DecimalFormat;
import java.util.List;

public class UserOutput {
    private static final String BUYING_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATS_MESSAGE = "당첨 통계 :";

    public void printLottoCount(int lottoCount){
        System.out.println(lottoCount + BUYING_LOTTO_MESSAGE);
    }

    public void printRandomLottoList(List<List<Integer>> randomLottos){
        for(int i = 0; i < randomLottos.size(); i++){
            System.out.println(randomLottos.get(i));
        }
    }

    public void printWinningStats() {
        System.out.println(WINNING_STATS_MESSAGE);
        System.out.println(setWinningStats());
        printProfitMoney();
    }

    public StringBuffer setWinningStats(){
        StringBuffer sb = new StringBuffer();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        for (LottoRank rank : LottoRank.values()) {
            if(rank != LottoRank.NOTHING && rank != LottoRank.SECOND){
                sb.append(rank.getSameNumberCount() + "개 일치 (" + decimalFormat.format(rank.getLottoReward())+"원) - " + LottoResultBoard.getLottoResultBoard(rank) + "개");
                sb.append("\n");
            }
            if(rank == LottoRank.SECOND){
                sb.append(rank.getSameNumberCount() + "개 일치, 보너스 볼 일치 (" + decimalFormat.format(rank.getLottoReward()) +
                        "원) - " + LottoResultBoard.getLottoResultBoard(rank) + "개");
                sb.append("\n");
            }
        }
        return sb;
    }

    public void printProfitMoney(){
        System.out.println("총 수익률은 "
                +LottoCalculator.calculateProfitRate(Money.getResultMoney(),LottoResultBoard.getProfitMoney())
                +"%입니다.");
    }
}

