package lotto;

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
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private Lotto createRandomLotto() {
        List<Integer> numbers = randomLottoGenerator.makeRandomLotto();
        return new Lotto(numbers);
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
}
