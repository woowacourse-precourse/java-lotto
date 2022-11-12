package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Domain {

    private static List<String> rankStringMapper = Arrays.asList("FIRST", "SECOND", "THIRD", "FORTH", "FIFTH");

    public boolean validatePriceInput(String input) { //함수명 변경하기
        if (!input.matches("^[0-9]+$")) {
            return false;
        }
        int inputPrice = Integer.parseInt(input);
        if (inputPrice % 1000 != 0) {
            return false;
        }
        return true;
    }

    public void validateWinningNumberInput(String input) {
        List<String> winningNumbers = new ArrayList<>(Arrays.asList(input.split(",")));
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("여섯 개의 숫자를 ,로 구분하여 입력해야합니다.");
        }
        for (String number : winningNumbers) {
            int tempNumber = Integer.parseInt(number);
            if (tempNumber < 1 || tempNumber > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
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

    public float getYield(List<Integer> ranks, int countOfLotto) {
        float sumWinnings = 0;
        for (int rank : ranks) {
            sumWinnings += getReward(rank);
        }

        return sumWinnings / countOfLotto;
    }

    public int getReward(int rank) {
        return Rank.valueOf(rankStringMapper.get(rank)).getReward();
    }
}
