package lotto.config;

public enum BaseLotto {

    INPUTVALUE("구입금액을 입력해 주세요."),
    PURCHASE( "개를 구매했습니다."),
    INPUTWINNING("당첨 번호를 입력해 주세요."),
    INPUTBONUS("보너스 번호를 입력해 주세요."),
    THREESUCCESS("3개 일치 (5,000원)"),
    FOURSUCCESS("4개 일치 (50,000원)"),
    FIVESUCCESS("5개 일치 (1,500,000원)"),
    FIVEANDBONUSSUCCESS("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIXSUCCESS("6개 일치 (2,000,000,000원)"),
    TOTALRETURN("총 수익률은");


    private final String description;

    public String getDescription(){
        return description;
    }

    private BaseLotto(String description){
        this.description = description;
    }
}
