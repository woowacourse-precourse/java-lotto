package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Drawer {
    private static final String DRAW_LOTTO_QUESTION = "당첨 번호를 입력해 주세요.";
    private static final String DRAW_BONUS_QUESTION = "보너스 번호를 입력해 주세요.";

    public Lotto drawLotto() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println(DRAW_LOTTO_QUESTION);
        String answer = Console.readLine();
        for (String number : answer.split(",")) {
            numbers.add(Integer.valueOf(number));
        }
        return new Lotto(numbers);
    }

    public void compare(List<Lotto> lottoTickets, List<Integer> lotto) {

    }

    private static class Calculater {
        private static Map<Integer, Integer> calculateWin(List<Lotto> lottoTickets, List<Integer> lotto) {
            return new HashMap<Integer, Integer>();
        }

        private static Float calculateYield(Map<Integer, Integer> winLog, Integer money) {
            return new Float(0.0);
        }
    }
}
