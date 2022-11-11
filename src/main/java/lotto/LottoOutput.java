package lotto;

public enum LottoOutput {
    FIRST_PLACE("6개 일치 (2,000,000,000원) - "),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PLACE("5개 일치 (1,500,000원) - "),
    FOURTH_PLACE("4개 일치 (50,000원) - "),
    FIFTH_PLACE("3개 일치 (5,000원) - ");

    private String outputMsg;
    private int equalNum;
    private String num = "개";

    LottoOutput(String outputMsg) {
        this.outputMsg = outputMsg;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void outputResult(String outputMsg, int equalNum, String num) {
        System.out.println(outputMsg + equalNum + num);
    }
}
