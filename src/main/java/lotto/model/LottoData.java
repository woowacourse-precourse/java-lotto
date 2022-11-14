package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Constants;

public class LottoData {
    double money;
    int bonusNumber;
    double prizeMoneySum;
    public double lottoAmount;
    public float percentageOfReturn;
    public List<Integer> winNumbers;
    public List<Lotto> allLotto;
    public PrizeData prizeCount;
    private final LottoCalculate lottoCalculate = new LottoCalculate();

    LottoData(double money) {
        this.money = money;
        this.lottoAmount = (money / Constants.LOTTO_PRICE);
        allLotto = new ArrayList<>((int) lottoAmount);
        prizeCount = new PrizeData();
        prizeMoneySum = 0;
    }

    public void makeLotto() {
        List<Integer> lottoNumbers;
        while (allLotto.size() != lottoAmount) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, Constants.LOTTO_SIZE);
            int[] integerNumbers = lottoNumbers.stream().mapToInt(number -> number).toArray();
            Arrays.sort(integerNumbers);
            Lotto lotto = new Lotto(Arrays.stream(integerNumbers).boxed().collect(Collectors.toList()));
            allLotto.add(lotto);
        }
    }

    public void calculateAllLotto() {
        for (Lotto lotto : allLotto) {
            lottoCalculate.calculateOverall(lotto, this);
        }
        lottoCalculate.calculatePercentageOfReturn(this);
    }

    void saveWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
