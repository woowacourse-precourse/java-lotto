package lotto.domain;

public class LottoDraw {
    private Lotto winningNumbers;
    private Integer bonusNumber;

    private Integer stringToInteger(String s) {
        Integer number = null;
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 각 로또 번호는 숫자이어야 합니다.");
        }
        return number;
    }
}