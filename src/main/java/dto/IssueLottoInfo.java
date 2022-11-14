package dto;

import camp.nextstep.edu.missionutils.Randoms;

public class IssueLottoInfo {
	
	private Lotto issueLottoNumber; //발행된 로또 번호
	private int winningRanking;		//당첨 등수 (0일 경우에 당첨 x)
	
	public IssueLottoInfo(){
		Lotto issueLottoNumber =  new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
		this.issueLottoNumber = issueLottoNumber;
		this.winningRanking = 0;
	}

	public int getWinningRanking() {
		return winningRanking;
	}

	public void setWinningRanking(int winningRanking) {
		this.winningRanking = winningRanking;
	}

	public Lotto getIssueLottoNumber() {
		return issueLottoNumber;
	}
	

}
