package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.InputNumber;
import lotto.view.FinalResult;
import lotto.view.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.domain.Money.numberOfLottos;
import static lotto.domain.InputNumber.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO: 구입금액 입력
        Print.requestMoneyMessage();
        Money.getMoney();
        Print.howmanyLottos(numberOfLottos);

        Compare.randomLottos = new HashMap<>();
        Compare.userList = new ArrayList<>();

        // TODO: 구매 장수만큼 로또 번호 출력
        Lotto.getAllLottos();


        //TODO: 사용자로부터 당첨번호 입력받기
        Print.requestWinNumbers();

        List<Integer> correctNumbers = InputNumber.getWinNumbers();
        for (int i = 0; i < correctNumbers.size(); i++) {
            Compare.userList.add(correctNumbers.get(i));
        }

        Print.winNumbers();
        Print.requestBonusNumber();
        InputNumber.getBonusNumber();
        InputNumber.bonusNumber = bonusNumber;
        Print.bonusNumber();

        // 결과 비교
        Compare.numbers();
        BonusNumber.compare();
        Calculate.getResult();

        FinalResult.printFinalResult();


    }
}
