package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
public class Lottocontroller {
    //static final

    //instance value
    public void run(){
        Money money = inputMoney();

    }

    private Money inputMoney(){
        return new Money(Console.readLine());
    }
    //method
}
