package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.Money;
import lotto.domain.Paper;
import lotto.domain.Lotto;
import lotto.domain.Numbers;
public class Lottocontroller {
    //static final

    //instance value
    public void run(){
        Money money = inputMoney();

        Paper paper = convertMoney(money);
        Numbers numbers = new_numbers();
        Lotto lotto = new_lotto(numbers);
    }

    private Money inputMoney(){
        return new Money(Console.readLine());
    }

    private Paper convertMoney(Money money){
        return new Paper(money.Get_money());
    }

    private Numbers new_numbers(){
        return new Numbers();
    }

    private Lotto new_lotto(Numbers numbers){
        return new Lotto(numbers.Get_Numbers());
    }
    //method
}
