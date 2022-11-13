package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.Money;
import lotto.domain.Paper;
import lotto.domain.Lotto;
import lotto.domain.Numbers;
import lotto.domain.Lottos;
import lotto.domain.Lucky;
public class Lottocontroller {
    //static final

    //instance value
    public void run(){
        Money money = inputMoney();

        Paper paper = convertMoney(money);

        Lottos lottos = new_Lottos(paper.Get_Paper());

        Lucky lucky = new_Lucky();
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
    //method
}
