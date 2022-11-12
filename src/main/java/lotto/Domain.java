package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Domain {

    private static List<String> rankStringMapper = Arrays.asList("FIRST", "SECOND", "THIRD", "FORTH", "FIFTH");

    public void validatePriceInput(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
        int inputPrice = Integer.parseInt(input);
        if (inputPrice % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000 단위로 입력해야 합니다.");
        }
    }

    public void validateNumberRange(String input) {
        int tempNumber = Integer.parseInt(input);
        if (tempNumber < 1 || tempNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateWinningNumberInput(String input) {
        List<String> winningNumbers = new ArrayList<>(Arrays.asList(input.split(",")));
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("여섯 개의 숫자를 ,로 구분하여 입력해야합니다.");
        }
        for (String number : winningNumbers) {
            try {
                validateNumberRange(number);
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }

    public List<Integer> trimLottoNumberInput(String lottoNumberInput) {
        List<Integer> result = new ArrayList<>();
        for (String charNumber : lottoNumberInput.split(",")) {
            result.add(Integer.parseInt(charNumber));
        }
        return result;
    }

    public Lotto createRandomLottoNumber() {
        return new Lotto(pickUniqueNumbersInRange(1, 45, 6));
    }

    public float getYield(List<Integer> rankList, int numberOfLotto) {
        float sumWinnings = 0;
        for (int i = 1; i < 6; i++) {
            sumWinnings += rankList.get(i) * getReward(i);
        }

        return sumWinnings / numberOfLotto;
    }

    public int getReward(int rank) {
        return Rank.valueOf(rankStringMapper.get(rank)).getReward();
    }

    public List<Integer> getRankList(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        List<Integer> rankList = new ArrayList<>(6);
        Collections.fill(rankList, 0);

        for (Lotto lotto : lottos) {
            int tempRank = lotto.getRank(winningNumbers, bonus);
            rankList.set(tempRank, rankList.get(tempRank) + 1);
        }

        return rankList;
    }
}
