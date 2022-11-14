package dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameInfo {
	
	private long inputPrice; //구입 금액 정보
	private List<IssueLottoInfo> issueLotto; // 발행된 로또 정보
	private Lotto winningNumber; // 당첨번호
	private int bonusNumber;	// 보너스 당첨번호
	private Map<Integer, Integer> result; // 당첨결과 <등수, 당첨 갯수>
	
	public LottoGameInfo(){
		
		result = new HashMap<Integer, Integer>();
		result.put(1, 0);
		result.put(2, 0);
		result.put(3, 0);
		result.put(4, 0);
		result.put(5, 0);
		
	}
	
	public Map<Integer, Integer> getResult() {
		return result;
	}

	public void setResult(Map<Integer, Integer> result) {
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
