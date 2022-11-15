package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Lotto> lottoList;
    private int userMoney;
    private Lotto winningLotto;
    private int bonus;

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
}
