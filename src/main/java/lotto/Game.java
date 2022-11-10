package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static int price;
    static LottoTickets lottoTickets;

    public static void enterPrice() {
        price = Integer.parseInt(Console.readLine());
    }

    public static void buyLottoTickets() {
        int counts = price / ReferenceValue.LOTTO_PRICE;

        Record.printBuyCounts(counts);

        List<Lotto> allLottery = new ArrayList<>();
        for (int i = 0; i < counts; i++) {
            String lottoNumbersInput = Console.readLine();
            List<Integer> lottoNumbers = Lotto.getLottoNumbers(lottoNumbersInput);

            Record.printLotto(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            allLottery.add(lotto);
        }

        lottoTickets = new LottoTickets(allLottery);
    }
}
