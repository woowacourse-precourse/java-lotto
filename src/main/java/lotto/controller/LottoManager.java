package lotto.controller;

import lotto.model.Lotto;
import lotto.constant.LottoInfo;
import lotto.constant.RankInfo;
import lotto.view.OutputView;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;

    public enum Error {
        TYPE("[ERROR] 금액은 숫자로만 입력해 주세요."),
        REMAINDER("[ERROR] 금액은 1000으로 나누어 떨어져야 합니다.");

        private final String message;

        Error(String message) {
            this.message = message;
        }

        public void print() {
            System.out.println(this.message);
        }
    }

    public List<Integer> GenerateLottoNumbers() {
        LottoInfo.INPUT_WINNING_NUM_MESSAGE.printMessage();
        String inputLottoNumbers = Console.readLine();
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : inputLottoNumbers.split(",")) {
            lottoNumbers.add(Integer.valueOf(number));
        }
        return lottoNumbers;
    }

    public int GenerateBonusNumber() {
        LottoInfo.INPUT_BONUS_NUM_MESSAGE.printMessage();
        String inputBonusNumbers = Console.readLine();
        return Integer.parseInt(inputBonusNumbers);
    }

    public List<Integer> GenerateRandomNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public int getMoney() throws IllegalArgumentException {
        System.out.println(LottoInfo.INPUT_BUY_MESSAGE.message);
        String inputMoney = Console.readLine();

        for (int i = 0; i < inputMoney.length(); i++) {
            char charNum = inputMoney.charAt(i);

            // 숫자가 아닐 경우 예외
            if ((int) charNum < 48 || (int) charNum > 57) {
                Error.TYPE.print();
                throw new IllegalArgumentException();
            }
        }

        int money = Integer.parseInt(inputMoney);

        if (money % 1000 != 0) {
            Error.REMAINDER.print();
            throw new IllegalArgumentException();
        }

        return money;

    }

    public void sortLottoNumbers(List<Integer> lotto) {
        Collections.sort(lotto);
    }

    public int getNumberLottos(int money) {
        return (money / LOTTO_PRICE);
    }

    public void printPublishedLottos(int numberLottos) {
        OutputView.informNumberPurchases(numberLottos);
        System.out.println(LottoInfo.PURCHASE_MESSAGE.message);
    }

    public List<Lotto> publishLottoForPrice(int numberLottos) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < numberLottos; i++) {
            List<Integer> newLotto = GenerateRandomNumbers();

            sortLottoNumbers(newLotto);

            Lotto lotto = new Lotto(newLotto);

            OutputView.printLottoNumber(lotto);

            result.add(lotto);
        }

        return result;
    }

    public void printWinningMessage(Map<Integer, Integer> result) {
        //{0=3, 1=4, 2=1, 3=0, 4=0, 5=0, 6=0, 7=0} = {-,-,-,5등, 4등, 3등, 2등, 1등}
        LottoInfo.STATISTIC_MESSAGE.printMessage();

        int index = 3;
        for (RankInfo win : RankInfo.values()) {
            OutputView.winningStatistic(win, result, index);
            index++;
        }
    }

    public void printProfit(int userMoney, Map<Integer, Integer> result) {
        //{0=3, 1=4, 2=1, 3=0, 4=0, 5=0, 6=0, 7=0}
        int totalProfit = 0, index = 3;
        for (RankInfo prize : RankInfo.values()) {
            totalProfit += prize.prizeMoney * result.get(index);
            index++;
        }

        double totalRate = ((double) totalProfit / userMoney) * 100;
        OutputView.printTotalPrizeRate(totalRate);
    }
}
