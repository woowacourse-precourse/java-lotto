package lotto;

import lotto.Enums.ErrorMessage;

import java.util.ArrayList;

public class Buyer {

    private final int purchase;
    private int reward;

    private ArrayList<Lotto> purchasedLotto;
    private ArrayList<Integer> results;

    public Buyer(int purchase){
        validate(purchase);
        this.purchase = purchase;
        //TODO: 다른 인스턴스들도 초기화 예정
    }

    private void validate(int purchase){
        if(purchase%1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_MOD.getMessage());
        }
    }

    public void getResult(){

    }

    private int compare(){
        return 0;
    }

    private int countMatchingNum(){
        return 0;
    }

    private void calReward(){
        this.reward = 0;
    }

}
