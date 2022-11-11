package lotto;

import java.util.ArrayList;
import java.util.List;

public enum PrintMessage{
	
	INPUT_NUMBER("당첨 번호를 입력해 주세요."),
	INPUT_BONUS("보너스 번호를 입력해 주세요."),
	INPUT_MONEY("구입 금액을 입력해 주세요."),
	INPUT_DUPLICATE_ERR("[ERROR] 중복된 번호는 허용하지 않습니다."),
	INPUT_DEFINE_ERR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
	
	private List<Integer> wincount = new ArrayList<Integer>(5); // {3개, 4개, 5개, 5개+보너스, 6개};
	private final String message;
	
	PrintMessage(String message) {
		this.message = message;
	}
	
	PrintMessage(String message, List<Integer> count){
		this.message = message;
		this.wincount = count;
		System.out.println("당첨 통계\n"
				+ "---\n"
				+ "3개 일치 (5,000원)" + wincount.get(0) + "개\n"
				+ "4개 일치 (50,000원)\n" + wincount.get(1) + "개\n"
				+ "5개 일치 (1,500,000원)\n" + wincount.get(2) + "개\n"
				+ "5개 일치, 보너스 볼 일치 (30,000,000원)\n" + wincount.get(3) + "개\n"
				+ "6개 일치 (2,000,000,000원) - " + wincount.get(4) + "개\n"
				+ "총 수익률은 62.5%입니다.\n");//수익률수정필요
	}
}