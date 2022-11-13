package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoLogic {
    private final static int START_LOTTO = 1;
    private final static int END_LOTTO = 45;
    private final static int LOTTO_NUMBER = 6;
    private static final int ONE_LOTTO = 1000;
    private int money;
    private int numberOfLotto;
    private List<Lotto> buyLottoList;
    private List<Integer> prizeNumbers;
    private int bonusNumber;
    private int threeHit = 0;
    private int fourHit = 0;
    private int fiveHit = 0;
    private int fiveHitAndBonus = 0;
    private int sixHit = 0;

    public LottoLogic(int money) {
        this.money = money;
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
        this.buyLottoList = new ArrayList<>();
        for (int i = 0; i < this.numberOfLotto; i++) {
            this.buyLottoList.add(new Lotto(createLottoNumber()));
        }
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(START_LOTTO, END_LOTTO, LOTTO_NUMBER);
    }

    public List<Lotto> getBuyLottoList() {
        return this.buyLottoList;
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
        for (Lotto lotto : this.buyLottoList) {
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
            this.fiveHitAndBonus++;
        }
        if (hitCount == 6) {
            this.sixHit++;
        }
    }
    public void calculateResult() {
        calculateCountHit();
    }
}