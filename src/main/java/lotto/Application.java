package lotto;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {
    static int amountToLottoCount(int userInput) throws IllegalArgumentException {
        Amount amount = new Amount(userInput);
        if (!amount.isValidateAmount()) {
            exit(new IllegalArgumentException("1,000원 단위로 입력해주세요."));
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
            exit(new IllegalArgumentException("올바른 형태로 입력해주세요. ex) 1,2,3,4,5,6"));
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

    static Lottos checkAndMakeLottos(int lottoCount) throws IllegalArgumentException {
        try {
            return makeLottos(lottoCount);
        } catch (Exception e) {
            exit(e);
            return null;
        }
    }

    static int checkStringIsInt(String inputString) throws IllegalArgumentException {
        try {
            return Integer.parseInt(inputString);
        } catch (Exception e) {
            exit(new IllegalArgumentException("숫자를 입력해주세요."));
            return 0;
        }
    }

    static float calcYield(Lottos lottos, int lottoCount) {
        return  (lottos.getTotalWinningAmount() / (lottoCount*1000)) * 100;
    }

    public static void exit(Throwable error) throws IllegalArgumentException {
        String errMessage = "[ERROR] " + error.getMessage();
        throw new IllegalArgumentException(errMessage);
    }

    static void run() {
        int lottoCount = amountToLottoCount(checkStringIsInt(InputView.receiveAmount()));
        Lottos lottos = checkAndMakeLottos(lottoCount);
        ResultView.printLottos(lottos);
        ResultView.printResult(lottos.getLottoResults());
        ResultView.printYield(calcYield(lottos, lottoCount));
    }

    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            ResultView.printErr(e);
        }
    }
}
