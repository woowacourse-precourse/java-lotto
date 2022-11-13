package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

public class InputView {
    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Money money = new Money(toNumber(Console.readLine()));
        System.out.println();
        return money;
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String line = Console.readLine();
        System.out.println();
        return new Lotto(toLottoNumbers(toNumbers(line.split(","))));
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = toNumber(Console.readLine());
        System.out.println();
        return new LottoNumber(bonusNumber);
    }

    private static int toNumber(String line) {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 입력되었습니다.");
        }
    }

    private static List<Integer> toNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(InputView::toNumber)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
