package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.strategy.CreateStrategy;
import lotto.exception.InputException;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GameFrame {
    private static final Pattern NUMBER = Pattern.compile("^[0-9]+$");

    public void start(LottoGame lottoGame, CreateStrategy createStrategy) {
        InputView.startGuide();
        String input = InputView.inputMoney();

        if (!numberOrNot(input)) {
            return;
        }

        lottoGame.createLottery(money(input), createStrategy);
        ResultView.printLottery(lottoGame.lotteryResult());
        List<String> tempWinning = InputView.inputWinningNumbers();

        if (!isWinningNumber(tempWinning)) {
            return;
        }

        String tempBonus = InputView.inputBonus();

        if (!checkBonus(tempBonus)) {
            return;
        }

        ResultView.printStatistics(lottoGame.rankResult(WinningLotto(tempWinning, tempBonus)));
    }

    private WinningLotto WinningLotto(List<String> tempWinning, String tempBonus) {
        return new WinningLotto(lottoNumber(tempWinning), bonusNumber(tempBonus));
    }

    private LottoNumber bonusNumber(String bonus) {
        return LottoNumber.lottoNumber(convertInt(bonus));
    }

    private List<LottoNumber> lottoNumber(List<String> tempWinning) {
        return tempWinning.stream().map(this::convertInt).map(LottoNumber::lottoNumber).collect(Collectors.toList());
    }

    private Money money(String input) {
        return new Money(convertInt(input));
    }

    private int convertInt(String input) {
        return Integer.parseInt(input);
    }

    private boolean numberOrNot(String money) {
        try {
            return checkNumber(money);
        } catch (InputException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean isWinningNumber(List<String> tempWinning) {
        try {
            return checkWinningNumber(tempWinning);
        } catch (InputException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean checkBonus(String bonus) {
        try {
            isBonusRange(bonus);
            isBlank(bonus);
            return true;
        } catch (InputException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean checkNumber(String money) {
        if (!NUMBER.matcher(money).matches()) {
            throw new InputException("[ERROR] 숫자가 아닌 문자를 입력했습니다.");
        }
        return true;
    }

    private static boolean checkWinningNumber(List<String> tempWinning) {
        if (tempWinning.size() > 6) {
            throw new InputException("[ERROR] 6개 이상의 숫자를 입력했습니다.");
        }
        if (tempWinning.stream().anyMatch(String::isBlank)) {
            throw new InputException("[ERROR] 공백은 입력할 수 없습니다.");
        }
        if (tempWinning.stream().anyMatch(s -> Integer.parseInt(s) < LottoNumber.MIN)) {
            throw new InputException("[ERROR] 1보다 작은 수는 입력할 수 없습니다.");
        }
        if (tempWinning.stream().anyMatch(s -> Integer.parseInt(s) > LottoNumber.MAX)) {
            throw new InputException("[ERROR] 45보다 큰 수는 입력할 수 없습니다.");
        }
        return true;
    }

    private static void isBlank(String bonus) {
        if (bonus.isBlank()) {
            throw new InputException("[ERROR] 공백은 입력할 수 없습니다.");
        }

    }

    private static void isBonusRange(String bonus) {
        if (Integer.parseInt(bonus) > LottoNumber.MAX || Integer.parseInt(bonus) < LottoNumber.MIN) {
            throw new InputException("[ERROR] 입력 숫자가 로또의 숫자의 범위를 넘었습니다.");
        }

    }
}
