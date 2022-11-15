package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int END = 0;
    private static final List<Integer> LOTTO_ANSWER_END = new ArrayList<Integer>();
    private static final int LOTTO_COUNT = 6;

    public static void main(String[] args) {
        play();
        // TODO: 프로그램 구현
    }

    public static void play() {
        InputController game = new InputController();
        int count = game.checkTicketCount();
        List<List<Integer>> tickets = publish(count);
        List<Integer> lottoNumber = implementLotto(count, game);
        int bonusNumber = implementBonus(lottoNumber, game);
        showResult(lottoNumber, bonusNumber, tickets);
    }

    private static List<List<Integer>> publish(int count){
        if(count != END){
            Generator generator = new Generator(count);
            List<List<Integer>> tickets = generator.getTickets();
            OutputView.printTickets(tickets);
            return tickets;
        }
        return null;
    }

    private static void showResult(List<Integer> lottoNumbers, int bonusNumber, List<List<Integer>> tickets){

        Statistics.printReward(tickets, lottoNumbers, bonusNumber);
        Statistics.printProfitRate(tickets, lottoNumbers, bonusNumber);
    }

    private static List<Integer> implementLotto(int count, InputController game) {
        if (count != END) {
            List<Integer> lottoNumbers = game.checkLottoNumbers();
            return lottoNumbers;
        }
        return LOTTO_ANSWER_END;
    }

    private static int implementBonus(List<Integer> lottoNumber, InputController game) {
        if (lottoNumber.size() == LOTTO_COUNT){
            int bonusNumber = game.checkBonus(new Lotto(lottoNumber));
        }
        return END;
    }
}
