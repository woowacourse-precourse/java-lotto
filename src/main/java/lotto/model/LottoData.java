package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoData {
    public double money;
    public int bonusNumber;
    public double lottoAmount;
    public double prizeMoneySum;
    public List<Integer> winNumbers;
    public List<Lotto> allLotto;
    public PrizeData prize;
    private final LottoCalculate lottoCalculate = new LottoCalculate();

    public LottoData(double money) {
        this.money = money;
        this.lottoAmount = (money / 1000);
        allLotto = new ArrayList<>((int) lottoAmount);
        prize = new PrizeData();
        prizeMoneySum = 0;
    }

    public void makeLotto() {
        List<Integer> lottoNumbers;
        while (allLotto.size() != lottoAmount) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            int[] integerNumbers = lottoNumbers.stream().mapToInt(number -> number).toArray();
            Arrays.sort(integerNumbers);
            Lotto lotto = new Lotto(Arrays.stream(integerNumbers).boxed().collect(Collectors.toList()));
            allLotto.add(lotto);
        }
    }

    public void calculateAllData() {
        for (Lotto lotto : allLotto) {
            lottoCalculate.totalCalculate(lotto, this);
        }
    }

    public float percentageOfReturn() {
        return lottoCalculate.calculatePercentageOfReturn(money, prizeMoneySum);
    }

    void saveWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
