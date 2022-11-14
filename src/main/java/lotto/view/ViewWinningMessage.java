package lotto.view;

public enum ViewWinningMessage {
    FIFTH_PLACE_QUANTITY("3개 일치 (5,000원) - "),
    FOURTH_PLACE_QUANTITY("4개 일치 (50,000원) - "),
    THIRD_PLACE_QUANTITY("5개 일치 (1,500,000원) - "),
    SECOND_PLACE_QUANTITY("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE_QUANTITY("6개 일치 (2,000,000,000원) - ");
    private String message;

    ViewWinningMessage(String message) {
        this.message = message;
    }

    public String getMessage(int quantity) {
        return message + quantity + "개";
    }
}
