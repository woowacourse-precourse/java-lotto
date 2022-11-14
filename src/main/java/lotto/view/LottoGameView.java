package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Buyer;

public class LottoGameView{
    private String purchaseAmount;
    private String raffleNumbers;
    private String bonusNumber;
    public void askPurchaseAmount(){
        purchaseAmount = Console.readLine();
    }

    public void askRaffleNumbers(){
        raffleNumbers= Console.readLine();
    }
    public void askBonusNumber(){
        bonusNumber=Console.readLine();
    }
}
