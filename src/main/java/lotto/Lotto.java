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
    public void printMatch(List<Map<Integer, List<Integer>>> result, int bonus, int price) {
        int three = matchItemCount(result, 0, 3);
        int four = matchItemCount(result, 0, 4);
        int five = matchItemCount(result, 0, 5);
        int fiveWithBonus = matchItemCount(result, bonus, 5);
        int six = matchItemCount(result, 0, 6);
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveWithBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
        printBenefit(three, four, five, fiveWithBonus, six, price);
    }
}