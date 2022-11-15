package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplication(numbers);
        checkRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    private void checkDuplication(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            System.out.println("[ERROR] 로또 번호는 중복이 불가능 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복이 불가능합니다.");
        }
    }

    public List<Integer>[] getResult(List<Integer>[] issuedList, int plusNumber) {
        HashMap winningMap = makeListToMap(numbers);
        List<Integer>[] resultList = new List[issuedList.length];
        for (int i=0; i<issuedList.length; i++) {
            List<Integer> issuedLotto = issuedList[i];
            List<Integer> result = compareLotto(issuedLotto, winningMap, plusNumber);
            resultList[i] = result;
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

    private List<Integer> compareLotto(List<Integer> issuedLotto, HashMap winningMap, int plusNumber) {
        int count = 0;
        int bonus = 0;
        List<Integer> result = new ArrayList<>();
        for (int number : issuedLotto) {
            if (winningMap.get(number) != null) {
                count++;
            }
        }
        for (int number: issuedLotto) {
            if (plusNumber==number){
                bonus=1;
                break;
            }
        }
        result.add(count);
        result.add(bonus);
        return result;
    }
}
