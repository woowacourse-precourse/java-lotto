package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int SIZE = 6;

    public List<Lotto> issueLottos(int lottoNum) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            addLotto(lottos);
        }
        return lottos;
    }

    private void addLotto(List<Lotto> lottos) {
        List<Integer> numbers = getRandomNumbers();
        lottos.add(new Lotto(numbers));
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, SIZE);
        return sortNumbers(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
        return numbers;
    }

    public int[] determineWinners(User user, Lotto winningLotto, Bonus bonus) {
        int[] rank = new int[6];
        List<Integer> winningNumbers = winningLotto.getNumbers();
        for (Lotto lotto : user.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int hits = countHits(lottoNumbers, winningNumbers, bonus);
            determineRank(lottoNumbers, hits, bonus, rank);
        }
        return rank;
    }

    private int countHits(List<Integer> lottoNumbers, List<Integer> winningNumbers, Bonus bonus) {
        lottoNumbers.removeAll(winningNumbers);
        return SIZE - lottoNumbers.size();
    }

    private void determineRank(List<Integer> lottoNumbers, int hits, Bonus bonus, int[] rank) {
        if (hits == 6) {
            rank[1]++;
        } else if (hits == 5 && lottoNumbers.get(0) == bonus.getBonus()) {
            rank[2]++;
        } else if (hits == 5) {
            rank[3]++;
        } else if (hits == 4) {
            rank[4]++;
        } else if (hits == 3) {
            rank[5]++;
        }
    }

}
