package lotto.Domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Utils.LottoInspector;
import lotto.Utils.Printer;

import java.util.ArrayList;
import java.util.List;

import static lotto.Enum.LottoProperty.LOTTO_NUMBER_LENGTH;
import static lotto.Enum.LottoProperty.MAX_LOTTO_NUMBER;
import static lotto.Enum.LottoProperty.MIN_LOTTO_NUMBER;
import static lotto.Enum.LottoProperty.ONE_LOTTO_COST;

public class LottoShop {
    public static LottoInspector inspection = new LottoInspector();
    public static Printer print = new Printer();

    public static int money;
    public static List<List<Integer>> soldLottoList = new ArrayList<>();
    public static List<Integer> winningNumbers;
    public int bonusNumber;

    public void purchase() {
        print.inputMoney();
        String inputMoney = Console.readLine();

        this.money = inspection.moneyToInt(inputMoney);

        sell();
    }

    private void sell() {
        int purchaseAmount = money / ONE_LOTTO_COST.getValue();
        int start = MIN_LOTTO_NUMBER.getValue();
        int end = MAX_LOTTO_NUMBER.getValue();
        int count = LOTTO_NUMBER_LENGTH.getValue();

        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> randomLotto = Randoms.pickUniqueNumbersInRange(start, end, count);
            new Lotto(randomLotto);
        }

        print.lottoCount(purchaseAmount);
        print.everySoldLottoList(soldLottoList);
        result();
    }

    private void result() {
        setWinningNumbers();
        setBonusNumber();

        print.statistic();
    }

    private void setWinningNumbers() {
        print.inputWinningNumbers();
        String inputWinningNumbers = Console.readLine();

        winningNumbers = inspection.winningNumberToList(inputWinningNumbers);
    }

    private void setBonusNumber() {
        print.inputBonusNumber();
        String inputBonusNumber = Console.readLine();

        bonusNumber = inspection.bonusNumberToInt(inputBonusNumber);
    }
}
