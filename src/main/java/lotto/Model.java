package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private final List<Lotto> lottoList;
    private int userMoney;
    private Lotto winningLotto;
    private int bonus;
    private List<Integer> sameNumbers = Arrays.asList(0, 0, 0, 0, 0);
    private double returnRate;

    public Model() {
        this.lottoList = new ArrayList<>();
    }
    public List<Lotto> getLottoList() {
        return lottoList;
    }
    public void setUserMoney(int money) {
        this.userMoney = money;
    }
    public void generateLotto() {
        for (int i = 0; i < this.userMoney / 1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            this.lottoList.add(new Lotto(numbers));
        }
    }
    public void setWinningLotto(List<String> stringList) {
        List<Integer> winNumbers = new ArrayList<>();
        for (String item : stringList) {
            winNumbers.add(Integer.parseInt(item));
        }
        this.winningLotto = new Lotto(winNumbers);
    }

    public void setBonus(int bonus) {
        ExceptionController.validateDuplicateBonusWithWin(this.winningLotto, bonus);
        this.bonus = bonus;
    }

    private int compareWithIndex(int index) {
        int num = 0;
        int bonus = 0;

        List<Integer> temp = this.lottoList.get(index).getNumbers();
        for (int i = 0; i < 6; i++) {
            if (temp.contains(this.winningLotto.getNumbers().get(i))) {
                num += 1;
            }
        }
        if (temp.contains(this.bonus)) {
            bonus += 1;
        }
        return num + bonus;
    }

    public void compare() {
        for (int i = 0; i < this.lottoList.size(); i++) {
            PrizeNumber prizeNumber = PrizeNumber.getSameNumber(this.compareWithIndex(i) - 3);
            if (prizeNumber != null) {
                this.sameNumbers.set(
                        prizeNumber.ordinal(),
                        this.sameNumbers.get(prizeNumber.ordinal()) + 1
                );
            }
        }
    }

    public List<Integer> getSameNumbers() {
        return this.sameNumbers;
    }

    public void calculateReturn() {
        long returnPrize = 0;
        for(PrizeNumber prizeNumber : PrizeNumber.values()) {
            returnPrize += this.sameNumbers.get(prizeNumber.ordinal()) * prizeNumber.prize();
        }
        this.returnRate = (returnPrize / (double)this.userMoney) * 100;
    }
    public double getReturnRate() {
        return this.returnRate;
    }
}
