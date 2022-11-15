package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Buyer;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class LottoGameView{


    private String purchaseAmount;
    private String raffleNumbers;
    private String bonusNumber;

    public void askPurchaseAmount(){

    }

    public void askRaffleNumbers(){

    }

    public void askBonusNumber(){

    }

    public void noticeNumberOfTickets(int numberOfTickets){

    }

    public void noticeRateOfRevenue(float rateOfRevenue){

    }

    public void noticeLotteries(String lottoNumbers){

    }
    public void noticeReport(String winReport){

    }

    public String getPurchaseAmount(){
        return purchaseAmount;
    }

    public String getRaffleNumbers(){
        return raffleNumbers;
    }

    public String getBonusNumber(){
        return bonusNumber;
    }
}
