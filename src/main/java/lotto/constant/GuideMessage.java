package lotto.constant;

public enum GuideMessage {

    STARTING_GUIDE("Lotto game 에 오신 것을 환영합니다.\n" +
            "원하시는 만큼의 lotto 를 구매할 수 있으며 lotto 는 자동 발행됩니다.\n" +
            "당첨 번호와 보너스 번호를 생성하면 발행된 lotto 들의 당첨 여부를 계산합니다.\n" +
            "최종적으로 당첨 통계와 수익률을 알려드립니다.\n" +
            "게임을 시작하겠습니다."),
    PURCHASE_GUIDE("구입 금액을 입력해주세요.\n" +
            "구입 금액은 1,000원 단위로 입력이 가능합니다."),
    WINNING_NUMBERS_GUIDE("당첨 번호를 입력해 주세요.\n" +
            "당첨 번호는 1과 45 사이의 서로 다른 6개의 숫자입니다.\n" +
            "각 번호를 쉼표로 구분해서 입력해주세요."),
    BONUS_NUMBER_GUIDE("\n보너스 번호를 입력해 주세요.\n" +
            "보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자입니다.\n" +
            "하나의 보너스 번호만 입력해 주세요.");

    private final String guide;

    GuideMessage(String guide) {
        this.guide = guide;
    }

    @Override
    public String toString() {
        return guide;
    }
}
