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
    private ArrayList<List<Integer>> userLottoNumbers;
    private List<Integer> lottoWinNumbers;
    private Integer bonusWinNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        bonusNumber = BonusNumber();
        userAmount = UserAmount();
        userLottoNumbers = UserLottoNumbers(userAmount);
        UserLottoNumbersResult(userAmount, userLottoNumbers);
        lottoWinNumbers = LottoWinNumbers();
        bonusWinNumber = BonusWinNumber();
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
        userLottoNumbers = new ArrayList<>();
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

    private List<Integer> LottoWinNumbers() {
        System.out.println();
        System.out.println("당첨번호를 입력해 주세요.");
        String lottoWinNumbersInput = Console.readLine();
        lottoWinNumbers = Arrays.stream(lottoWinNumbersInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return lottoWinNumbers;
    }

    private Integer BonusWinNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusWinNumber = Integer.parseInt(Console.readLine());
        return bonusWinNumber;
    }
}
