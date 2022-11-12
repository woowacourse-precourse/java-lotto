package lotto.ui;

import java.util.List;

public class Output {
    // 구입 금액
    public void money(){
        System.out.println(Phrases.MONEY);
    }
    // 구입 수량
    public void buyAmout(String amount){
        System.out.println(amount + Phrases.BUY_AMOUNT);
    }

    public void buyHistory(List<List<Integer>> history){
        for(List<Integer>numbers : history){
            System.out.println(numbers);
        }
    }
    public void winningNum(){
        System.out.println(Phrases.WINNING_NUMBER);
    }
    public void bonusNum(){
        System.out.println(Phrases.BONUS_NUMBER);
    }


    public void winningHistory(){
    }

    //수익률을 출력한다
    public void revenue(){
    }
}