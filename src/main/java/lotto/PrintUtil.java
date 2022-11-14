package lotto;

public enum PrintUtil {
    COUNTLOTTO("개를 구매했습니다."),
    INPUTMONEY("구입금액을 입력해 주세요."),
    INPUTLOTTONUMBER("당첨 번호를 입력해 주세요."),
    INPUTBONUSNUMBER("보너스 번호를 입력해 주세요."),
    WINRESULT("당첨 통계"),
    DIVISION("---"),
    THREEWIN("3개 일치 (5,000원) - "),
    FOURWIN("4개 일치 (50,000원) - "),
    FIVEWIN("5개 일치 (1,500,000원) - "),
    BONUSWIN("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIXWIN("6개 일치 (2,000,000,000원) - "),
    COUNT("개"),
    RESULTRETURN("총 수익률은 "),
    ISPERCENT("%입니다.");

    private final String massages;

    PrintUtil(String massage) {
        this.massages = massage;
    }

    public String getMassages() {
        return massages;
    }
}