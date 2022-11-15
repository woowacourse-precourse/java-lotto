package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class LottoUtil {

    public int StringToInt(String input) {
        if (!isNumeric(input))
            throw new IllegalArgumentException("입력이 숫자가 아닙니다.");

        return Integer.parseInt(input);
    }

    public List<Integer> StringListToIntList(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String current : input) {
            result.add(this.StringToInt(current));
        }
        return result;
    }

    public boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }

    public List<String> tokenizeString(String input) {
        List<String> result = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, ",");

        while (tokenizer.hasMoreTokens()) {
            result.add(tokenizer.nextToken());
        }
        return result;
    }

    public static boolean isSorted(List<Integer> input) {
        return IntStream.range(0, input.size() - 1).noneMatch(i -> input.get(i) > input.get(i+1));
    }

    public enum LottoNumberPromise {
        MIN_LOTTO_NUM(1),
        MAX_LOTTO_NUM(45),
        LOTTO_COUNT(6),
        PURCHASE_AMOUNT_UNIT(1000);

        private final int value;

        LottoNumberPromise(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }
}


