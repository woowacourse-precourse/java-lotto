package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoGenerator;
import lotto.validation.Validation;

import java.util.List;

public class InputView {

    private static final int LOTTO_PRICE = 1000;
    public int inputUserMoney(){
        String userInput = Console.readLine();
        return Validation.userInputMoneyCheck(userInput);
    }

    public List<Integer> getWinNumber() {
        String userInput = Console.readLine();
        return Validation.winNumberCheck(userInput);
    }
    public int inputBonusNumber(List<Integer> winNumber) {
        String userInput = Console.readLine();
        return Validation.bonusNumberCheck(winNumber,userInput);
    }

    public static List<List<Integer>> getLottoNumbers(int number){
        int count = number/ LOTTO_PRICE;
        return LottoGenerator.lottoGeterator(count);
    }



}
