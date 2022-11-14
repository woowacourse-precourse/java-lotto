package lotto;

public class CommonContent {

    public enum PrintLottoContent {
        PURCHASEAMOUNT("구입금액을 입력해 주세요."),
        WINNINGNUMBER("당첨 번호를 입력해 주세요."),
        BONUSNUMBER("보너스 번호를 입력해 주세요."),
        WINNINGSTATISTICS("당첨 통계\n---");

        private String printStatement;

        PrintLottoContent(String printStatement) {
            this.printStatement = printStatement;
        }

        public static String matchingAmount(Integer matchingCount, String winningAmount, Integer winNumbers, Integer rank){
            if(rank == 2){
                return matchingCount + "개 일치, 보너스 볼 일치 (" + winningAmount + ") - " + winNumbers + "개";
            }
            return matchingCount + "개 일치 (" + winningAmount + ") - " + winNumbers + "개";
        }

        public static String purchaseNumbers(Integer purchaseNumbers){
            return purchaseNumbers + "개를 구매했습니다.";
        }

        public static String totalReturn(Integer totalReturn){
            return "총 수익률은 " + totalReturn + "입니다.";
        }

        public java.lang.String getPrintStatement() {
            return printStatement;
        }
    }

    public enum PrintWinningInfo{

    }


    public enum PrintError{
        LOTTONUMBERERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        PURCHASEAMOUNTERROR("구입 금액은 1,000원 단위여야합니다"),
        NOBYELOTTOERROR("로또를 구매할 금액이 부족합니다."),
        WINNUMBERSERROR("당첨 번호는 'x,x,x,x,x,x'(x는 1부터 45 사이의 숫자)의 형태로 입력해야합니다."),
        BONUSNUMBERERROR("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
        LOTTOSIZEERROR("로또의 크기는 6이상이어야합니다.");

        private String printStatement;

        PrintError(String printStatement) {
            this.printStatement = "[ERROR] " + printStatement;
        }

        public String getPrintStatement(){
            return printStatement;
        }
    }
}
