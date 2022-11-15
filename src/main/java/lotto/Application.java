package lotto;

import lotto.model.*;
import lotto.utils.Error;
import lotto.view.FinalResult;
import lotto.view.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.model.Money.numberOfLottos;
import static lotto.model.InputNumber.*;

public class Application {
    public static void main(String[] args) {
        //TODO: 프로그램 구현
        Print.requestMoneyMessage();
        try{
            Money.getMoney();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 숫자가 아닌 값을 포함하고 있습니다.");
            return;
        }
        Print.howmanyLottos(numberOfLottos);

        Compare.randomLottos = new HashMap<>();
        Compare.userList = new ArrayList<>();

        Lotto.getAllLottos();

        Print.requestWinNumbers();
        //InputNumber.getWinNumbers();

        List<Integer> correctNumbers = InputNumber.getWinNumbers();
        for (int i = 0; i < correctNumbers.size(); i++) {
            Compare.userList.add(correctNumbers.get(i));
        }
        Print.winNumbers();
        Print.requestBonusNumber();
        InputNumber.getBonusNumber();
        InputNumber.bonusNumber = bonusNumber;
        Print.bonusNumber();

        //TODO: 결과 비교
        Compare.numbers();
        BonusNumber.compare();
        Calculate.getResult();

        //TODO: 최종출력
        FinalResult.printFinalResult();
    }
}
