package lotto.controller;

import lotto.model.User;

public class LottoController {
    private LottoPurchase lottoPurchase = new LottoPurchase();
    private LottoCompare lottoCompare = new LottoCompare();
    private User user;

    public void controlLotto(){
        try{
            user = lottoPurchase.controlLottoPurchase();
            lottoCompare.winningNumberCompareControl(user);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
