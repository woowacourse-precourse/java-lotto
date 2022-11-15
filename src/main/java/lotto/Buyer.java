package lotto;

import java.util.ArrayList;

public class Buyer {

    private final int purchase;
    private int reward;

    private ArrayList<Lotto> purchasedLotto;
    private ArrayList<Integer> results;

    public Buyer(int purchase){

        this.purchase = purchase;
        //TODO: 다른 인스턴스들도 초기화 예정
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
