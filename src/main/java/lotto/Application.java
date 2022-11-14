package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.Lotto;
import lotto.utils.Parser;
import lotto.view.printResult;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printResult pR = new printResult();
        Parser parser = new Parser();
        pR.printStart();
        String inputMoney = readLine();
        int Lottolist = parser.purchaseNum(inputMoney);
        pR.printList(Lottolist);
        for(int i = 0; i<Lottolist; i++) {
            List<Integer> numbers = new ArrayList<>();
            Lotto lotto = new Lotto(numbers);
        }

    }
}
