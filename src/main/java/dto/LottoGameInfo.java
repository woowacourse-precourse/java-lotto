package dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameInfo {

	private long inputPrice; // 구입 금액 정보
	private List<IssueLottoInfo> issueLotto; // 발행된 로또 정보
	private Lotto winningNumber; // 당첨번호
	private int bonusNumber; // 보너스 당첨번호
	private List<Integer> result; // 당첨결과 

	public LottoGameInfo() {
		result = new ArrayList<Integer>();
		for (CriteriaWinning cw : CriteriaWinning.values()) {
			result.add(0);
		}

	}

	public List<Integer> getResult() {
		return result;
	}

	public void setResult(List<Integer> result) {
		this.result = result;
	}

	public long getInputPrice() {
		return inputPrice;
	}

	public void setInputPrice(long inputPrice) {
		this.inputPrice = inputPrice;
	}

	public List<IssueLottoInfo> getIssueLotto() {
		return issueLotto;
	}

	public void setIssueLotto(List<IssueLottoInfo> issueLotto) {
		this.issueLotto = issueLotto;
	}

	public Lotto getWinningNumber() {
		return winningNumber;
	}

	public void setWinningNumber(Lotto winningNumber) {
		this.winningNumber = winningNumber;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

}
