package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<List<Integer>> datas = new ArrayList<>();
    private int LottoPrice;

    public Game() {

    }

    public void HowMuch() {
        System.out.println("구입 금액을 입력해 주세요.");
        String price = Console.readLine();
        LottoPrice = Integer.parseInt(price);

        System.out.println("\n" + LottoPrice / 1000 + "개를 구매했습니다.");
        for (int i = 0; i < LottoPrice / 1000; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            datas.add(lottoNumbers);
        }
        for (int i = 0; i < LottoPrice / 1000; i++) {
            System.out.println(datas.get(i));
        }
    }

    public void Bonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String Bonus = Console.readLine();
        int BonusNumber = Integer.parseInt(Bonus);
        System.out.println(BonusNumber);
    }

    public void Jackpot() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String str1 = Console.readLine();
        String[] words = str1.split(",");

        List<Integer> numbers = new ArrayList<>();

        for (String wo : words) {
            numbers.add(Integer.parseInt(wo));
        }
        Lotto lotto = new Lotto(numbers);
        System.out.println(lotto.getNumbers());
        List<Integer> counts = countNum(datas, numbers);
        System.out.println(counts);
        int[] counter = prize(counts);
        Print(counter);

        float yield2 = this.yield(counter, LottoPrice);
        System.out.printf("\n총 수익률은 %.1f%%입니다.", yield2);
    }

    public List<Integer> countNum(List<List<Integer>> datas, List<Integer> numbers) {
        List<Integer> counts = new ArrayList<>();
        int count;
        for (List<Integer> data : datas) {
            count = 0;
            for (int j = 0; j < numbers.size(); j++) {
                if (data.contains(numbers.get(j))) {
                    count++;
                }
            }
            counts.add(count);
        }
        return counts;
    }

    public int[] prize(List<Integer> countNum) {
        int counterSize = 5;
        int[] counter = new int[counterSize];
        for (int i = 0; i < countNum.size(); i++) {
            if (countNum.get(i) == 3) {
                counter[0] += 1;
            } else if (countNum.get(i) == 4) {
                counter[1] += 1;
            } else if (countNum.get(i) == 5) {
                counter[2] += 1;
            } else if (countNum.get(i) == 6) {
                counter[3] += 1;
            }
        }
        for (int i = 0; i < counter.length; i++) {
            System.out.print(counter[i]);
        }
        return counter;
    }

    public void Print(int[] counter) {
        System.out.printf("\n당첨 통계\n---\n");
        System.out.printf("3개 일치 (5,000원) - %d개\n", counter[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", counter[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", counter[2]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개", counter[3]);
    }

    public int yield(int[] counter, int LottoPrice) {
        int sum = 0;
        sum += counter[0] * 5000;
        sum += counter[1] * 50000;
        sum += counter[2] * 1500000;
        sum += counter[3] * 2000000000;
        return sum / LottoPrice * 100;
    }
    /*
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
     */

}
