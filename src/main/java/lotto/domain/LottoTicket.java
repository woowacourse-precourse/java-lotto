package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private Integer[] lotto;

    public List<Integer> makeLotto() {
        lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6).toArray(new Integer[0]);
        printLotto();
        return new ArrayList<>(Arrays.asList(lotto));
    }

    private void printLotto() {
        Arrays.sort(lotto);
        System.out.println(Arrays.toString(lotto));
    }
}
