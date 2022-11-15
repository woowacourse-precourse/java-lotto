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
    public int matchItemCount(List<Map<Integer, List<Integer>>> result, int bonus, int count) {
        int matchItem = 0;
        if (bonus > 0) {
            matchItem += bonusMatch(result, bonus, count);
            return matchItem;
        }
        for (Map<Integer, List<Integer>> item : result) {
            matchItem += itemContainsKey(item, count);
        }
        return matchItem;
    }
    public int bonusMatch(List<Map<Integer, List<Integer>>> result, int bonus, int count) {
        int matchItem = 0;
        for (Map<Integer, List<Integer>> item : result) {
            matchItem += itemContainsKeyBonus(item, count, bonus);
        }
        return matchItem;
    }
    public int itemContainsKeyBonus(Map<Integer, List<Integer>> item, int count, int bonus) {
        if (item.containsKey(count)) {
            return bonusContains(item, count, bonus);
        }
        return 0;
    }
    public int bonusContains(Map<Integer, List<Integer>> item, int count, int bonus) {
        if (numbers.contains(bonus)){
            return 1;
        }
        return 0;
    }
    public int itemContainsKey(Map<Integer, List<Integer>> item, int count) {
        if (item.containsKey(count)) {
            return 1;
        }
        return 0;
    }
    public double printBenefit(int three, int four, int five, int fiveWithBonus, int six, int price) {
        double result = (double)(three*5000+four*50000+five*1500000+fiveWithBonus*30000000+six*2000000000) / (double)price;
        result*=100;
        System.out.printf("총 수익률은 %.1f%s입니다.", result,"%");
        return result;
    }
}