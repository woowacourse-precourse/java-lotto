package lotto.view;

public class InputView {
    final String HOW_MUCH = "구입할 금액을 입력해주세요.";
    final String INPUT_WIN_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public void printHowMuch() {
        System.out.println(HOW_MUCH);
    }

    public void printInputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS);
    }

    public void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }
}