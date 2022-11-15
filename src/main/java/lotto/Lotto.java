package lotto;
import java.util.*;

import static lotto.ErrorMsg.ERRMSG;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        for (int num : numbers) {
            checkDuplicate(numbers, num);
        }
        this.numbers = numbers;
    }
    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERRMSG.getErrMsg());
        }
    }
    public static void checkDuplicate(List<Integer> numbers,int num) {
        int count = Collections.frequency(numbers, num);
        if (count > 1) {
            throw new IllegalArgumentException(ERRMSG.getErrMsg());
        }
    }
    public void calcLotto(List<List<Integer>> lottoLists, int bonus, int price) {
        List<Map<Integer, List<Integer>>> result = new ArrayList<>();
        for (List<Integer> lottoNumberList : lottoLists) {
            Map<Integer, List<Integer>> howMatch = new HashMap<>();
            int count = calcMatch(lottoNumberList);
            howMatch.put(count, lottoNumberList);
            result.add(howMatch);
        }
        printMatch(result, bonus, price);
    }
    public int calcMatch(List<Integer> lottoNumber) {
        int count = 0;
        for (int number : lottoNumber) {
            count+=countMatch(number);
        }
        return count;
    }
    public int countMatch(int num) {
        if (numbers.contains(num)) {
            return 1;
        }
        return 0;
    }
}