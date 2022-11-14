package lotto;

import java.util.ArrayList;
import java.util.List;

import dto.IssueLottoInfo;
import dto.Lotto;
import dto.LottoGameInfo;
import util.ConfirmWinning;
import util.ExceptionUtil;
import util.InputUtil;
import util.PrintUtil;
import util.ValidateUtil;

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
		Lotto winnigNumbers = new Lotto(InputUtil.inputWinnigNumber());
		lottoGameInfo.setWinningNumber(winnigNumbers);
	}

	// 보너스 번호 입력받기
	public void inputBonusNumber() {
		int bonusNumber = InputUtil.inputBonusNumber();
		if (ValidateUtil.checkDuplicates(lottoGameInfo.getWinningNumber(), bonusNumber)) {
			ExceptionUtil.makeException("보너스 번호는 당첨번호와 중복될 수 없습니다.");
		}

		lottoGameInfo.setBonusNumber(bonusNumber);

	}

	// 결과 계산하기
	public void calculateResult() {
		ConfirmWinning confirmWinning = new ConfirmWinning(lottoGameInfo);
		confirmWinning.confirmWinning();
	}

	// 결과 출력하기
	public void printResult() {
		PrintUtil.printResult(lottoGameInfo);
		PrintUtil.printProfitRate(lottoGameInfo);
	}

}
