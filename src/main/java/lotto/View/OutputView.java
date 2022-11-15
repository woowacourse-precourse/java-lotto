package lotto.View;

import lotto.Domain.LottoWinningCriteria;
import lotto.Domain.LottoWinningMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    public static void printUserLotto(List<List<Integer>> userLotto) {
        System.out.println(userLotto.size() + "개를 구매했습니다.");
        for (List<Integer> lottoSheet : userLotto) {
            System.out.println(lottoSheet);
        }
    }
}

