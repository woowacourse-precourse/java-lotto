package controller;

import java.util.ArrayList;
import java.util.List;
import model.Lotto;
import model.User;
import view.UserUI;

public class UserController {
    private User   model;
    private UserUI view;

    public void purchaseLottery(){
        String purchase = view.getPurchaseMoney();
        ExceptionHandler.validPurchaseForm(purchase);

        howMuch(Integer.parseInt(purchase));
    }

    public void howMuch(int purchase){
        int loop = purchase / 1000;
        List<Lotto> lotteries = new ArrayList<>();

        for(int i=0;i<loop;i++){
            LottoController.makeLottery();
            lotteries.add(LottoController.getLottery());
        }

        model = new User(lotteries);
    }

    public List<List<Integer>> convertLotteries(){
        List<List<Integer>> lotteries = new ArrayList<>();
        for(Lotto lottery : model.getLotteries()){
            lotteries.add(lottery.numbers());
        }

        return lotteries;
    }
}
