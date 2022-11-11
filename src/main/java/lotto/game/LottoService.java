package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<LottoGrade> confirmAllLottos(WinningLotto winningLotto, List<Lotto> lottos) {
        List<LottoGrade> winnings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoGrade lottoGrade = winningConfirm(winningLotto, lotto);
            if (lottoGrade != LottoGrade.NOTHING) {
                winnings.add(lottoGrade);
            }
        }
        return winnings;
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

    public Map<LottoGrade, Integer> getTotalWinning(List<LottoGrade> grades) {
        Map<LottoGrade, Integer> totalWinnings = new HashMap<>();
        for (LottoGrade grade : grades) {
            addWinning(totalWinnings, grade);
        }
        return totalWinnings;
    }

    private void addWinning(Map<LottoGrade, Integer> totalWinnings, LottoGrade grade) {
        if (totalWinnings.containsKey(grade)) {
            totalWinnings.put(grade, totalWinnings.get(grade) + 1);
            return;
        }
        totalWinnings.put(grade, 1);
    }

    public double calculateProfitPercent(Money money, List<LottoGrade> totalWinnings) {
        Money profit = calculateTotalProfit(totalWinnings);
        return (double) profit.getValue() / money.getValue() * 100;
    }

    private Money calculateTotalProfit(List<LottoGrade> totalWinnings) {
        return totalWinnings.stream()
                .map(grade -> Money.of(grade.getPrize()))
                .reduce(Money::add)
                .orElse(Money.of(0));
    }
}
