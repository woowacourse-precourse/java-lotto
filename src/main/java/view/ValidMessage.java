package view;

public enum ValidMessage {
    ValidPriceNotNumber("[ERROR] 로또 구입 금액은 숫자입니다."),
    ValidPriceNotMultiple("[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야 합니다."),
    ValidEnterAnswer("[ERROR] 1-45까지의 수 중 서로 다른 6개의 수를 골라 입력하세요."),
    ValidBonusAnswer("[ERROR] 보너스 번호는 정답 수 제외 1~45 수 중 하나의 숫자를 입력해 주세요."),
    ValidGenerateLotto("[ERROR] 로또 숫자는 중복 없이 1부터 46까지의 수 중 6개를 가집니다.");

    private final String printMessage;

    ValidMessage(String message) {
        this.printMessage = message;
    }

    public String getPrintMessage() {
        return this.printMessage;
    }

}
