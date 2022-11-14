package lotto.domain.dto;

public class LottoWinsCountDto {

	public Integer answerCount;
	public Integer bonusCount;

	public LottoWinsCountDto(int answerCount, int bonusCount) {
		this.answerCount = answerCount;
		this.bonusCount = bonusCount;
	}

	public Integer getAnswerCount() {
		return answerCount;
	}

	public Integer getBonusCount() {
		return bonusCount;
	}
}
