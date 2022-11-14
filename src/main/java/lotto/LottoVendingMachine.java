package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoVendingMachine {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    public static int getLottoTickets(int purchaseAmount) {
        int lottoTickets = purchaseAmount / 1000;
        System.out.printf("\n%d개를 구매했습니다.\n", lottoTickets);
        return lottoTickets;
    }

    public static List<Lotto> getLottos(int lottoTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoTickets; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LOTTO_NUMBERS_SIZE);
            numbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        printLottos(lottos);
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        String output = "[";
        for (int number : lotto.getNumbers()) {
            output += String.valueOf(number);
            output += ", ";
        }
        output = output.substring(0, output.length() - 2); // ", ".length() == 2 마지막 ", " 제거
        output += "]";
        System.out.println(output);
    }
}
