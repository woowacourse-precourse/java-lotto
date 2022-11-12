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
}
