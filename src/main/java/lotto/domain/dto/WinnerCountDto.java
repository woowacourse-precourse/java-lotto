package lotto.domain.dto;

public class WinnerCountDto {

	public int answerCount;
	public int bonusCount;

	public WinnerCountDto(int answerCount, int bonusCount) {
		this.answerCount = answerCount;
		this.bonusCount = bonusCount;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public int getBonusCount() {
		return bonusCount;
	}
}
