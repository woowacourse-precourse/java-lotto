package lotto.controller;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserOutput {
    public static void viewLottos(ManageLotto manageLotto) {
        System.out.println(String.format("%d개를 구매했습니다.", manageLotto.lottoNum));
        manageLotto.makeMyLotto(manageLotto.lottoNum);
        for (Lotto newLotto: manageLotto.myLotto) {
            List<Integer> tmpNumbers = new ArrayList<>(newLotto.getLottoNumbers());
            tmpNumbers.sort(Comparator.naturalOrder());
            System.out.println(tmpNumbers);
        }
        System.out.println();
    }
}
