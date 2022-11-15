package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private Integer bonusNumber;
    private Integer userAmount;
    private final ArrayList<List<Integer>> userLottoNumbers;
    private String lottoWinNumbersInput;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        bonusNumber = BonusNumber();
        userAmount = UserAmount();
        userLottoNumbers = UserLottoNumbers(userAmount);
        UserLottoNumbersResult(userAmount, userLottoNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private Integer BonusNumber() {
        bonusNumber = Randoms.pickNumberInRange(1, 45);
        while (numbers.contains(bonusNumber)) {
            bonusNumber = Randoms.pickNumberInRange(1, 45);
        }
        return bonusNumber;
    }

    private Integer UserAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        userAmount = Integer.parseInt(Console.readLine());
        return userAmount;
    }

    private ArrayList<List<Integer>> UserLottoNumbers(Integer userAmount) {
        ArrayList<List<Integer>> userLottoNumbers = new ArrayList<>();
        for (int i = 0; i < userAmount/1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottoNumbers.add(numbers);
        }
        return userLottoNumbers;
    }

    private void UserLottoNumbersResult(Integer userAmount, ArrayList<List<Integer>> userLottoNumbers) {
        System.out.println();
        System.out.println(userAmount/1000 + "개를 구매했습니다.");
        for (List<Integer> userLottoNumber : userLottoNumbers) {
            System.out.println(userLottoNumber);
        }
    }
}
