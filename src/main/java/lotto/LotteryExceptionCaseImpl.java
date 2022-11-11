package lotto;

public class LotteryExceptionCaseImpl implements LotteryExceptionCase {

    @Override
    public void validateInputType(String amount) {
        for (int seq = 0; seq < amount.length(); seq++) {
            characterCheck(amount.charAt(seq));
        }
    }

    @Override
    public void characterCheck(char inputSequence) {
        try {
            if (47 >= inputSequence || 58 <= inputSequence) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 금액은 숫자로만 입력할 수 있습니다.");
        }
    }

    @Override
    public void characterCheck(String amount) {
        for (int seq = 0; seq < amount.length(); seq++) {
            if (47 >= amount.charAt(seq) || 58 <= amount.charAt(seq)) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void validateInputEmpty(String amount) {
        if (amount.equals("")) {
            System.out.println("[ERROR] 공백을 입력할 수 없습니다 금액을 입력해 주세요.");
            throw new IllegalArgumentException();
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
}