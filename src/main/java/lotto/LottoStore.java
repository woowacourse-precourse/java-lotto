package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {
    private List<Integer> winNumbers;
    private int bonusNumber;

    private Lotto getNewLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return new Lotto(sortedNumbers);
    }

    public List<Lotto> sellLottos(int money) {
        int affordLottos = money / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<affordLottos; i++) {
            lottos.add(getNewLotto());
        }

        return lottos;
    }

    public void setWinNumbers(String input) {
        System.out.println("당첨 번호를 입력해 주세요.\n" + input + "\n");

        List<Integer> numbers = c4fiberParser.getIntegerListFromString(input);
        validateWinNumbers(numbers);
        this.winNumbers = numbers;
    }

    private void validateWinNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 잘못된 당첨번호 입니다.");
            throw new IllegalArgumentException();
        }
    }

    public void setBonusNumber(String input) {
        System.out.println("보너스 번호를 입력해 주세요.\n" + input + "\n");

        Integer number = c4fiberParser.getIntegerFromString(input);
        validateBonusNumber(number);
        this.bonusNumber = number;
    }

    private void validateBonusNumber(int number) {
        if (winNumbers.contains(number)) {
            System.out.println("[ERROR] 잘못된 보너스번호 입니다.");
            throw new IllegalArgumentException();
        }
    }

    private int getCorrectNumbersOfLotto(Lotto lotto) {
        int correct = 0;
        for(int num : lotto.getNumbers()) {
            if (winNumbers.contains(num) || bonusNumber == num)
                correct++;
        }

        return correct;
    }

    public LottoReward calcLottoReward(Lotto lotto) {
        int correct = getCorrectNumbersOfLotto(lotto);

        if (correct == 3) { return LottoReward.fifth; }
        if (correct == 4) { return LottoReward.fourth; }
        if (correct == 5) { return LottoReward.third; }
        if (correct == 6) {
            if (lotto.getNumbers().contains(bonusNumber)) {
                return LottoReward.second;
            }else {
                return LottoReward.first;
            }
        }

        return LottoReward.zero;
    }

}
