package lotto.constants;

public enum GuideSentences {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_NUMBER_OF_PURCHASES("개를 구매했습니다."),
    OUTPUT_WINNING_STATISTICS("당첨 통계\n" + "---");

    private final String sentence;

    GuideSentences(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return this.sentence;
    }

}
