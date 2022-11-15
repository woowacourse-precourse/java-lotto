package lotto;

import lotto.domain.Money;
import lotto.domain.InputNumber;
import lotto.domain.RandomNumber;
import lotto.view.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.domain.Money.numberOfLottos;
import static lotto.domain.InputNumber.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 구입금액
        Print.requestMoneyMessage();
        Money.getMoney();
        Print.howmanyLottos(numberOfLottos);

        // 구매 장수만큼 로또 번호 출력
        Compare.randomLottos = new HashMap<>();
        Compare.userList = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> createdRandomNumbers = RandomNumber.create();
            Lotto lotto = new Lotto(createdRandomNumbers);
            List<Integer> getRandomNumbers = lotto.getNumbers();
            Compare.randomLottos.put(i,getRandomNumbers);
            Print.getLottos(getRandomNumbers);
        }

        Print.requestWinNumbers();
        List<Integer> correctNumbers = InputNumber.getWinNumbers();
        for (int i = 0; i < correctNumbers.size(); i++) {
            Compare.userList.add(correctNumbers.get(i));
        }
        Print.winNumbers();
        Print.requestBonusNumber();
        InputNumber.getBonusNumber();
        Compare.bonusNumber = bonusNumber;
        Print.bonusNumber();

        Compare.numbers();
        Compare.getResult();

        FinalResult.printFinalResult();


    }
}
