package lotto.controller;

import lotto.model.*;
import lotto.view.LottoGameView;

public class LottoGameController {
    LottoGameView lottoGameView = new LottoGameView();
    Buyer buyer=new Buyer();
    LottoGenerator lottoGenerator = new LottoGenerator();
    RaffleNumber raffleNumber = new RaffleNumber();
    Discriminator discriminator = new Discriminator();
    Revenue revenue = new Revenue();

    public void calculateTickets(){
        lottoGameView.askPurchaseAmount();
        buyer.buyTickets(lottoGameView.getPurchaseAmount());
    }

    public void noticeNumberOfTickets(){

    }
    public void createLotteries(){

    }
    public void noticeLotteries(){

    }
    public void checkLotteryWin(){

    }
    public void figureOutWinStatics(){

    }
    public void noticeWinReport(){

    }
    public void calculateRateOfRevenue(){

    }
    public void noticeRateOfRevenue(){

    }
    public void start(){

        calculateTickets();
        noticeNumberOfTickets();
        createLotteries();
        noticeLotteries();
        checkLotteryWin();
        figureOutWinStatics();
        noticeWinReport();
        calculateRateOfRevenue();
        noticeRateOfRevenue();

    }

}
