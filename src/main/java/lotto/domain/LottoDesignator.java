package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoDesignator {
    private static final String INT_REGEX = "^[0-9]*$";
    private static final int CIPHER = 6;
    private static final int RANGE = 45;

    public void checkOnlyNumber(String input) {
        String lotto = Arrays
                .stream(removeComma(input))
                .collect(Collectors.joining());
        if(!lotto.matches(INT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력 가능합니다.(구분자 쉼표만 가능)");
        }
    }

    public void checkSixCipher(String input) {
        String[] lotto = removeComma(input);
        if(lotto.length != CIPHER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해야 합니다.");
        }
    }

    public void checkDuplication(String input) {
        List<Integer> lotto = changeList(input);
        HashSet<Integer> removeDuplication = new HashSet<>(lotto);
        if(lotto.size() != removeDuplication.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public void checkRange(String input) {
        List<Integer> range = initRange();
        List<Integer> lotto = changeList(input);
        for(int lottoIndex = 0; lottoIndex<lotto.size(); lottoIndex++) {
            if(!range.contains(lotto.get(lottoIndex))) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 범위만 입력 가능합니다.");
            }
        }

    }

    private String[] removeComma(String input) {
        return input.split(",");
    }

    private List<Integer> changeList(String input) {
        Integer[] numbers = Stream.of(removeComma(input))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        return Arrays.asList(numbers);
    }
}
