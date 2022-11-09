package lotto.constants;

public class Constants {

	private final int lottoPrice = 1000;
	private final String buyPrice = "구입금액을 입력해 주세요.";
	private final String buyEach = "개를 구매했습니다.";
	private final String inputGoalNumbers = "당첨 번호를 입력해 주세요.";
	private final String inputBonusNumbers = "보너스 번호를 입력해 주세요.";
	private final String goalStatistics = "당첨 통계\n---";
	private final String rankOne = "6개 일치 (2,000,000,000원) - ";
	private final String rankTwo = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
	private final String rankThree = "5개 일치 (1,500,000원) - ";
	private final String rankFour = "4개 일치 (50,000원) - ";
	private final String rankFive = "3개 일치 (5,000원) - ";

	public String getBuyPrice() {
		return buyPrice;
	}

	public String getBuyEach() {
		return buyEach;
	}

	public String getInputGoalNumbers() {
		return inputGoalNumbers;
	}

	public String getInputBonusNumbers() {
		return inputBonusNumbers;
	}

	public String getGoalStatistics() {
		return goalStatistics;
	}

	public String getRankOne() {
		return rankOne;
	}

	public String getRankTwo() {
		return rankTwo;
	}

	public String getRankThree() {
		return rankThree;
	}

	public String getRankFour() {
		return rankFour;
	}

	public String getRankFive() {
		return rankFive;
	}

	public int getLottoPrice() {
		return lottoPrice;
	}
}
