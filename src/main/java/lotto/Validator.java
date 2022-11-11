package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    private int purchaseAmount;
    private int bonusNumber;
    private List<Integer> lottoNumbers;

    public void validDatePurchaseAmount(String input) {
        validDateType(input);
        int purchaseAmount = Integer.parseInt(input);
        validDateThousandUnitNumber(purchaseAmount);
        validRangeNumber(purchaseAmount);
    }

    public void validDateBonusNumber(String input) {
        validDateType(input);
        int bonusNumber = Integer.parseInt(input);
        validRangeLottoNumber(bonusNumber);
    }

    public void validDateWinningNumbers(String input) {
        List<String> lottoNumbers = List.of(input.split(","));
        validDateLottoNumberSize(lottoNumbers);
        validDateLottoNumbers(lottoNumbers);
        List<Integer> winningLottoNumbers = lottoNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        nonOverlap(winningLottoNumbers);
        System.out.println(input);
    }

    private void validDateType(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주셔야 합니다.");
        }
    }
    private void validDateThousandUnitNumber(Integer purchase) {
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 숫자를 입력하셔야 합니다.");
        }
    }
    private void validRangeNumber(Integer purchase) {
        if (! (1000 <= purchase && purchase <= 100000)) {
            throw new IllegalArgumentException("[ERROR] 로또는 최대 100,000원까지 구매하실 수 있습니다.");
        }
    }
    private void validRangeLottoNumber(Integer number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1이상 45 이하이 숫자를 입력하셔야 합니다.");
        }
    }
    private void validDateLottoNumberSize(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 총 6개의 숫자를 입력해주세요.");
        }
    }
    private void validDateLottoNumbers(List<String> numbers) {
        for (String number : numbers) {
            validDateType(number);
            validRangeLottoNumber(Integer.parseInt(number));
        }
    }

    private void nonOverlap(List<Integer> numbers) {
        List<Integer> tmp = numbers.stream().distinct().collect(Collectors.toList());
        if (tmp.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해주세요.");
        }
    }
}
