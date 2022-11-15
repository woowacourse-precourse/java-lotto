package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.InputController;
import lotto.controller.Statistics;
import lotto.domain.Generator;
import lotto.domain.Lotto;
import lotto.view.OutputView;

public class Application {
    private static final int END = 0;
    private static final List<Integer> LOTTO_ANSWER_END = new ArrayList<Integer>();
    private static final List<List<Integer>> TICKETS_END = new ArrayList<List<Integer>>();
    private static final int LOTTO_COUNT = 6;

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        InputController game = new InputController();
        int count = game.checkTicketCount();
        List<List<Integer>> tickets = publish(count);
        List<Integer> lottoNumber = implementLotto(count, game);
        int bonusNumber = implementBonus(lottoNumber, game);
        showResult(lottoNumber, bonusNumber, tickets);
    }

    private static List<List<Integer>> publish(int count) {
        if (count != END) {
            Generator generator = new Generator(count);
            List<List<Integer>> tickets = generator.getTickets();
            OutputView.printTickets(tickets);
            return tickets;
        }
        return TICKETS_END;
    }

    private static void showResult(List<Integer> lottoNumbers, int bonusNumber, List<List<Integer>> tickets) {
        if (lottoNumbers.size() != 0 && tickets.size() != 0 && bonusNumber != 0) {
            Statistics.print(tickets, lottoNumbers, bonusNumber);
        }
    }

    private static List<Integer> implementLotto(int count, InputController game) {
        if (count != END) {
            List<Integer> lottoNumbers = game.checkLottoNumbers();
            return lottoNumbers;
        }
        return LOTTO_ANSWER_END;
    }

    private static int implementBonus(List<Integer> lottoNumber, InputController game) {
        if (lottoNumber.size() == LOTTO_COUNT) {
            int bonusNumber = game.checkBonus(new Lotto(lottoNumber));
            return bonusNumber;
        }
        return END;
    }
}
