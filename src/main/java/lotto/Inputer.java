package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.ExceptionChecker.BonusNumberChecker;
import lotto.ExceptionChecker.IntegerChecker;
import lotto.ExceptionChecker.Lotto;
import lotto.ExceptionChecker.MoneyInputChecker;

public class Inputer {

    private static final String REGEX = ",";

    private List<Integer> LOTTO_LIST;


    public int inputMoney() {

        String userInputMoneyString = readLine();
        IntegerChecker integerChecker = new IntegerChecker(userInputMoneyString);
        MoneyInputChecker moneyInputChecker = new MoneyInputChecker(integerChecker.getMoney());

        return moneyInputChecker.getMoney();
    }

    public List<Integer> createLottoWinNumber() {

        String lottoWinNumber = readLine();

        Lotto lotto = new Lotto(makeStringToList(lottoWinNumber));
        List<Integer> lottoWinNumberList = lotto.getLotto();

        this.LOTTO_LIST = lottoWinNumberList;

        return lottoWinNumberList;
    }

    public int inputLottoBonusNumber() {
        String bonusNumber = readLine();

        IntegerChecker integerChecker = new IntegerChecker(bonusNumber);
        BonusNumberChecker bonusNumberChecker = new BonusNumberChecker(integerChecker.getMoney(), LOTTO_LIST);

        return bonusNumberChecker.getBonusNumber();
    }


    public List<Integer> makeStringToList(String lottoWinNumber) {

        String[] lottoWinArray = lottoWinNumber.split(REGEX);

        List<Integer> lottoWinList = new ArrayList<>();

        for (int i = 0; i < lottoWinArray.length; i++) {
            IntegerChecker integerChecker = new IntegerChecker(lottoWinArray[i]);
            lottoWinList.add(integerChecker.getMoney());
        }

        return lottoWinList;
    }
}
