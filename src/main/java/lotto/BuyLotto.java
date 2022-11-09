package lotto;

public class BuyLotto {
    public int getLottoPieces(String userInput) {
        validateInputType(userInput);
        validateFirstSequence(userInput);
        int money = validateAmount(userInput);
        return money / 1000;
    }
    private void validateInputType(String userInput) {
        for (int seq = 0; seq < userInput.length(); seq++) {
            validateCharacter(userInput.charAt(seq));
        }
    }
    private void validateCharacter(char inputSequence) {
        if (47 >= inputSequence || 58 <= inputSequence) {
            System.out.println("[ERROR] 금액은 숫자로만 입력할 수 있습니다.");
            throw new IllegalArgumentException();
        }
    }
    private void validateFirstSequence(String userInput) {
        if (userInput.charAt(0) == 48) {
            System.out.println("[ERROR] 입력 하시는 금액은 0부터 시작할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
    private int validateAmount(String userInput) {
        int money = Integer.parseInt(userInput);
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        return money;
    }
}