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

    public Integer drawBonusNumber() {
        System.out.println(DRAW_BONUS_QUESTION);
        String answer = Console.readLine();
        return Integer.valueOf(answer);
    }

    }

    private static class Calculator {
        private static Rank calculateWin(Lotto lottoTicket, Lotto lotto, Integer bonusNumber) {
            Integer correctNumber = 0;
            Integer correctBonusNumber = 0;
            for (Integer number : lotto.getLottoNumbers()) {
                if (lottoTicket.getLottoNumbers().contains(number)) {
                    correctNumber++;
                }
            }
            if (correctNumber == 5) {
                if (lotto.getLottoNumbers().contains(bonusNumber)) {
                    bonusNumber++;
                }
            }
            return Rank.generateRank(correctNumber, correctBonusNumber);
        }

        private static Float calculateYield(List<Rank> ranks, Integer money) {
            Integer prize = 0;
            for (Rank rank : ranks) {
                prize += rank.getMoney();
            }
            return (float) prize / (float) money * 100;
        }
    }
}
