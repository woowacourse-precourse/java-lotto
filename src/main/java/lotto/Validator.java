package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    private static List<Integer> winningNumbers;

    public int validDatePurchaseAmount(int purchaseAmount) {
        validDateThousandUnitNumber(purchaseAmount);
        validRangeNumber(purchaseAmount);
        return purchaseAmount;
    }

    public int validDateBonusNumber(int bonusNumber) {
        validRangeLottoNumber(bonusNumber);
        nonOverlapWithLottoNumbers(bonusNumber);
        return bonusNumber;
    }

    public List<Integer> validDateWinningNumbers(List<Integer> lottoNumbers) {
        validDateLottoNumberSize(lottoNumbers);
        validDateLottoNumbers(lottoNumbers);
        nonOverlap(lottoNumbers);
        winningNumbers = lottoNumbers;
        return lottoNumbers;
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
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1이상 45 이하의 숫자를 입력하셔야 합니다.");
        }
    }
    private void nonOverlapWithLottoNumbers(Integer number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validDateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 총 6개의 숫자를 입력해주세요.");
        }
    }
    private void validDateLottoNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validRangeLottoNumber(number);
        }
    }

    private void nonOverlap(List<Integer> numbers) {
        List<Integer> tmp = numbers.stream().distinct().collect(Collectors.toList());
        if (tmp.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해주세요.");
        }
    }
}