package Print;

public enum Message {
	INPUT_MONEY("구입금액을 입력해주세요."),
	INPUT_WINNER_NUMBER("당첨 번호를 입력해 주세요."),
	INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	LOTTO_COUNT("개를 구매했습니다."),
	WINNING_STATES("\n당첨 통계\n---"),
	PROFIT("총 수익률은");
	
	final String msg;
	
	Message(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return msg;
	}
	
	public void print() {
		System.out.println(msg);
	}
	
	public void print_count(int count) {
		System.out.println(count + msg);
	}
	
	public void print_profit(double profit) {
		String message = String.format("%.1f", profit);
		System.out.printf("%s %s%%입니다.", msg, message);
	}
}
