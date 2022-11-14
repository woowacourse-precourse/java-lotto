package dto;

import java.util.List;

public class LottoGameInfo {
	
	private long inputPrice; //구입 금액 정보
	private List<IssueLottoInfo> issueLotto; // 발행된 로또 정보
	private Lotto winningNumber; // 당첨번호
	private int bonusNumber;	// 보너스 당첨번호
	private float rateReturn; 	// 수익률
	
	
	
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
	public float getRateReturn() {
		return rateReturn;
	}
	public void setRateReturn(float rateReturn) {
		this.rateReturn = rateReturn;
	}
	
	
}
