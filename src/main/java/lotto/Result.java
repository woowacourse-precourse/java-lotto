package lotto;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<Lotto> userLottos;
    private Lotto winningNumbers;
    private Integer bonus;
    private List<Integer> counts;

    private List<Integer> bonuses;

    public Result(List<Lotto> userLottos, Lotto winningNumbers, Integer bonus) {
        this.userLottos = userLottos;
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public List<Integer> getBonuses() {
        return bonuses;
    }

    public void calc(){
        getCount();

    }

    private void getCount() {
        List<Integer> numbers = winningNumbers.getNumbers();
        init();
        for (Lotto userLotto : userLottos) {
            List<Integer> userNumbers = userLotto.getNumbers();
            Integer countRes = hasNumber(userNumbers, numbers);
            counts.add(countRes);
            hasBonus(userNumbers);
        }
    }

    private void init(){
        counts = new ArrayList<>();
        bonuses = new ArrayList<>();
    }

    private Integer hasNumber(List<Integer> userNumbers, List<Integer> numbers) {
        Integer count = 0;
        for (Integer userNumber : userNumbers) {
            if (numbers.contains(userNumber)) count++;
        }
        return count;
    }

    private void hasBonus(List<Integer> userNumbers){
        if (userNumbers.contains(bonus)){
            bonuses.add(1);
            return;
        }
        bonuses.add(0);
    }
}
