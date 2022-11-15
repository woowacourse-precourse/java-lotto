package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    private final List<Integer> winningNumbers = new ArrayList<>();

    // 구매할 금액 계산
    public int getPurchaseAmount() {
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine());
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(ExceptionCode.INPUT_INVALID.getMessage());
            }
            return purchaseAmount / 1000;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionCode.INPUT_ERROR.getMessage());
        }
    }

    // 구입 금액에 해당하는 만큼 로또를 구매한다.
    public List<List<Integer>> LottoList(int purchaseNum) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < purchaseNum; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lottoValidate = new Lotto(lotto);
            System.out.println(lotto);
            lottoNumbers.add(lotto);
        }
        System.out.println();
        return lottoNumbers;
    }

    // 당첨 번호를 입력받는다.
    public List<Integer> getWinningNumber() {
        String input = Console.readLine();

        if (!input.contains(",")) {
            throw new IllegalArgumentException(ExceptionCode.WINNING_ERROR.getMessage());
        }
        for (String number : input.split(",")) {
            winningNumbers.add(Integer.valueOf(number));
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionCode.LENGTH_ERROR.getMessage());
        }

        return winningNumbers;
    }

    public int getBonusInput() {
        int bonusNumber = Integer.parseInt(Console.readLine());

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ExceptionCode.NUMBER_RANGE.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionCode.DUPLICATION_ERROR.getMessage());
        }

        return bonusNumber;
    }

    public Integer[] calculatorWinner(List<List<Integer>> lottoNumbers, List<Integer> winningNumber, int bonusNumber) {
        Integer[] winStatistics = { 0,0,0,0,0 };
        for (List<Integer> lottoNumber : lottoNumbers) {
            int grade = correctNumber(lottoNumber, winningNumber);
            if (grade >= 3) {
                winStatistics[grade-3]++;
            }
            if (grade == 5 && lottoNumber.contains(bonusNumber)) {
                winStatistics[grade-3]--;
                winStatistics[grade-2]++;
            }
        }
        return winStatistics;
    }
    private int correctNumber(List<Integer> lottoNumber, List<Integer> winningNumber) {
        int grade = 0;
        for (Integer winNumber : winningNumber) {
            if (lottoNumber.contains(winNumber)) {
                grade++;
            }
        }
        return grade;
    }
}
