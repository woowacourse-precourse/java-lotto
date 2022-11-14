package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해주세요.");
        int amountMoney = 0;
        try {
            amountMoney = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            showError(e);
        }
        if(amountMoney % 1000 != 0) {
            showError(new Exception());
        }
        System.out.println(amountMoney / 1000 + "개를 구매했습니다.");

        List<Lotto> lottos = getLottos(amountMoney / 1000);
        System.out.println("당첨 번호를 입력해주세요.");
        Lotto answer = null;
        try {
            answer = new Lotto(Arrays.stream(Console.readLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        } catch(Exception e) {
            showError(e);
        }
        System.out.println();

        System.out.println("보너스 번호를 입력해주세요.");
        int bonus = 0;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            showError(e);
        }
        System.out.println();

        getResults(answer, bonus, lottos, amountMoney);
    }
    public static List<Lotto> getLottos(int repeat) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < repeat ; i += 1) lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        for(int i = 0 ; i < repeat ; i += 1) System.out.println(lottos.get(i).getNumbers());
        return lottos;
    }
    public static void getResults(Lotto answer, int bonus, List<Lotto> lottos, int amountMoney) {
        int[] lottoCount = new int[5];
        for(Lotto lotto : lottos) {
            int correctCount = getCorrectCount(answer, lotto);
            if(correctCount > 2) lottoCount[correctCount - 3]++;
            if(correctCount == 5 && lotto.hasBonus(bonus)) {
                lottoCount[correctCount - 3]--;
                lottoCount[4]++;
            };
        }
        showResults(lottoCount, amountMoney);
    }
    public static int getCorrectCount(Lotto answer, Lotto lotto) {
        int count = 0;
        for(int i : lotto.getNumbers()) {
            if(answer.getNumbers().contains(i)) count++;
        }
        return count;
    }
    private static void showResults(int[] lottoCount, int amountMoney) {
        double total = getTotal(lottoCount);
        System.out.println("당첨통계\n---");
        System.out.println("3개 일치 (5,000원) - " + lottoCount[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoCount[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoCount[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoCount[4] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoCount[3] + "개");
        System.out.println("총 수익률은 " + Math.round(total / amountMoney * 10000) / 10 * 1.0 / 10 + "%입니다.");
    }

    private static double getTotal(int[] lottoCount) {
        return lottoCount[0] * 5_000 + lottoCount[1] * 50_000 + lottoCount[2] * 1_500_000 + lottoCount[4] * 30_000_000 + lottoCount[3] * 2_000_000_000;
    }

    public static void showError(Exception e) {
        try {
            throw new IllegalArgumentException();
        } catch(IllegalArgumentException exception) {
            System.out.println("[ERROR] :: " + e.getMessage());
        }
    }
}
