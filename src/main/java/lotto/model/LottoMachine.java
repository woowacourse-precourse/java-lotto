package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoMachine {
    private List<Integer> answer;
    private int bonus;

    private void validate(List<Integer> answer, int bonus) {
        if (answer.contains(bonus)) throw new IllegalArgumentException("당첨 번호와 중복되지 않는 보너스 번호를 입력해주세요.");
        if (answer.size() != 6) throw new IllegalArgumentException("당첨 번호는 6개의 숫자입니다.");

        validateNumber(bonus);
        validateOverlap(answer);
        answer.forEach(this::validateNumber);
    }

    private void validateNumber(int number) {
        if (number > 45 || number < 1) throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private void validateOverlap(List<Integer> answer) {
        Set<Integer> set = new HashSet<>(answer);
        if (set.size() != 6) throw new IllegalArgumentException("로또의 각 번호는 중복이 없어야 합니다.");
    }

    public void setLuckyNumber(List<Integer> answer, int bonus) {
        validate(answer, bonus);
        this.answer = answer;
        this.bonus = bonus;
    }

    public List<Lotto> publish(long price) {
        if (price < 1000) throw new IllegalArgumentException("입력하신 금액으로는 복권을 구매할 수 없습니다.");
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
