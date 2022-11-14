package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputChecker;
import lotto.util.NumberGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static lotto.util.InputChecker.UNIT;

public class Users {

    private final String INPUT_BUYING_PRICE = "구입금액을 입력해 주세요.";
    private final String BUYING_MESSAGE = "개를 구매했습니다.";
    private final Integer price;
    private final List<Lotto> lottos;

    public Users() {
        this.price = initPrice();
        this.lottos = purchaseLotto();
    }

    Integer initPrice() {
        inputMessage();
        return InputChecker.checkPrice(Console.readLine());
    }

    void inputMessage() {
        System.out.println(INPUT_BUYING_PRICE);
    }

    List<Lotto> purchaseLotto() {
        Integer value = count();
        printPurchaseMessage(value);
        return IntStream.range(0, value)
                .boxed()
                .map(number -> createLotto())
                .collect(toList());
    }

    void printPurchaseMessage(Integer number) {
        System.out.println(number + BUYING_MESSAGE);
    }

    Integer count() {
        return (price / UNIT);
    }

    Lotto createLotto() {
        Lotto lotto = new Lotto(NumberGenerator.randomNumbers());
        lotto.printNumbers();
        return lotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer getPrice() {
        return price;
    }
}
