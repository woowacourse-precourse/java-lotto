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
            ResultView.exit(new IllegalArgumentException("올바른 형태로 입력해주세요. ex) 1,2,3,4,5,6"));
            return null;
        }
    }

    static Lottos makeLottos(int lottoCount) throws IllegalArgumentException {
        String winningNumbers = InputView.receiveWinningNumbers();
        Lotto winningLotto = userIputStringToLotto(winningNumbers);
        int bonusNum = checkStringIsInt(InputView.receiveBonusNum());
        Lottos lottos = new Lottos(lottoCount, winningLotto, bonusNum);
        return lottos;
    }

    static Lottos checkAndMakeLottos(int lottoCount) {
        try {
            return makeLottos(lottoCount);
        } catch (Exception e) {
            ResultView.exit(e);
            return null;
        }
    }

    static int checkStringIsInt(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (Exception e) {
            ResultView.exit(new IllegalArgumentException("숫자를 입력해주세요."));
            return 0;
        }
    }

    public static void main(String[] args) {
        int lottoCount = amountToLottoCount(checkStringIsInt(InputView.receiveAmount()));
        Lottos lottos = checkAndMakeLottos(lottoCount);
        ResultView.printLottos(lottos);
    }
}
