package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoLogic {
    private final static int START_LOTTO = 1;
    private final static int END_LOTTO = 45;
    private final static int LOTTO_NUMBER = 6;
    private static final int ONE_LOTTO = 1000;
    private int money;
    private int numberOfLotto;
    private List<Lotto> myLottos;
    private List<Integer> prizeNumbers;
    private int bonusNumber;
    private double earning;
    private double earningRate;
    private int threeHit = 0;
    private int fourHit = 0;
    private int fiveHit = 0;
    private int fiveHitAndBonus = 0;
    private int sixHit = 0;

    public LottoLogic(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
        this.numberOfLotto = calculateNumberOfLotto();
        this.buyLotto();
    }

    private int calculateNumberOfLotto() {
        return this.money / ONE_LOTTO;
    }

    public int getNumberOfLotto() {
        return this.numberOfLotto;
    }

    private void buyLotto() {
        this.myLottos = new ArrayList<>();
        for (int i = 0; i < this.numberOfLotto; i++) {
            this.myLottos.add(new Lotto(createLottoNumber()));
        }
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(START_LOTTO, END_LOTTO, LOTTO_NUMBER);
    }

    public List<Lotto> getMyLottos() {
        return this.myLottos;
    }

    public List<Integer> getPrizeNumbers() {
        return this.prizeNumbers;
    }

    public int getThreeHit() {
        return this.threeHit;
    }

    public int getFourHit() {
        return this.fourHit;
    }

    public int getFiveHit() {
        return this.fiveHit;
    }

    public int getFiveHitAndBonus() {
        return this.fiveHitAndBonus;
    }

    public int getSixHit() {
        return this.sixHit;
    }

    public double getEarningRate() {
        return this.earningRate;
    }

    public void setPrizeNumbers(List<Integer> prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private int comparePrizeNumber(Lotto lotto) {
        int count = 0;
        for (int prizeNumber : this.prizeNumbers) {
            if (lotto.getNumbers().contains(prizeNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean compareBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(this.bonusNumber);
    }

    private void calculateCountHit() {
        for (Lotto lotto : this.myLottos) {
            int hitCount = comparePrizeNumber(lotto);
            if (hitCount >= 3) {
                boolean bonusHit = compareBonusNumber(lotto);
                countLottoHit(hitCount, bonusHit);
            }
        }
    }

    private void countLottoHit(int hitCount, boolean bonusHit) {
        if (hitCount == 3) {
            this.threeHit++;
        }
        if (hitCount == 4) {
            this.fourHit++;
        }
        if (hitCount == 5 && bonusHit) {
            this.fiveHitAndBonus++;
        }
        if (hitCount == 5 && !bonusHit) {
            this.fiveHit++;
        }
        if (hitCount == 6) {
            this.sixHit++;
        }
    }

    private void calculateEarning() {
        this.earning = 5000 * this.threeHit
                + 50000 * this.fourHit
                + 1500000 * this.fiveHit
                + 30000000 * this.fiveHitAndBonus
                + 2000000000 * this.sixHit;
    }

    private void calculateEarningRate() {
        this.earningRate = this.earning / this.money * 100;
    }

    public void calculateResult() {
        calculateCountHit();
        calculateEarning();
        calculateEarningRate();
    }

    private void validateMoney(String money){
        Validation.validateMoneyInput(money);
    }
}