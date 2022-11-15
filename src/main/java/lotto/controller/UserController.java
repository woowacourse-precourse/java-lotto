package lotto.controller;

import static lotto.controller.ExceptionHandler.validPurchaseForm;
import static lotto.controller.HostController.winOrNot;
import static lotto.model.Prize.prizeOfHit;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.User;
import lotto.view.UserUI;

public class UserController {
    private static final Integer price = 1000;

    private static User model;
    private final static UserUI view = new UserUI();

    public void purchaseLottery(LottoController lottoCtrl){
        String purchase = view.getPurchaseMoney();

        validPurchaseForm(purchase);

        howMuch(Integer.parseInt(purchase), lottoCtrl);

        view.printLotteries(getLotteryNumbers());
    }

    public void howMuch(int purchase, LottoController lottoCtrl){
        int loop = purchase / price;
        List<Lotto> lotteries = new ArrayList<Lotto>();

        for(int i=0;i<loop;i++){
            lottoCtrl.makeLottery();
            lotteries.add(lottoCtrl.getLottery());
        }

        model = new User(lotteries);
    }

    public List<List<Integer>> getLotteryNumbers(){
        List<List<Integer>> lotteries = new ArrayList<>();
        for(Lotto lottery : model.getLotteries()){
            lotteries.add(lottery.numbers());
        }

        return lotteries;
    }

    public void updateWinningHistory(){
        List<List<Integer>> lotteries = getLotteryNumbers();

        for(List<Integer> lottery: lotteries){
            double hit = winOrNot(lottery);

            if(hit >= 3.0){
                Prize prize = prizeOfHit(hit);
                int prev = model.getTimesOf(prize);
                model.setWinningHistory(prize, prev+1);
                System.out.println(model.getWinningHistory());
            }
        }
    }

    public int calWinningPrize(){
        int winningPrize = 0;
        for(Prize prize: Prize.values()){
            winningPrize += model.getTimesOf(prize) * prize.MONEY();
        }
        return winningPrize;
    }

    public double calEarningsRate(){
        int winningPrize = calWinningPrize();
        double earning = (double)winningPrize / model.purchase() * 100;
        return Math.round(earning*10)/10.0;
    }

    public void lotteryOfWinners(List<String> messages){

        double earningRate = calEarningsRate();

        view.printWinningResult(messages, model.getAllOfTimes(), earningRate);

    }
}
