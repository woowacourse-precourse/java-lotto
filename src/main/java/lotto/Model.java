package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Model {


    private final List<Lotto> lottoList; // save computer generated Lotto numbers
    private Lotto winningLotto; // save user input Lotto numbers
    private int bonus;
    private double returnRate; // rate of return by Model.userMoney
    private int userMoney; // user input value

    public Model() {
        this.lottoList = new ArrayList<>();
    }

    /**
     *
     * @return Lotto object lists
     */
    public List<Lotto> getLottoList(){
        return lottoList;
    }

    /**
     * setter userMoney
     * set money with user input
     * @param money String to be thousands unit
     */
    public void setUserMoney(int money) {
        this.userMoney = money;
    }

    /**
     * generate lotto numbers.
     * repeat money / 1000 times.
     */
    public void generateLotto() {
        System.out.println(this.userMoney/1000);
        for(int i = 0; i < this.userMoney/1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            this.lottoList.add(new Lotto(numbers));
        }
    }

    /**
     * set win lotto
     * @param stringList string list
     */
    public void setWinningLotto(List<String> stringList) {
        List<Integer> winNumbers = new ArrayList<>();
        for(String item : stringList) {
            winNumbers.add(Integer.parseInt(item));
        }
        this.winningLotto = new Lotto(winNumbers);
    }

    /**
     * set bonus number with duplicate check
     * @param bonus
     */
    public void setBonus(int bonus) {
        ExceptionController.validateDuplicateBonusWithWin(this.winningLotto, bonus);
        this.bonus = bonus;
    }
}

