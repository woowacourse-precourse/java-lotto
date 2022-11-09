package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.Service;

public class Controller {
	static Service service = new Service();
	public void getInputPrice() {
		getInputNumbers(service.setInputPrice());
	}
	
	public void getInputNumbers(String inputNumber) {
		getBuyLotto(service.setInputNumbers(inputNumber));
	}
	public void getBuyLotto(int ea) {		
		service.setBuyLotto(ea);
	}
	public void getGoalNumbers() {
		setBonusGoalNumbers(service.setGoalNumbers());
	}
	public void setBonusGoalNumbers(int numbers) {
		service.setBonusGoalNumbers();
	}
}