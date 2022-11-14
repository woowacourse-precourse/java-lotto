package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static final int moneyUnit = 1000;
    private static final int minNumber = 1;
    private static final int maxNumber = 45;
    private static final int numberCount = 6;

    public static void main(String[] args) {
        Application application = new Application();

        try {
            application.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        Ui ui = new Ui();
        int money = ui.moneyInput();
        List<LottoNumber> buyList = buyLotto(money);
        ui.buyLottoOutput(buyList);

        List<Integer> lotto = ui.lottoInput();
        int bonus = ui.bonusInput(lotto);
        List<Integer> lottoResult = getLottoResult(buyList, lotto, bonus);
        double totalProfit = getTotalProfit(money, lottoResult);

        ui.lottoResultTotalOutput(lottoResult);
        ui.totalProfitOutput(totalProfit);
    }

    public List<Integer> createLotto() {
        List<Integer> lottoNumber;

        while (true) {
            lottoNumber = createLottoNumber();

            if (isDistinctNumber(lottoNumber)) {
                break;
            }
        }
        return lottoNumber;
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, numberCount);
    }

    private boolean isDistinctNumber(List<Integer> number) {
        Set<Integer> reuslt = new HashSet<>(number);

        return number.size() == reuslt.size();
    }

    public List<LottoNumber> buyLotto(int money) {
        List<LottoNumber> buyList = new ArrayList<>();

        int buyCount = money / moneyUnit;

        for (int cnt = 0; cnt < buyCount; cnt++) {
            buyList.add(new LottoNumber(createLotto()));
        }
        return buyList;
    }

    public List<Integer> getLottoResult(List<LottoNumber> buyList, List<Integer> winningLotto, int bonusNumber) {
        List<Integer> lottoResult = Arrays.asList(0, 0, 0, 0, 0);

        for (LottoNumber lottoNumber : buyList) {
            int equalNumberCount = compareLotto(lottoNumber.getNumbers(), winningLotto);
            boolean bonus = isContainBonusNumber(lottoNumber.getNumbers(), bonusNumber);

            if (isWinning(equalNumberCount)) {
                int index = changeLottoResultNumber(equalNumberCount, bonus);
                lottoResult.set(index, lottoResult.get(index) + 1);
            }
        }
        return lottoResult;
    }

    private boolean isWinning(int equalNumberCount) {
        return equalNumberCount >= 3;
    }

    private int compareLotto(List<Integer> lottoNumber, List<Integer> winningLotto) {
        int equalNumberCount = 0;

        for (Integer number : lottoNumber) {
            if (winningLotto.contains(number)) {
                equalNumberCount += 1;
            }
        }
        return equalNumberCount;
    }

    private boolean isContainBonusNumber(List<Integer> lottoNumber, int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    private int changeLottoResultNumber(int count, boolean bonus) {
        if (count == 6) {
            return 0;
        }
        if (count == 5 && bonus) {
            return 1;
        }
        if (count == 5) {
            return 2;
        }
        if (count == 4) {
            return 3;
        }
        return 4;
    }

    public double getTotalProfit(int money, List<Integer> lottoResult) {
        double profit = 0;

        for (LottoResult result : LottoResult.values()) {
            profit += (result.getMoney() * lottoResult.get(result.getIndex()));
        }
        return Math.round((profit / money * 100) * 1000) / 1000.0;
    }

}
