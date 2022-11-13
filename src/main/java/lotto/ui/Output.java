package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    // 구입 금액
    public void moneyInform(){
        System.out.println(Phrases.MONEY);
    }
    // 구입 수량
    public void amount(String amount){
        System.out.println(amount + Phrases.BUY_AMOUNT);
    }

    public void lottoHistory(List<Lotto> history){
        for(Lotto numbers : history){
            System.out.println(numbers.getNumbers());
        }
    }
    public void winningNum(){
        System.out.println(Phrases.WINNING_NUMBER);
    }
    public void bonusNum(){
        System.out.println(Phrases.BONUS_NUMBER);
    }


    public void winningStatistic(){
        //enum 예정
    }

    //수익률을 출력한다
    public void revenue(){
    }
}