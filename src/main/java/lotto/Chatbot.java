package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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

        for (String s : input) {
            lotto.add(Integer.parseInt(s));
        }
        return lotto;
    }

    public int askLottoBonus() {
        int bonus;

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("보너스 번호는 숫자입니다.");
        }
        return bonus;
    }

    public void printResult(double rate, List<Integer> result) {
        String formattedRate = String.format("%,.1f", rate);
        System.out.println("\n당첨 통계\n" +
                "---\n3개 일치 (5,000원) - " + result.get(Application.three.getValue()) + "개\n" +
                "4개 일치 (50,000원) - " + result.get(Application.four.getValue()) + "개\n" +
                "5개 일치 (1,500,000원) - " + result.get(Application.five.getValue()) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(Application.bonusMatch.getValue()) + "개\n" +
                "6개 일치 (2,000,000,000원) - " + result.get(Application.six.getValue()) + "개\n" +
                "총 수익률은 " + formattedRate + "%입니다.");
    }
}
