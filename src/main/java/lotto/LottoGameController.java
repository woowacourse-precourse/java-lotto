package lotto;

import java.util.ArrayList;
import java.util.List;

import dto.IssueLottoInfo;
import dto.LottoGameInfo;
import util.InputUtil;
import util.PrintUtil;

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

	// 구입금액 입력받기
	public void inputPurchaseAmount() {
		long inputPrice = InputUtil.inputPurchaseAmount();
		lottoGameInfo.setInputPrice(inputPrice);
	}

	// 로또 발행하기
	public void issueLotto() {

		List<IssueLottoInfo> issueLottoInfo = new ArrayList<IssueLottoInfo>();
		for (int i = 0; i < lottoGameInfo.getInputPrice() / 1000; i++) {
			issueLottoInfo.add(new IssueLottoInfo());
		}
		lottoGameInfo.setIssueLotto(issueLottoInfo);

	}

	// 발행번호 출력하기 
	public void printIssueLotto() {
		PrintUtil.printPurchaseResult(lottoGameInfo.getInputPrice());
		PrintUtil.printIssueLotto(lottoGameInfo.getIssueLotto());
	}
	
	// 당첨번호 입력받기
	public void inputWinningNumber() {
		// TODO: 추가 기능 구현
	}

	// 보너스 번호 입력받기
	public void inputBonusNumber() {
		// TODO: 추가 기능 구현
	}

	// 결과 출력하기
	public void printResult() {
		// TODO: 추가 기능 구현
	}

}
