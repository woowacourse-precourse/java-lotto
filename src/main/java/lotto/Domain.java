package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Domain {

    public static List<String> rankStringMapper = Arrays.asList("", "FIRST", "SECOND", "THIRD", "FORTH", "FIFTH");

    public void validatePriceInput(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
        int inputPrice = Integer.parseInt(input);
        if (inputPrice % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000 단위로 입력해야 합니다.");
        }
    }

    static public void validateNumberRange(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
        int tempNumber = Integer.parseInt(input);
        if (tempNumber < 1 || tempNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    static public void validateNumberRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    static public void validateOverlapping(List<?> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j <input.size(); j++) {
                if (input.get(i).equals(input.get(j))) {
                    throw new IllegalArgumentException("중복된 숫자 없이 입력해야 합니다.");
                }
            }
        }
    }

    public void validateWinningNumberInput(String input) {
        List<String> winningNumbers = new ArrayList<>(Arrays.asList(input.split(",")));
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("여섯 개의 숫자를 ,로 구분하여 입력해야 합니다.");
        }
        validateOverlapping(winningNumbers);
        for (String number : winningNumbers) {
            validateNumberRange(number);
        }
    }

    public List<Integer> trimLottoNumberInput(String lottoNumberInput) {
        List<Integer> result = new ArrayList<>();
        for (String charNumber : lottoNumberInput.split(",")) {
            result.add(Integer.parseInt(charNumber));
        }
        return result;
    }

    public List<Lotto> createRandomLottoNumbers(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public String getYield(List<Integer> rankList, int numberOfLotto) {
        float sumWinnings = 0;
        for (int i = 1; i < 6; i++) {
            sumWinnings += rankList.get(i) * getReward(i);
        }

        return String.format("%.1f", sumWinnings / (numberOfLotto * 10));
    }

    public int getReward(int rank) {
        return Rank.valueOf(rankStringMapper.get(rank)).getReward();
    }

    public List<Integer> getRankList(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        List<Integer> rankList = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        for (Lotto lotto : lottos) {
            int tempRank = lotto.getRank(winningNumbers, bonus);
            if (tempRank > 5) continue;

            rankList.set(tempRank, rankList.get(tempRank) + 1);
        }

        return rankList;
    }
}
