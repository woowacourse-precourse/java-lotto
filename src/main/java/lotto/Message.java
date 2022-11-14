package lotto;

import java.util.ArrayList;

public enum Message {
	INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
	BOUGHT_AMOUNT("개를 구매했습니다."),
	INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
	INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	WINNING_STATUS("당첨 통계\n---"),
	THREE_MATCHES("3개 일치 (5,000원) - "),
	FOUR_MATCHES("4개 일치 (50,000원) - "),
	FIVE_MATCHES("5개 일치 (1,500,000원) - "),
	FIVE_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	SIX_MATCHES("6개 일치 (2,000,000,000원) - "),
	TOTAL_RETURN("총 수익률은 ");
	private final String message;

	Message(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public static void printBoughtAmount(int amount){
		System.out.println(amount+BOUGHT_AMOUNT.getMessage());
	}

	public static void printWinningStatus(ArrayList<Integer> winningInfo){
		System.out.println(WINNING_STATUS.getMessage());
		System.out.println(THREE_MATCHES.getMessage() + countWinning(winningInfo.get(0)));
		System.out.println(FOUR_MATCHES.getMessage() + countWinning(winningInfo.get(1)));
		System.out.println(FIVE_MATCHES.getMessage() + countWinning(winningInfo.get(2)));
		System.out.println(FIVE_BONUS_MATCHES.getMessage() + countWinning(winningInfo.get(3)));
		System.out.println(SIX_MATCHES.getMessage() + countWinning(winningInfo.get(4)));
	}

	public static String countWinning(int count){
		return count+"개";
	}

	public static void printTotalReturn(double rate){
		System.out.println(TOTAL_RETURN.getMessage() + String.format("%,.1f", rate)+"%입니다.");
	}

}
