package lotto;

import dto.LottoGameInfo;
import util.InputUtil;

/**
* 
* 로또 게임 진행
* 
* @author mirasoy
* @version 0.1, 작업 내용
*/
public class LottoGameController {
	
	private LottoGameInfo lottoGameInfo;
	
	public LottoGameController() {
		lottoGameInfo = new LottoGameInfo();
	}
	
	
	//구입금액 입력받기
	public void inputPurchaseAmount(){
		long inputPrice = InputUtil.inputPurchaseAmount();
		lottoGameInfo.setInputPrice(inputPrice);
	}

	//로또 발행하기
	public void issueLotto(){
	   // TODO: 추가 기능 구현
	}
	
	//당첨번호 입력받기
	public void inputWinningNumber(){
		// TODO: 추가 기능 구현
	}
	
	//보너스 번호 입력받기
	public void inputBonusNumber(){
		// TODO: 추가 기능 구현
	}
	
	//결과 출력하기
	public void printResult(){
		// TODO: 추가 기능 구현
	}
	

}
