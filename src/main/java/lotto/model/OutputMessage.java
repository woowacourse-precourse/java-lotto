package lotto.model;

public enum OutputMessage {

    threeHit ("3개 일치 (5,000원) - "),
    fourHit ("4개 일치 (50,000원) - "),
    fiveHit ("5개 일치 (1,500,000원) - "),
    fiveHitAndBonus ("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    sixHit ("6개 일치 (2,000,000,000원) - "),
    hitSuffix ("개");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
