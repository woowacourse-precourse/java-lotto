package lotto;

import static lotto.global.Constant.MAX_LOTTO_SIZE;

import java.util.Collections;
import java.util.List;
import lotto.global.Message;
import lotto.util.LottoParser;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoParser lottoParser = new LottoParser();

        if (numbers.size() != 6 || numbers.size() != numbers.stream().distinct().count()) {
            lottoParser.lottoError(Message.ERROR_LOTTO);
        }
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                lottoParser.lottoError(Message.ERROR_LOTTO);
            }
        });
    }

    public void print() {
        Collections.sort(numbers);

        System.out.print("[");
        for (int i = 0; i < MAX_LOTTO_SIZE - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.printf("%d]\n", numbers.get(5));
    }
}
