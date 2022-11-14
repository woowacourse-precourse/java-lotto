package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

public class InputView {
    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Money money = new Money(InputUtil.readNumber());
        System.out.println();
        return money;
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = InputUtil.readNumbersByDelimiter(",");
        System.out.println();
        return new Lotto(toLottoNumbers(numbers));
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = InputUtil.readNumber();
        System.out.println();
        return new LottoNumber(bonusNumber);
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}