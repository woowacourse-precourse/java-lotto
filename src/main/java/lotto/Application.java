package lotto;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static int amountToLottoCount(int userInput) {
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


    static Integer checkStringAndPalseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            IllegalArgumentException err = new IllegalArgumentException("올바른 형태로 입력해주세요. ex) 1,2,3,4,5,6");
            ResultView.exit(err);
            return null;
        }
    }

    static Lottos makeLottos(int lottoCount) throws IllegalArgumentException {
        String winningNumbers = InputView.receiveWinningNumbers();
        Lotto winningLotto = userIputStringToLotto(winningNumbers);
        int bonusNum = InputView.receiveBonusNum();
        Lottos lottos = new Lottos(lottoCount, winningLotto, bonusNum);
        return lottos;
    }

    static void checkLottoValidation(int lottoCount) {
        try {
            makeLottos(lottoCount);
        } catch (Exception e) {
            ResultView.exit(e);
        }
    }

    public static void main(String[] args) {
        int lottoCount = amountToLottoCount(InputView.receiveAmount());
        Lottos lottos = makeLottos(lottoCount);
        ResultView.printLottos(lottos);
    }
}
