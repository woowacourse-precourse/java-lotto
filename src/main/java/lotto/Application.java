package lotto;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static int amountToLottoCount(int userInput) throws IllegalArgumentException {
        Amount amount = new Amount(userInput);
        if (!amount.isValidateAmount()) {
            ResultView.exit(new IllegalArgumentException("1,000원 단위로 입력해주세요."));
        }
        return amount.getLottoCount();
    }

    static Lotto userIputStringToLotto(String string) {
        Lotto lotto = new Lotto(Arrays.asList(string.split(","))
                .stream()
                .map(s -> checkStringAndPalseInt(s))
                .collect(Collectors.toList()));
        return lotto;
    }


    static Integer checkStringAndPalseInt(String string) throws IllegalArgumentException {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            ResultView.exit(e);
            return null;
        }
    }

    public static void main(String[] args) {
        int lottoCount = amountToLottoCount(InputView.receiveAmount());
        String winningNumbers = InputView.receiveWinningNumbers();
        Lotto winningLotto = userIputStringToLotto(winningNumbers);
        int bonusNum = InputView.receiveBonusNum();
        Lottos lottos = new Lottos(lottoCount, winningLotto, bonusNum);
    }
}
