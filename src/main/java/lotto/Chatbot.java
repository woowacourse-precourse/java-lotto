package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Chatbot {

    public String askPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        return Console.readLine();
    }

    public void printUserLotto(int amount, List<List<Integer>> userNumber) {
        System.out.println();
        System.out.println(amount + "개를 구매했습니다.");

        for (int i = 0; i < amount; i++) {
            System.out.println(userNumber.get(i));
        }
    }

    public List<Integer> askLottoNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");

        List<Integer> lotto = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {
            lotto.add(Integer.parseInt(input[i]));
        }
        return lotto;
    }

    public int askLottoBonus() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        int bonus;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("보너스 번호는 숫자입니다.");
        }

        return bonus;
    }

    public void printResult(double rate, List<Integer> result) {
        System.out.println("\n당첨 통계\n" +
                "---\n3개 일치 (5,000원) - " + result.get(3) + "개\n" +
                "4개 일치 (50,000원) - " + result.get(4) + "개\n" +
                "5개 일치 (1,500,000원) - " + result.get(5) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(7) + "개\n" +
                "6개 일치 (2,000,000,000원) - " + result.get(6) + "개\n" +
                "총 수익률은 " + rate + "%입니다.");
    }
}
