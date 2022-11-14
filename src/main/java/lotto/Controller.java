package lotto;

public class Controller {
	LottoProgram lottoProgram = new LottoProgram();
	MessagePrint messagePrint =new MessagePrint();

	public void run() {
		try {
			lottoProgram.purchaseLotto();
			lottoProgram.message(lottoProgram.randomNumbers);
			lottoProgram.lottoNum();
			lottoProgram.matchLotto(lottoProgram.lottoNumbers);
			lottoProgram.inputBonus();
			lottoProgram.totalResult();
			messagePrint.lottoResultView(lottoProgram.totalResult());
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
}