package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Output;

import java.util.*;
import java.util.stream.Collectors;

public class PickRandomLottoLists {
    public final int LIMIT_LOTTO = 6;
    public static List<List<Integer>> randomLottoLists = new ArrayList<>();
    Output output = new Output();

    public void PickRandomNumber(int lottoPapers) {
        while(randomLottoLists.size() != lottoPapers) {
            List<Integer> sixLottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,LIMIT_LOTTO);
            Lotto lotto = new Lotto(sixLottoNumbers);
        }
        checkRandomLottoLists();
    }

    public void checkRandomLottoLists() {
        Iterator<List<Integer>> iterator = randomLottoLists.iterator();

        while(iterator.hasNext()) {
            List<Integer> values = iterator.next();
            System.out.println(values.stream()
                    .sorted()
                    .collect(Collectors.toList()));
        }
        output.lineSpace();
    }
}