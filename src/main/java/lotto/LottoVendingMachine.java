package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoVendingMachine {

    public static final int LOTTO_NUMBERS_SIZE = LottoDrawMachine.LOTTO_NUMBERS_SIZE;
    public static final int MIN_VALUE = LottoDrawMachine.MIN_VALUE;
    public static final int MAX_VALUE = LottoDrawMachine.MAX_VALUE;

    /**
     * 로또 티켓의 개수를 출력하고 반환한다.
     *
     * @param purchaseAmount 구입금액
     * @return 로또 티켓의 개수
     */
    public static int getLottoTickets(int purchaseAmount) {
        int lottoTickets = purchaseAmount / 1000;
        printPurchaseQuantity(lottoTickets);
        return lottoTickets;
    }

    private static void printPurchaseQuantity(int lottoTickets) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoTickets);
    }


    /**
     * LottoDrawMachine에 정의된 상수에 따라 생성된 로또를 반환한다. 각 로또는 오름차순으로 정렬되어 있다.
     *
     * @param lottoTickets 로또 티켓의 개수
     * @return 서로 다른 숫자로 이루어진 로또 리스트
     * @throws IllegalArgumentException
     */
    public static List<Lotto> getLottos(int lottoTickets) throws IllegalArgumentException {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoTickets; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LOTTO_NUMBERS_SIZE);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        print(lottos);
        return lottos;
    }

    private static void print(List<Lotto> lottos) {
        lottos.stream().forEach(System.out::println);
    }
}
