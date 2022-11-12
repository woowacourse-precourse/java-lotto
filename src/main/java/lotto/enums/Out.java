package lotto.enums;

public enum Out {
        BUY_LOTTERY("구입금액을 입력해 주세요"),
        PRINT_BUY_LOTTERY("%d개를 구매했습니다."),
        WIN_LOTTERY_NUMBER("당첨 번호를 입력해 주세요."),
        BONUS_LOTTERY_NUMBER("보너스 번호를 입력해 주세요."),
        PRINT_RESULT("당첨 통계%n---%n"),
        YIELD("총 수익률은 %.1f%%입니다.%n");

        private String output;
        public String getOutput(){
            return output;
        }
        private Out(String output){
            this.output = output;
        }
}
