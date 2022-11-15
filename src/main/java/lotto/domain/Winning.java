package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Winning extends Valid {
    private List<Integer> numbers;
    private int bonus;

    public Winning() {
    }

    public void pickNum() throws IllegalArgumentException {
        String[] input = Console.readLine().split(",");
        List<Integer> saveNumbers = saveNumbers(input);
        validate(saveNumbers);
        this.numbers = saveNumbers;
    }

    public void pickBonus() throws IllegalArgumentException {
        String input = Console.readLine();
        validate(input);
        this.bonus = Integer.parseInt(input);
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        isCorrectSize(numbers);
        isCorrectRange(numbers);
        isNoDuplicate(numbers);
    }

    private void validate(String bonus) throws IllegalArgumentException {
        isCorrectRange(List.of(Integer.parseInt(bonus)));
    }

    private List<Integer> saveNumbers(String[] numbers) {
        List<Integer> save = new ArrayList<>();
        for (String number : numbers) {
            save.add(Integer.parseInt(number));
        }
        return save;
    }

    public void draw(User user) {
        List<Lotto> lottos = user.getLottos();
        for (Lotto o : lottos) {
            user.saveResult(compareLotto(o));
        }
    }

    private Rank compareLotto(Lotto o) {
        int cnt = 0;
        boolean bonus = false;
        List<Integer> userNums = o.getNumbers();
        for (int num : userNums) {
            if (this.numbers.contains(num)) {
                cnt++;
            }
            if (this.bonus == num) {
                bonus = true;
            }
        }
        return Rank.findRank(cnt, bonus);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}
