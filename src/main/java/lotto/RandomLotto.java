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
}
