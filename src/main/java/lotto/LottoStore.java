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

    public void setBonusNumber(int number) {
        this.bonusNumber = number;
    }

    private void validateBonusNumber(int number) {
        if (winNumbers.contains(number)) {
            System.out.println("[ERROR] 잘못된 보너스번호 입니다.");
            throw new IllegalArgumentException();
        }
    }
    private static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Can't parse to Int");
            return false;
        }
    }
}
