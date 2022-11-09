package lotto;

public class BuyLotto {
    public int buyLotto(String userInput) {
        checkInputType(userInput);
        return checkAmount(userInput);
    }
    private int checkAmount(String userInput) {
        int money = Integer.parseInt(userInput);
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }
    private void checkInputType(String userInput) {
        for (int seq = 0; seq < userInput.length(); seq++) {
            checkCharacter(userInput.charAt(seq));
        }
    }
    private void checkCharacter(char inputSequence) {
        if (47 >= inputSequence || 58 <= inputSequence) {
            System.out.println("[ERROR] 금액은 숫자로만 입력할 수 있습니다.");
            throw new IllegalArgumentException();
        }
    }
}
