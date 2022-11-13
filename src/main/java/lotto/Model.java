package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {


    private final List<Lotto> lottoList; // save computer generated Lotto numbers
    private Lotto winningLotto; // save user input Lotto numbers
    private int bonus;
    private double returnRate; // rate of return by Model.userMoney
    private int userMoney; // user input value
    private List<Integer> sameNumbers = Arrays.asList(0, 0, 0, 0, 0);

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
     * @param bonus integer to set bonus
     */
    public void setBonus(int bonus) {
        ExceptionController.validateDuplicateBonusWithWin(this.winningLotto, bonus);
        this.bonus = bonus;
    }

    /**
     * compare one purchased numbers, you select numbers
     * @param index purchased numbers index
     * @return how many you select same number
     */
    private int compareWithIndex(int index) {
        int num = 0;
        int bonus = 0;

        List<Integer> temp = this.lottoList.get(index).getNumbers();
        for(int i = 0; i < 6; i++) {
            if(temp.contains(this.winningLotto.getNumbers().get(i))) {
                num += 1;
            }
        }
        if(temp.contains(this.bonus)) {
            bonus += 1;
        }
        return num + bonus;
    }

    /**
     * compare your select numbers, bonus number with purchased numbers
     */
    public void compare() {
        for(int i = 0; i < this.lottoList.size(); i++) {
            PrizeNumber prizeNumber = PrizeNumber.getSameNumber(this.compareWithIndex(i)-3);
            if(prizeNumber != null) {
                this.sameNumbers.set(
                        prizeNumber.ordinal(),
                        this.sameNumbers.get(prizeNumber.ordinal()) + 1
                );
            }
        }
    }

    /**
     * getter same numbers
     * @return sameNumbers
     */
    public List<Integer> getSameNumbers() {
        return this.sameNumbers;
    }


    /**
     * calculate rate of return
     */
    public void calculateReturn() {
        long returnPrize = 0;
        for(PrizeNumber prizeNumber : PrizeNumber.values()) {
            returnPrize += this.sameNumbers.get(prizeNumber.ordinal()) * prizeNumber.prize();
        }

        this.returnRate = (returnPrize/(double)this.userMoney)*100;
    }

    /**
     * get return rate
     * @return double
     */
    public double getReturnRate() {
        return this.returnRate;
    }
}

