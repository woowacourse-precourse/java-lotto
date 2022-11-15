package lotto.number;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.printer.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int LENGTH = 6;

    public static List<Lotto> generateLottoNumber(int numberOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto;
        Printer.printNumberOfTickets(numberOfLotto);
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumber);
            lotto = new Lotto(lottoNumber);
            System.out.println(lotto);
            lottoList.add(lotto);
        }
        return lottoList;
    }
}
