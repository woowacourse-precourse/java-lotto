package lotto.controller;

import lotto.model.User;

public class LottoController {
    private LottoPurchase lottoPurchase = new LottoPurchase();
    private WinningNumberCompare winningNumberCompare = new WinningNumberCompare();
    private User user;

    public void controlLotto(){
        try{
            user = lottoPurchase.controlLottoPurchase();
            winningNumberCompare.winningNumberCompareControl(user);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
