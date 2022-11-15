package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        Controller controller = new Controller();

        int money = 0;
        try {
            money = console.inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return;
        }

        int count = controller.getCount(money);
        List<Integer>[] issuedList = controller.issueLotto(count);
        console.outputIssuedLotto(count,issuedList);

        List<Integer> numbers = console.inputWinningNumber();
        Lotto winningLotto = controller.issueWinningNumber(numbers);
        int plusNumber = console.inputPlusNumber();
        winningLotto.checkPlusNumber(plusNumber);

        List<Integer>[] resultList = winningLotto.getResult(issuedList, plusNumber);
        HashMap<Rank,Integer> rankMap = controller.getRankMap(resultList);
        double yield = controller.getYield(money,rankMap);
        console.outputResult(rankMap, yield);


    }
}
