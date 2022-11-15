package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottoBonusNumberInputException;
import lotto.exception.LottoNumberInputException;

public class LottoInputRequester {

    private LottoNumberInputException lottoNumberInputException = new LottoNumberInputException();
    private LottoBonusNumberInputException lottoBonusNumberException = new LottoBonusNumberInputException();

    public Lotto setLottoWinningNumber() {
        printLottoWinningNumberQuestion();
        String lottoWinningNumber = getLottoWinningNumber();
        lottoNumberInputException.isInputValid(lottoWinningNumber);
        Lotto lotto = new Lotto(convertStringToIntegerList(lottoWinningNumber));
        printLottoWinningBonusNumberQuestion();
        String lottoWinningBonusNumber = getLottoWinningBonusNumber();
        lottoBonusNumberException.isInputValid(lottoWinningBonusNumber);
        lotto.setBonusNumber(convertStringToInteger(lottoWinningBonusNumber));
        return lotto;
    }

    private void printLottoWinningNumberQuestion() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private String getLottoWinningNumber() {
        return Console.readLine();
    }

    private List<Integer> convertStringToIntegerList(String lottoWinningNumber) {
        String[] numbers = lottoWinningNumber.split(",");
        List<Integer> numberGroup = new ArrayList<>();
        for (String number : numbers) {
            numberGroup.add(Integer.valueOf(number));
        }

        return numberGroup;
    }

    private void printLottoWinningBonusNumberQuestion() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private String getLottoWinningBonusNumber() {
        return Console.readLine();
    }

    private Integer convertStringToInteger(String number) {
        return Integer.valueOf(number);
    }
}
