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
        lottoGameView.noticeNumberOfTickets(buyer.getTickets());
    }
    public void createLotteries(){
        lottoGenerator.generateLottoOfBuyer(buyer.getTickets());
    }
    public void noticeLotteries(){
        lottoGameView.noticeLotteries(lottoGenerator.toString());
    }
    public void checkLotteryWin(){
        lottoGameView.askRaffleNumbers();
        lottoGameView.askBonusNumber();

        raffleNumber.create(lottoGameView.getRaffleNumbers(), lottoGameView.getBonusNumber());

        discriminator.initialize(raffleNumber);
        discriminator.discriminate(lottoGenerator.getLottoOfBuyer());
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
