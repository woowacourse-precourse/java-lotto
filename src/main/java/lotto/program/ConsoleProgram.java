package lotto.program;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoOfAnswer;
import lotto.utils.Converter;
import lotto.utils.Validator;

public class ConsoleProgram {

    public int requestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoneyInput = Console.readLine();
        validateMoney(rawMoneyInput);
        return Integer.parseInt(rawMoneyInput);
    }

    private void validateMoney(String rawMoneyInput) {
        Validator.checkNumber(rawMoneyInput);
        Validator.checkMoney(rawMoneyInput);
    }

    public LottoOfAnswer requestAnswerLottoWithBonusNumber() {
        String rawAnswerInput = requestAnswerLotto();
        String rawBonusInput = requestBonusNumber();

        return new LottoOfAnswer
                (Converter.stringToList(rawAnswerInput), Converter.stringToNumber(rawBonusInput));
    }


    private String requestAnswerLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String rawAnswerInput = Console.readLine();
        validateAnswer(rawAnswerInput);
        return rawAnswerInput;
    }

    private void validateAnswer(String rawAnswerInput) {
        Validator.checkLottoFormat(rawAnswerInput);
        Validator.checkDuplicate(rawAnswerInput);
    }

    private String requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String rawBonusInput = Console.readLine();
        validateBonus(rawBonusInput);
        return rawBonusInput;
    }

    private void validateBonus(String rawBonusInput) {
        Validator.checkNumber(rawBonusInput);
        Validator.checkBonusNumber(rawBonusInput);
    }
}
