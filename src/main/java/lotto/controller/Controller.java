package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.VO.LottoVO;
import lotto.constants.Constants;
import lotto.service.Service;

public class Controller {
	
	Service service = new Service();	
	
	public Controller() {
		Constants constants = new Constants();
		LottoVO lotto = new LottoVO();
		getInputPrice(constants, lotto);		
		getInputNumbers(constants, lotto);
		getBuyLotto(lotto);
		getGoalNumbers(constants, lotto);
		getBonusGoalNumbers(constants, lotto);
	}

	public void getInputPrice(Constants constants, LottoVO lotto) {
		service.setInputPrice(constants, lotto);
	}

	public void getInputNumbers(Constants constants, LottoVO lotto) {
		service.setInputNumbers(constants, lotto);
	}

	public void getBuyLotto(LottoVO lotto) {
		service.setBuyLotto(lotto);
	}

	public void getGoalNumbers(Constants constants, LottoVO lotto) {
		service.setGoalNumbers(lotto, constants);
	}

	public void getBonusGoalNumbers(Constants constants, LottoVO lotto) {
		service.setBonusGoalNumbers(constants, lotto);
	}
}