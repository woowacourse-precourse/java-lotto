package lotto.Domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Utils.LottoInspection;

import java.util.ArrayList;
import java.util.List;

import static lotto.Enum.InformationMessage.*;
import static lotto.Enum.LottoProperty.*;

public class LottoShop {
    public static LottoInspection inspection = new LottoInspection();
    public static Statistic statistic = new Statistic();

    public static int money;
    public static List<List<Integer>> soldLottoList = new ArrayList<>();
    public List<Integer> winningNumbers;
    public int bonusNumber;

    public void purchase() {
        System.out.println(INPUT_AMOUNT_OF_MONEY_TO_BUY.getMessage());
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

        result();
    }

    private void result() {
        setWinningNumbers();
        setBonusNumber();

        statistic.ShowStatistic();
    }

    private void setWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        String inputWinningNumbers = Console.readLine();

        winningNumbers = inspection.winningNumberToList(inputWinningNumbers, ",");
    }

    private void setBonusNumber() {
        System.out.println(INPUT_BONUS_WINNING_NUMBER.getMessage());
        String inputBonusNumber = Console.readLine();

        bonusNumber = inspection.inputNumberToInt(inputBonusNumber);
    }
}
