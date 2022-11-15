package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 6개 입니다.");
        }
    }

    // TODO: 추가 기능 구현
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        if (price % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
        return price/1000;
    }

    public static List<Integer> getLuckyNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] n = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : n)
            numbers.add(Integer.valueOf(s));
        return numbers;
    }

    public int getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (numbers.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        return bonusNumber;
    }

    public static List<Integer>[] createNumbers(int count) {
        List<Integer>[] allNumbers = new List[count];
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            allNumbers[i] = numbers;
        }
        return allNumbers;
    }

    public static void printNumbers(List<Integer>[] allNumbers) {
        System.out.println(allNumbers.length + "개를 구매했습니다.");
        for (List allNumber : allNumbers)
            System.out.println(allNumber);
    }

    public void getResult(List<Integer>[] customerNumbers, int bonusNumber) {
        for (List<Integer> num : customerNumbers) {
            int matchCount = 0, bonus = 0;
            for (int n : num) {
                if (numbers.contains(n))
                    matchCount++;
                if (bonusNumber == n)
                    bonus = 1;
            }
            Rank rank = Rank.getRank(matchCount, bonus);
            rank.updateCount();
        }
    }

    public void printResult(int t) {
        int[] result = new int[6];
        int prize = 0;
        for (Rank i : Rank.values()) {
            result[i.ordinal()] = i.getCount();
            prize += i.getPrize() * i.getCount();
        }
        double rate =  (double)prize /(double) (t * 1000) *100;
        System.out.println("당첨 통계\n" + "---");
        System.out.printf("3개 일치 (5,000원) - %d개\n" + "4개 일치 (50,000원) - %d개\n" +
                "5개 일치 (1,500,000원) - %d개\n" + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                "6개 일치 (2,000,000,000원) - %d개\n" +
                "총 수익률은 %02.1f%%입니다.", result[4], result[3], result[2], result[1], result[0], rate);
    }
}
