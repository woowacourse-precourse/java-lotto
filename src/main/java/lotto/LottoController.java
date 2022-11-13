package lotto;

public class LottoController {
    public void play() {

    }

    private void buyLotto() {

    }

    private void setAnswer() {

    }

    private void getResult() {

    }

    private void validateAnswerInput(String input) {
        try {
            for (String str : input.split(",")) {
                Integer.parseInt(str);
            }
        } catch (Exception err) {
            throw new IllegalArgumentException("콤마(,)를 이용해 6개의 숫자를 입력해주세요.");
        }
    }

    private void validateNumber(String input) {
        if (!input.matches("^[0-9]*$")) throw new IllegalArgumentException("숫자만 입력하실 수 있습니다.");
    }
}
