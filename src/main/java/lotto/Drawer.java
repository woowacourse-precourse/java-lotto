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

    public Integer drawBonusNumber(Lotto lotto) {
        System.out.println(DRAW_BONUS_QUESTION);
        String answer = Console.readLine();
        if(!answer.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하셨습니다.");
        }
        Integer number = Integer.valueOf(answer);
        if (number < 1 || 45 < number && lotto.getLottoNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
        return number;
    }

    public List<Rank> compare(List<Lotto> lottoTickets, Lotto lotto, Integer bonusNumber) {
        List<Rank> ranks = new ArrayList<Rank>();
        for (Lotto ticket : lottoTickets) {
            ranks.add(Calculator.calculateWin(ticket, lotto, bonusNumber));
        }
        return ranks;
    }

    public static class Calculator {
        private static Rank calculateWin(Lotto lottoTicket, Lotto lotto, Integer bonusNumber) {
            Integer correctNumber = 0;
            Integer correctBonusNumber = 0;
            for (Integer number : lotto.getLottoNumbers()) {
                if (lottoTicket.getLottoNumbers().contains(number)) {
                    correctNumber++;
                }
            }
            if (correctNumber == 5) {
                if (lottoTicket.getLottoNumbers().contains(bonusNumber)) {
                    correctBonusNumber++;
                }
            }
            return Rank.generateRank(correctNumber, correctBonusNumber);
        }

        public static Float calculateYield(List<Rank> ranks, Integer money) {
            Integer prize = 0;
            for (Rank rank : ranks) {
                prize += rank.getMoney();
            }
            return (float)Math.round((float) prize / (float) money * 1000) / 10;
        }
    }
}
