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
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Console.readLine();
    }

    public void askRaffleNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        raffleNumbers= Console.readLine();
    }

    public void askBonusNumber(){
        
    }

    public void noticeNumberOfTickets(int numberOfTickets){
        System.out.printf("%d개를 구매했습니다.\n",numberOfTickets);
    }

    public void noticeRateOfRevenue(float rateOfRevenue){

    }

    public void noticeLotteries(String lottoNumbers){
        System.out.println(lottoNumbers);
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
