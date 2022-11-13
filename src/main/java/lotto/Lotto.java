package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkPlusNumber(int plusNumber) {
        if (numbers.contains(plusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복이 불가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getResult(List<Integer>[] issuedList, int plusNumber) {
        HashMap winningMap = makeListToMap(numbers);
        List<Integer> resultList = new ArrayList<>();
        for (List<Integer> issuedLotto : issuedList) {
            int count = compareLotto(issuedLotto, winningMap);
            resultList.add(count);
        }
        return resultList;
    }

    private HashMap makeListToMap(List<Integer> numbers) {
        HashMap<Integer, Integer> winningMap = new HashMap<>(6);
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            winningMap.put(number, 1);
        }
        return winningMap;
    }

    private int compareLotto(List<Integer> issuedLotto, HashMap winningMap) {
        int count = 0;
        for (int number : issuedLotto) {
            if (winningMap.get(number) != null) {
                count++;
            }
        }
        return count;
    }
}
