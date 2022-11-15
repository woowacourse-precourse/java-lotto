package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoGameView;

public class LottoGameController {
    LottoGameView lottoGameView = new LottoGameView();
    Buyer buyer = new Buyer();
    LottoGenerator lottoGenerator = new LottoGenerator();
    RaffleNumber raffleNumber;
    Discriminator discriminator = new Discriminator();
    Revenue revenue = new Revenue();

    public void calculateTickets() {
        lottoGameView.askPurchaseAmount();
        buyer.buyTickets(lottoGameView.getPurchaseAmount());
    }

    public void noticeNumberOfTickets() {
        lottoGameView.noticeNumberOfTickets(buyer.getTickets());
    }

    public void createLotteries() {
        lottoGenerator.generateLottoOfBuyer(buyer.getTickets());
    }

    public void noticeLotteries() {
        lottoGameView.noticeLotteries(lottoGenerator.toString());
    }

    public void checkLotteryWin() {
        lottoGameView.askRaffleNumbers();
        lottoGameView.askBonusNumber();
        raffleNumber=new RaffleNumber(lottoGameView.getRaffleNumbers(), lottoGameView.getBonusNumber());

        discriminator.initialize(raffleNumber);
        discriminator.discriminate(lottoGenerator.getLottoOfBuyer());
    }

    public void produceWinStatics() {
        revenue.makeStatics(discriminator.getMatches());
    }

    public void noticeWinReport() {
        lottoGameView.noticeReport(revenue.getRevenueStaticsReport());
    }

    public void calculateRateOfRevenue() {
        revenue.calculateRateOfRevenue(buyer.getPurchaseAmount());
    }

    public void noticeRateOfRevenue() {
        lottoGameView.noticeRateOfRevenue(revenue.getRateOfRevenue());
    }

    public void start() {
        try {
            calculateTickets();
            noticeNumberOfTickets();
            createLotteries();
            noticeLotteries();
            checkLotteryWin();
            produceWinStatics();
            noticeWinReport();
            calculateRateOfRevenue();
            noticeRateOfRevenue();

        }catch (IllegalArgumentException e){
            System.out.println("프로그램을 종료합니다.");
        }
    }

}
