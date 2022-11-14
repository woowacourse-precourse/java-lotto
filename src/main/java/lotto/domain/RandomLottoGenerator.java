package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.SystemConsole;

public class RandomLottoGenerator {
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final int LOTTO_SIZE_NUM = 6;

    public List<List<Integer>> createTicket(int ticketsCount, SystemConsole systemConsole) {
        List<List<Integer>> randomLotto = new ArrayList<>();

        for (int ticket = 0; ticket < ticketsCount; ticket++) {
            randomLotto.add(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUM, LOTTO_END_NUM, LOTTO_SIZE_NUM));
        }

        lottoTheorem(randomLotto);
        consoleOutput(randomLotto);

        return randomLotto;
    }

    private void consoleOutput(List<List<Integer>> randomLotto) {
        for (List<Integer> lottoTickets : randomLotto) {
            System.out.println(lottoTickets);
        }
    }

    public void lottoTheorem(List<List<Integer>> randomLotto) {
        for (List<Integer> randomNumber : randomLotto) {
            randomNumber.stream().sorted().collect(Collectors.toList());
        }
    }
}