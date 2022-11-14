package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import java.util.Comparator;

public class UI {

    public static int getAnswerInInteger(String request) throws IllegalArgumentException {
        try {
            String answer = getAnswer(request);
            return Integer.parseInt(answer);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static String getAnswer(String request) {
        System.out.print(request);
        return Console.readLine().trim();
    }

    public static void printLotteries(Map<Lotto, Bonus> lotteries) {
        System.out.println();
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (Lotto lotto: lotteries.keySet()) {
            lotto.getNumbers().sort(Comparator.naturalOrder());
            System.out.println(lotto);
        }
        System.out.println();
    }

}
