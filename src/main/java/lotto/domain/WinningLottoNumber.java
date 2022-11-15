package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumber {

    private int winNumber;

    public WinningLottoNumber(String input) {
        List<Integer> numbers = validate(input);
    }

    private List<Integer> validate(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (String s : input.split(",")) {
            int num;
            try {
                num = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Message.LOTTO_NUMMBER_ERROR.get());
            }
            numbers.add(num);
        }
        return numbers;
    }


}
