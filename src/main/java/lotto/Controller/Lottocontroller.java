package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.Money;
import lotto.domain.Paper;
import lotto.domain.Lottos;
import lotto.domain.Lucky;
import lotto.domain.Bonusnumber;
import lotto.domain.Score;
import lotto.domain.Earning;

public class Lottocontroller {
    //static final

    //instance value
    public void run(){
        Money money = inputMoney();

        Paper paper = convertMoney(money);

        Lottos lottos = new_Lottos(paper.Get_Paper());

        Lucky lucky = new_Lucky();
        Bonusnumber bonusnumber = new_Bonus();

        Score score = new_score();
        Rating_start(score, paper, lottos, lucky, bonusnumber);

        Earning earning = new_earning(score);
        earning.Set_percent(money.Get_money());
    }

    private Money inputMoney(){
        return new Money(Console.readLine());
    }

    private Paper convertMoney(Money money){
        return new Paper(money.Get_money());
    }

    private Lottos new_Lottos(int paper){
        return new Lottos(paper);
    }

    private Lucky new_Lucky(){
        return new Lucky(Console.readLine());
    }

    private Bonusnumber new_Bonus(){
        return new Bonusnumber(Console.readLine());
    }

    private Score new_score(){
        return new Score();
    }

    private void Rating_start(Score score, Paper paper,Lottos lottos,Lucky lucky,Bonusnumber bonusnumber){
        score.Rating_start(paper, lottos, lucky, bonusnumber);
    }

    private Earning new_earning(Score score){
        return new Earning(score);
    }
    //method
}
