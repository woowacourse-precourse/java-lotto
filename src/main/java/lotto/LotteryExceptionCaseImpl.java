package lotto;

public class LotteryExceptionCaseImpl implements LotteryExceptionCase {

    @Override
    public void characterCheck(char sequence) {
        if (47 >= sequence || 58 <= sequence) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void validateInputType(String amount) {
        for (int seq = 0; seq < amount.length(); seq++) {
            validateCharacter(amount.charAt(seq));
        }
    }

    @Override
    public void validateCharacter(char inputSequence) {
        try {
            characterCheck(inputSequence);
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 금액은 숫자로만 입력할 수 있습니다.");
        }
    }

    @Override
    public void validateInputEmpty(String amount) {
        try {
            if (amount.equals("")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 공백을 입력할 수 없습니다 금액을 입력해 주세요.");
        }
    }

    @Override
    public void validateAmount(int amount) {
        try {
            if (amount % 1000 != 0 || amount == 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 입력하신 금액을 다시 확인해 주세요.");
        }
    }

    @Override
    public int convertStringToInteger(String amount) {
        int convert = 0;

        try {
            convert = Integer.parseInt(amount);
        } catch (NumberFormatException ignore) {
        }

        return convert;
    }

    @Override
    public void validateCharacter(String amount) {
        for (int seq = 0; seq < amount.length(); seq++) {
            characterCheck(amount.charAt(seq));
        }
    }

    @Override
    public void amountInputEmptyCheck(String amount) {
        if (amount.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void validateAmountForEarnings(int amount) {
        if (amount % 1000 != 0 || amount == 0) {
            throw new IllegalArgumentException();
        }
    }
}