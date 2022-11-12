package common;

import domain.Lotto;
import domain.LottoRank;
import domain.Player;
import java.util.Iterator;

import static common.Constant.*;

public class LottoGameMessage {

    public void printPurchasePriceMessage(){
        System.out.println(PURCHASE_PRICE_MESSAGE);
    }

    public void printPurchaseCountMessage(int lottoCount){
        System.out.println(lottoCount + PURCHASE_COUNT_MESSAGE);
    }

    public void printWinningNumberMessage(){
        System.out.println(WINNING_NUMBER_MESSAGE);
    }
    public void printBonusNumberMessage(){
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printPlayerRandomLottoPickNumbers(Player player){
        Iterator<Lotto> playerLottoNumbers = player.getPlayerLottoPickNumbers().iterator();

        while(playerLottoNumbers.hasNext()){
            Lotto playerRandomLottoNumbers = playerLottoNumbers.next();
            System.out.println(playerRandomLottoNumbers.getNumbers());
        }
    }
    public void printLottoWinningStatistics(Player player){
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(UNDER_SCORE_MESSAGE);
        System.out.println(WINNING_LOTTO_THREE_MESSAGE + player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_3,0));
        System.out.println(WINNING_LOTTO_FOUR_MESSAGE + player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_4,0));
        System.out.println(WINNING_LOTTO_FIVE_MESSAGE + player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_5,0));
        System.out.println(WINNING_LOTTO_FIVE_BONUS_MESSAGE + player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_5_BONUS,0));
        System.out.println(WINNING_LOTTO_SIX_MESSAGE + player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_6,0));
    }
}
