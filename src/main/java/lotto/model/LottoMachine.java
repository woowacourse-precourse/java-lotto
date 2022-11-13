package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoMachine {

    private List<Integer> answer;
    private int bonus;

    public void setLuckyNumber(List<Integer> answer, int bonus) {
        this.answer = answer;
        this.bonus = bonus;
    }

    public List<Lotto> publish(long price) {
        List<Lotto> lottos = new ArrayList<>();
        while (price >= 1000) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            lottos.add(new Lotto(numbers));
            price -= 1000;
        }
        return lottos;
    }


    public WinningRecord drawAll() {
        return new WinningRecord();
    }
}
