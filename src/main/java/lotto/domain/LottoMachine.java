package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private final int LOTTO_SIZE = 6;
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;

    private LottoGroups lottoGroups;
    private WinningLotto winningLotto;
    private int count;

    public LottoMachine(int count) {
        lottoGroups = new LottoGroups(createLottos(count));
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        IntStream.range(0, count)
                .forEach((w) -> lottos.add(createRandomNumbers()));
        return lottos;
    }

    public void saveWinningNumber(List<Integer> numbers, int bonusNumber) {

    }

    private Lotto createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < LOTTO_SIZE) {
            int number = Randoms.pickNumberInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
            if (checkDuplication(numbers, number)) {
                numbers.add(number);
            }
        }
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private boolean checkDuplication(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            return false;
        }
        return true;
    }

    public List<List<Integer>> getLottosNumberList() {
        List<Lotto> lottos = lottoGroups.getLottos();
        List<List<Integer>> lottosNumbers = new ArrayList<>();
        lottos.stream()
                .forEach((lotto) -> {
                    lottosNumbers.add(lotto.getNumbers());
                });
        return lottosNumbers;
    }

    public List<Integer> getWinningList() {

        return List.of(1, 2, 3, 4, 5);
    }

    private boolean checkWinningNumber() {
        return true;
    }

    public double getYield() {
        return 1.0;
    }

}
