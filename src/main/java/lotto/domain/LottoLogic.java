package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Validation;

import java.util.ArrayList;
import java.util.List;

public class LottoLogic {
    private final int money;
    private final int numberOfLotto;
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
        return this.money / LottoValue.ONE_LOTTO_PRICE.getValue();
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
        return Randoms.pickUniqueNumbersInRange(LottoValue.START_LOTTO_NUMBER.getValue(), LottoValue.END_LOTTO_NUMBER.getValue(), LottoValue.LOTTO_LENGTH.getValue());
    }

    public List<Lotto> getMyLottos() {
        return this.myLottos;
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

    public void setPrizeNumbers(List<String> prizeNumbers) {
        validatePrizeNumbers(prizeNumbers);
        this.prizeNumbers = stringListToIntegerList(prizeNumbers);
    }

    public void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
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
        this.earning = Hit.THREEHIT.getValue() * this.threeHit
                + Hit.FOURHIT.getValue() * this.fourHit
                + Hit.FIVEHIT.getValue() * this.fiveHit
                + Hit.FIVEHITANDBONUS.getValue() * this.fiveHitAndBonus
                + Hit.SIXHIT.getValue() * this.sixHit;
    }

    private void calculateEarningRate() {
        this.earningRate = this.earning / this.money * 100;
    }

    public void calculateResult() {
        calculateCountHit();
        calculateEarning();
        calculateEarningRate();
    }

    private void validateMoney(String money) {
        Validation.validateMoneyInput(money);
    }

    private void validatePrizeNumbers(List<String> prizeNumbers) {
        Validation.validatePrizeNumberInput(prizeNumbers);
    }

    private void validateBonusNumber(String bonusNumber) {
        Validation.validateBonusInput(bonusNumber, this.prizeNumbers);
    }

    public List<Integer> stringListToIntegerList(List<String> stringValues) {
        List<Integer> integerValues = new ArrayList<>();
        for (String value : stringValues) {
            integerValues.add(Integer.parseInt(value));
        }
        return integerValues;
    }
}