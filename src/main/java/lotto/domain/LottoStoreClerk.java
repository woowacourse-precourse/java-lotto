package lotto.domain;

import java.util.List;

/**
 * 장당 1000원에 로또를 판매
 */
public class LottoStoreClerk {
    private LottoPrinter lottoPrinter;

    public LottoStoreClerk(LottoPrinter lottoPrinter) {
        this.lottoPrinter = lottoPrinter;
    }

    public void sellLottoTo(Customer customer) {
        int fee = customer.pay();
        int theAmountOfLottos = caculateTheAmountOfLottos(fee);
        List<Lotto> lottos = lottoPrinter.printLottos(theAmountOfLottos);
        Receipt receipt = new Receipt(fee);
        customer.buy(lottos, receipt);
        checkNumbersOfLottos(lottos);
    }

    private int caculateTheAmountOfLottos(int fee) {
        return fee/1000;
    }

    private void checkNumbersOfLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
