package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoCompany;

public class InputView {

	static InputView instance;

	private InputView(){}

	public static InputView getInstance(){
		if(instance == null){
			instance = new InputView();
		}
		return instance;
	}

	public LottoCompany createWinningLotto() {
		String winningNumberInput = Console.readLine();
		String bonusNumberInput = Console.readLine();

		return new LottoCompany(winningNumberInput, bonusNumberInput);
	}


}
