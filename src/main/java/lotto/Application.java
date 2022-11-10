package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int INITIAL_NUMBER = 0;
    static List<Lotto> lottoTickets = new ArrayList<>();

    public static void main(String[] args) {
        Count count = UserInput.inputPrice();
        createLottoTickets(count.getNumOfLotto());
    }

    private static List<Lotto> createLottoTickets(int numOfLotto) {
        for (int i=INITIAL_NUMBER; i<numOfLotto; i++) {
            lottoTickets.add(createLotto());
        }
        return lottoTickets;
    }

    private static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
