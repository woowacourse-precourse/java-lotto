package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public WinningRecord drawAll(List<Lotto> lottos) {
        int[] temp = new int[]{0, 0, 0, 0, 0, 0};
        lottos.forEach(lotto -> {
            int place = lotto.draw(answer, bonus);
            temp[place]++;
        });
        List<Integer> history = Arrays.stream(temp).boxed().collect(Collectors.toList());
        return new WinningRecord(history);
    }
}
