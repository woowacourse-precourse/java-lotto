package lotto.output;

public class View {
    public enum ValidateMessage {
        ERROR_MESSAGE("[ERROR] "),
        SIZE_ERROR("로또의 당첨 번호는 6개여야 합니다.");
        private final String message;
        ValidateMessage(String message) {
            this.message = message;
        }
        public String print() {
            return (ERROR_MESSAGE.message + message);
        }
    }
    public enum InputMessage {

        BUY_NUM("개를 구매했습니다."),
        MONEY_PAY("구입금액을 입력해 주세요."),
        BONUS_NUM("보너스 번호를 입력해 주세요."),
        WIN_NUM("당첨 번호를 입력해 주세요.");


        private final String input;

        InputMessage(String input){
            this.input = input;
        }
        public String print(){return input;}
    }
    public enum WinNumber{
        THREE_BALL("3"),
        FOUR_BALL("4"),
        FIVE_BALL("5"),
        FIVE_BALL_BONUS("5b"),
        SIX_BALL("6");

        private final String num;

        WinNumber(String num) { this.num = num; }
        public String getBall(){return num;}
    }
    public enum StatisticPrint{
        PRINT_INIT("당첨 통계"),
        PRINT_BORDER("---"),
        PRINT_QUAN("개"),
        PRINT_THREE("3개 일치 (5,000원) - "),
        PRINT_FOUR("4개 일치 (50,000원) - "),
        PRINT_FIVE("5개 일치 (1,500,000원) - "),
        PRINT_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        PRINT_SIX("6개 일치 (2,000,000,000원) - "),
        PRINT_EARN("총 수익률은 "),
        PRINT_END("%입니다.");

        private final String output;

        StatisticPrint(String output){this.output = output;}

        public String getOutput() {
            return output;
        }
    }
}
