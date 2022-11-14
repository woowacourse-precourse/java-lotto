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
        MoneyInputChecker moneyInputChecker = new MoneyInputChecker(integerChecker.numberReturn());

        return moneyInputChecker.moneyReturn();
    }

    public List<Integer> createLottoWinNumber() {

        String lottoWin = readLine();

        Lotto lotto = new Lotto(lottoWinList(lottoWin));
        List<Integer> lottoWinNumberList = lotto.lottoReturn();

        this.LOTTO_LIST = lottoWinNumberList;

        return lottoWinNumberList;
    }

    public int inputLottoBonusNumber() {
        String bonusNumber = readLine();

        IntegerChecker integerChecker = new IntegerChecker(bonusNumber);
        BonusNumberChecker bonusNumberChecker = new BonusNumberChecker(integerChecker.numberReturn(), LOTTO_LIST);

        return bonusNumberChecker.bonusReturn();
    }


    public List<Integer> lottoWinList(String lottoWin) {

        String[] lottoWinArray = lottoWin.split(REGEX);

        List<Integer> lottoWinList = new ArrayList<>();

        for (int i = 0; i < lottoWinArray.length; i++) {
            IntegerChecker integerChecker = new IntegerChecker(lottoWinArray[i]);
            lottoWinList.add(integerChecker.numberReturn());
        }

        return lottoWinList;
    }
}
