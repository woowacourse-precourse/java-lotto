package lotto.message;

public interface OutputMessageConstants {

	String PURCHASE_COMPLETION_MESSAGE_FORMAT = "\n%d개를 구매했습니다.\n";
	String TOTAL_TITLE_MESSAGE = "\n당첨 통계\n---\n";
	String MATCH_MESSAGE_FORMAT = "%d개 일치 (%,d원) - %d개\n";
	String BONUS_MATCH_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
	String TOTAL_REVENUE_MESSAGE_FORMAT = "총 수익률은 %,.1f%%입니다.\n";
}
