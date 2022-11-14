package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {

    private final int LOTTO_SIZE = 6;
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;
    private static List<Integer> winningList;

    private LottoGroups lottoGroups;
    private WinningLotto winningLotto;
    private int count;

    public LottoMachine(int count) {
        this.count = count;
        lottoGroups = new LottoGroups(createLottos(count));
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        IntStream.range(0, count)
                .forEach((w) -> lottos.add(createRandomNumbers()));
        return lottos;
    }

    public void saveWinningNumber(List<Integer> numbers, int bonusNumber) {
        if (checkDuplication(numbers, bonusNumber) == false) {
            throw new IllegalArgumentException();
        }
        winningLotto = new WinningLotto(new Lotto(numbers), bonusNumber);
    }

    private Lotto createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public static boolean checkDuplication(List<Integer> numbers, int number) {
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
        winningList = IntStream.of(new int[8])
                .boxed()
                .collect(Collectors.toList());
        lottoGroups.getLottos().forEach(lotto -> {
            int winningCount = getWinningCount(lotto);
            winningList.set(winningCount, winningList.get(winningCount) + 1);
        });
        return winningList;
    }

    private int getWinningCount(Lotto lotto) {
        int winningCount = lotto.getNumbers().stream()
                .filter(this::checkWinningNumber)
                .collect(Collectors.toList())
                .size();
        if (winningCount == 5 && lotto.getNumbers().contains(winningLotto.getBonusNumber())) {
            return winningCount + 1;
        }
        if (winningCount == 6) {
            return winningCount + 2;
        }
        return winningCount;
    }

    private boolean checkWinningNumber(int number) {
        if (winningLotto.getWinningNumbers().getNumbers().contains(number)) {
            return true;
        }
        return false;
    }

    public double getYield() {
        int moneyAll = 0;
        for (int i = 0; i <= 7; i++) {
            moneyAll += Rank.findMoney(i).getMoney(winningList.get(i));
        }
        return (double) moneyAll / (1000.0 * (double) count / 100.0);
    }

}
