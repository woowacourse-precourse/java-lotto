package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 랜덤으로 저장되는 로또 번호
public class RandomLotto {
    private RandomLottoGenerator randomLottoGenerator;

    public RandomLotto(RandomLottoGenerator randomLottoGenerator) {
        this.randomLottoGenerator = randomLottoGenerator;
    }

    private void validate(int money) {
        if (money % 1000 != 0 || money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상이고 1000원으로 나누어떨어지는 금액이어야 합니다.");
        }
    }

    public List<Lotto> makeRandomLottos(int money) {
        validate(money);

        int buyLottoNumber = money / 1000;
        System.out.println(buyLottoNumber + "개를 구매했습니다.");

        // for 문 -> stream
        return IntStream.rangeClosed(1, buyLottoNumber)
                .mapToObj(c -> createRandomLotto())
                .collect(Collectors.toList());
    }

    private Lotto createRandomLotto() {
        List<Integer> numbers = randomLottoGenerator.makeRandomLotto();
        return new Lotto(numbers);
    }
}
