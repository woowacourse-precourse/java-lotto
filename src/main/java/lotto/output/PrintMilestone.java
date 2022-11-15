package lotto.output;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.input.CheckInput.checkMoney;
import static lotto.Lotto.checkString;

public class PrintMilestone {

    public static void printLotto(List<Integer> Lotto){
        System.out.println(Lotto);
    }
    public static int buyLotto(){
        System.out.println(View.InputMessage.MONEY_PAY.print());
        String Money = readLine();
        int numBuy = checkString(Money)/1000;
        checkMoney(Money);
        return numBuy;
    }
    public static void printBuy(int i){
        System.out.println("");
        System.out.println((i)+ View.InputMessage.BUY_NUM.print());
    }
}
