package lotto.view;

import java.util.List;

public class OutputView {

    public static void printRandomLottoNumbers(List<List<Integer>> randomLottoNumbers) {
        randomLottoNumbers.forEach(System.out::println);
    }
}
