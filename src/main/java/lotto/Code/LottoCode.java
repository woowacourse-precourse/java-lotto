package lotto.Code;

public enum LottoCode {
    CORRECT_3("3개 일치 (5,000원) - "),
    CORRECT_4("4개 일치 (50,000원) - "),
    CORRECT_5("5개 일치 (1,500,000원) - "),
    CORRECT_5_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CORRECT_6("6개 일치 (2,000,000,000원) - ");

    private String message;

    private LottoCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}