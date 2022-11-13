package lotto.ui;

import lotto.domain.Lotto;
import lotto.service.CoincideNumber;

import java.util.List;

public class Output {
    private enum Phrases {
        MONEY("구입금액을 입력해 주세요."),
        AMOUNT("개를 구매했습니다."),
        WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요."),
        WINSTATISTICS("당첨 통계\n---"),
        NUMBER("개"),
        REVENUE("총 수익률은 %.1f% 입니다");

        private String msg;
        Phrases(String msg) {
            this.msg = msg;
        }
    }

    // 구입 금액
    public void moneyInform(){
        System.out.println(Phrases.MONEY.msg);
    }
    // 구입 수량
    public void amount(String amount){
        System.out.println(amount + Phrases.AMOUNT.msg);
    }

    public void lottoHistory(List<Lotto> history){
        for(Lotto numbers : history){
            System.out.println(numbers.getNumbers());
        }
    }
    public void winningNum(){
        System.out.println(Phrases.WINNING_NUMBER.msg);
    }
    public void bonusNum(){
        System.out.println(Phrases.BONUS_NUMBER.msg);
    }


    public void winStatistics(){
        for (CoincideNumber coincideNumber : CoincideNumber.values()){
            System.out.println(coincideNumber.phrase() + coincideNumber.count() + Phrases.NUMBER.msg);
        }
    }

    //수익률을 출력한다
    public void revenue(double revenue){
        System.out.println(String.format(Phrases.REVENUE.msg,revenue));
    }
}