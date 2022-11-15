package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        List<List<Integer>> userLottoNumbers = new ArrayList<>();
        Map<Integer,Integer> winStatistics = new HashMap<>();
        int buyMoney = UserInterface.inputMoney();
        UserInterface.printNumberOfLotto(userLottoNumbers,buyMoney);
        UserInterface.inputWinNumbers(numbers);
        int bonusNumber = UserInterface.inputBonusNumber(numbers);
        BuyLotto.howManyMatchNumbers(userLottoNumbers,numbers,bonusNumber,winStatistics);
        UserInterface.printWinStatics(winStatistics);
        UserInterface.printYield(buyMoney,winStatistics);
    }


}
