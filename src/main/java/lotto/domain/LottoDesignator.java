package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constant.Constant.*;

public class LottoDesignator {
    public static final LottoDesignator getInstance = new LottoDesignator();
    public List<Integer> inputLotto(String lottoInput) {

        checkOnlyNumber(lottoInput);
        checkSixCipher(lottoInput);
        checkRange(lottoInput);
        checkDuplication(lottoInput);

        List<Integer> lotto = changeList(lottoInput);

        return lotto;
    }

    public int inputBonus(String lottoInput, String input) {

        checkOnlyNumber(input);
        checkRange(input);
        checkBonusDuplication(lottoInput, input);

        return changeInt(input);
    }

    private void checkOnlyNumber(String input) {
        String lotto = Arrays
                .stream(removeComma(input))
                .collect(Collectors.joining());
        if (!lotto.matches(INT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력 가능합니다.(구분자 쉼표만 가능)");
        }
    }

    private void checkSixCipher(String input) {
        String[] lotto = removeComma(input);
        if (lotto.length != CIPHER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해야 합니다.");
        }
    }

    private void checkDuplication(String input) {
        List<Integer> lotto = changeList(input);
        HashSet<Integer> removeDuplication = new HashSet<>(lotto);
        if (lotto.size() != removeDuplication.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void checkRange(String input) {
        List<Integer> lotto = changeList(input);
        for(int lottoIndex = 0; lottoIndex < lotto.size(); lottoIndex++) {
            int lottoNum = lotto.get(lottoIndex);
            if (lottoNum < RANGE_MIN || lottoNum > RANGE_MAX) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 범위만 입력 가능합니다.");
            }
        }
    }

    private void checkBonusDuplication(String input, String number) {
        List<Integer> lotto = changeList(input);
        int bonus = changeInt(number);
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복 불가합니다.");
        }
    }

    private String[] removeComma(String input) {
        return input.split(",");
    }

    private List<Integer> changeList(String input) {
        List<Integer> numbers = Stream.of(removeComma(input))
                .map(str -> Integer.parseInt(str))
                .collect(Collectors.toList());
        return numbers;
    }

    private int changeInt(String input) {
        return Integer.parseInt(input);
    }
}
