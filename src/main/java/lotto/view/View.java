package lotto.view;

import lotto.message.PrintResult;
import lotto.message.PrintInput;

import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class View {

    // 로또 번호 비교한 모든 결과를 출력하는 메서드
    public void printResult (HashMap<Integer, Integer> prizeRankings, double totalProfit) {

        for (int ranking: prizeRankings.keySet()) {
            int index = 6 - ranking;

            PrintResult.values()[ranking-1].printResult(prizeRankings.get(index));
        }
        PrintResult.RESULT_INCOME.printIncome(totalProfit*100);
    }

    // 생성된 로또 번호를 출력하는 메서드
    public void printUncheckedLotto (List<List<Integer>> usersLottos) {
        System.out.printf("%d" + PrintInput.INPUT_NUMBER.printInput() + "\n", usersLottos.size());

        for (List<Integer> lotto: usersLottos) {
            System.out.println(lotto);
        }
    }

    // 보너스 번호를 입력하는 메서드
    public String inputBonusNumber () {
        PrintInput.INPUT_BONUS.print();

        return Console.readLine();
    }

    // 돈을 입력하는 메서드
    public String inputMoney () {
        PrintInput.INPUT_MONEY.print();

        return Console.readLine();
    }

    // 로또 번호를 입력하는 메서드
    public  String inputLottoNumber () {
        PrintInput.INPUT_LOTTO.print();

        return Console.readLine();
    }
}
