package lotto.domain;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    public static List<Integer> getResult(List<Lotto> lottos, List<Integer> winningNumber, Integer bonusNumber) {
        int[] result = {0, 0, 0, 0, 0, 0, 0};

        for (Lotto lotto : lottos) {
            int index = getLottoPlace(lotto.getNumbers(), winningNumber, bonusNumber);
            result[index]++;
        }

        return Arrays.stream(result)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int getLottoPlace(List<Integer> lottoNumbers, List<Integer> winningNumbers, Integer bonusNumber) {
        Integer takePlace = 7 - (int) lottoNumbers.stream()
                .filter(number -> winningNumbers.contains(number))
                .count();

        if (takePlace == 1) {
            return takePlace;
        }

        if (takePlace == 2 && lottoNumbers.contains(bonusNumber)) {
            return takePlace;
        }

        return Math.min(takePlace + 1, 6);
    }
}
