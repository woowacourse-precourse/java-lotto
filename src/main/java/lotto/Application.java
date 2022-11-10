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
        System.out.println(count.getNumOfLotto()+"개를 구매했습니다.");
        showLottoTickets();
        UserInput.inputWinningNumbers();
    }

    private static void createLottoTickets(int numOfLotto) {
        for (int i=INITIAL_NUMBER; i<numOfLotto; i++) {
            lottoTickets.add(createLotto());
        }
    }

    private static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static void showLottoTickets() {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
