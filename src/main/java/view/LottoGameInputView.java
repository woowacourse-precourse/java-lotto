package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameInputView implements InputView {

    static class Singleton {

        private static final InputView INSTANCE = new LottoGameInputView();
    }

    private LottoGameInputView() {
    }

    public static InputView getInstance() {
        return Singleton.INSTANCE;
    }

    @Override
    public List<Integer> getWinningNumbersFromUser() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return getNumbersFromUser(",");
    }

    @Override
    public int getBonusNumberFromUser() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getNumberFromUser();
    }

    @Override
    public int getBillFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return getNumberFromUser();
    }

    private List<Integer> getNumbersFromUser(String parser) {
        try {
            String line = Console.readLine();
            String pattern = "[0-9]+(" + parser + "[0-9]+)*";

            if (!validateFitInPattern(line, pattern)) {
                throw new Exception();
            }

            return Arrays.stream(line.split(parser)).map((string) -> Integer.parseInt(string))
                    .collect(Collectors.toUnmodifiableList());

        } catch (Exception e) {
            throw new IllegalArgumentException("형식에 알맞지 않은 입력입니다. 입력은 숫자[,숫자] 형태로 주어져야 합니다.");
        }
    }


    private int getNumberFromUser() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("형식에 알맞지 않은 입력입니다. 입력은 숫자로 주어져야 합니다.");
        }
    }

    private boolean validateFitInPattern(String string, String patternString) {
        return string.matches(patternString);
    }
}
