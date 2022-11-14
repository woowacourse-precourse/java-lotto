package lotto.controller;

public class LottoController {
    public void controlLotto(){
        try{
            LottoPurchase lottoPurchase = new LottoPurchase();
            lottoPurchase.controlLottoPurchase();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
