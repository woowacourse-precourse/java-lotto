package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PickRandomLottoLists {
    public final int LIMIT_LOTTO = 6;
    public static List<List<Integer>> randomLottoLists = new ArrayList<>();

    public void pickRandomLottoNumbers(int lottoPapers) {
        while(randomLottoLists.size() != lottoPapers) {
            List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,LIMIT_LOTTO);
            Lotto lotto = new Lotto(randomLottoNumbers);
        }
        printRandomLottoLists();
    }

    private void printRandomLottoLists() {
        Output output = new Output();

        for (List<Integer> values : randomLottoLists) {
            System.out.println(values.stream().sorted().collect(Collectors.toList()));
        }
        output.lineSpace();
    }
}