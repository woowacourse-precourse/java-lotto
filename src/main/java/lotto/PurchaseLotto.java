package lotto;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import ui.PurchasePrint;
import exceptioncase.PurchaseException;
public class PurchaseLotto {
    public static int inputPurchaseMeony(){
        PurchasePrint.intputMoney();
        String money = Console.readLine();
        PurchaseException.inputMoneyException(money);
        return Integer.valueOf(money)/1000;
    }
    public static List<List<Integer>> drawLotto(){
        List<List<Integer>> answer = Collections.emptyList();
        return answer;
    }
}
