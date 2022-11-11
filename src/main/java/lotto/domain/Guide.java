package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Guide {
    public static void printGetMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(int LottoCount) {
        System.out.println("\n" + Integer.toString(LottoCount) + "개를 구매했습니다.");
    }

    public static int convertStringToInt(String Number) {
        return Integer.parseInt(Number);
    }

    public static List<String> splitNumber(String Number) {
        String[] numbers = Number.split(",");

        return new ArrayList<String>(Arrays.asList(numbers));
    }

    public static List<Integer> convertStringListToIntegerList(List<String> lottoNumbers) {
        return lottoNumbers.stream().map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
