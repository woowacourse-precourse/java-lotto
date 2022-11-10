package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.WinningLotto;

public class LottoService {
    private static final Pattern moneyPattern = Pattern.compile("^[1-9]\\d*$");
    private static final Pattern lottoPattern = Pattern.compile("^([1-9]\\d?,){5}[1-9]\\d?$");
    private static final Pattern bonusNumberPattern = Pattern.compile("^[1-9]\\d?$");

    public Money convertInputToMoney(String input) {
        if (!moneyPattern.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        return Money.of(Long.parseLong(input));
    }

    public WinningLotto convertInputToWinningLotto(String numbersInput, String numberInput) {
        if (!lottoPattern.matcher(numbersInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바른 로또 번호가 아닙니다.");
        }
        List<Integer> numbers = Arrays.stream(numbersInput.split(","))
                .sequential()
                .map(Integer::parseInt)
                .peek(LottoService::validateLottoNumber)
                .distinct()
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(numbers);
        Integer bonusNumber = convertInputToBonusNumber(numberInput);
        return new WinningLotto(lotto, bonusNumber);
    }

    private static void validateLottoNumber(Integer number) {
        if (number >= 1 && number <= 45) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 올바른 로또 번호가 아닙니다.");
    }

    private Integer convertInputToBonusNumber(String bonusNumber) {
        if (!bonusNumberPattern.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바른 로또 번호가 아닙니다.");
        }
        int number = Integer.parseInt(bonusNumber);
        validateLottoNumber(number);
        return number;
    }

    public List<Lotto> buyLotto(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        long lottoCount = money.getValue() / 1000;

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Integer::compareTo);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public LottoGrade winningConfirm(WinningLotto winningLotto, Lotto lotto) {
        boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        int matchCount = 0;
        List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return LottoGrade.confirmWinning(matchCount, bonusMatch);
    }
}
