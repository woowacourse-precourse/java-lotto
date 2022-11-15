package lotto.domain;

public class BonusNumber {
    private int number;

    public BonusNumber(String number) {
        this.number = isValid(number);
    }

    public int isValid(String input) {
        int number = isNum(input);
        isValidRange(number);
        return number;
    }

    public int isNum(String input) {
        for (char c : input.toCharArray()) {
            if (!(Character.isDigit(c))) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
            }
        }
        return Integer.parseInt(input);
    }

    public void isValidRange(int number) {
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45의 숫자만 입력할 수 있습니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
