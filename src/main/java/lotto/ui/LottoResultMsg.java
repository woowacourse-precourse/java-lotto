package lotto.ui;

public enum LottoResultMsg {
    FIFTH("3개 일치 (5,000원) - "),
    FOURTH("4개 일치 (50,000원) - "),
    THIRD("5개 일치 (1,500,000원) - "),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST("6개 일치 (2,000,000,000원) - ");
    
    private final String str;
    
    LottoResultMsg(String str){
        this.str = str;
    }
    
    public static LottoResultMsg findByOrdinal(int n) {
        LottoResultMsg[] lottoResultMsgs = LottoResultMsg.values();
        LottoResultMsg lottoResultMsg = null;
        for(LottoResultMsg msg : lottoResultMsgs) {
            if(msg.ordinal() == n) {
                lottoResultMsg = msg;
            }
        }
        return lottoResultMsg;
    }
    
    public String getStr() {
        return this.str;
    }
}
