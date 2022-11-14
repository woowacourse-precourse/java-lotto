package view;

import domain.Lotto;

import java.util.List;

public class OutputView {
    public static void requestPurchaseAmount() {
        System.out.println(Text.REQUEST_PURCHASE_AMOUNT);
    }

    public static void noticePublishedLotto(List<Lotto> publishedLotto) {
        System.out.print("\n" + publishedLotto.size());
        System.out.println(Text.NOTICE_NUMBER_OF_LOTTO);

        publishedLotto.stream().map(Lotto::getNumbers)
                .forEach(System.out::println);
    }
}
