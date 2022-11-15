package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {
    private static final List<Integer> NUMBER_LIST = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    private LottoShop() {
    }

    public static LottoTicket buyLottos(int price) {
        return IntStream.rangeClosed(1, getLottoCountForBuying(price))
                .mapToObj(count -> LottoShop.generateLotto())
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::new));
    }

    private static int getLottoCountForBuying(int price){
        return Money.from(price)
                .divide(Money.from(1000L))
                .intValue();
    }


    private static Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(NUMBER_LIST);
        Collections.shuffle(numbers);
        List<Integer> pickedList = numbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(pickedList);
    }
}
