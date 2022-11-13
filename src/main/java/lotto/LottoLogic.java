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

    public void setPrizeNumbers(List<Integer> prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}