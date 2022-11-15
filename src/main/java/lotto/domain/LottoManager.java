package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

/***
 * 로또의 갯수와 랜덤수를 구하는 클래스
 */
public class LottoManager {
    public LottoManager() {
    }

    public int countLotto(String inputMoney) {
        int money = isNumberic(inputMoney);
        hasRestError(money);
        MinimumAmountError(money);
        return money / 1000;
    }

    public int isNumberic(String inputMoney) {
        if (inputMoney == null || inputMoney.matches("[-+]?\\d*\\.?\\d+") == false) {
            System.out.println("[ERROR] 숫자로 입력해주세요");
            throw new NoSuchElementException("[ERROR] 숫자로 입력해주세요");
        }
        return Integer.parseInt(inputMoney);
    }

    public void hasRestError(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 나누어 떨어지지 않습니다");
        }
    }

    public void MinimumAmountError(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또를 살 수 없는 금액입니다.");
        }
    }

    public List<List<Integer>> buyerLottoNumbers(int lottoCount) {
        List<List<Integer>> randomNumbers = new ArrayList<>();
        int cnt = 0;
        while (cnt < lottoCount) {
            List<Integer> randomNumber = makeRandomNumber();
            if (isNotDuplication(randomNumber)) {
                Collections.sort(randomNumber);
                randomNumbers.add(randomNumber);
                cnt++;
            }
        }
        return randomNumbers;
    }

    public List<Integer> makeRandomNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numbers;
    }

    public boolean isNotDuplication(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            return false;
        }
        return true;
    }

}
