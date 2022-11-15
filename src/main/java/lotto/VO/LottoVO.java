package lotto.VO;

import java.util.ArrayList;
import java.util.List;

public class LottoVO {

	public String price = "";
	public String goalNumbers = "";	
	public String bonusNumbers = "";
	public List<List<Integer>> lotto = new ArrayList<>();	
	public int each=0;

	public int getEach() {
		return each;
	}

	public void setEach(int each) {
		this.each = each;
	}

	public String getGoalNumbers() {
		return goalNumbers;
	}

	public void setGoalNumbers(String goalNumbers) {
		this.goalNumbers = goalNumbers;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBonusNumbers() {
		return bonusNumbers;
	}

	public void setBonusNumbers(String bonusNumbers) {
		this.bonusNumbers = bonusNumbers;
	}

	public List<List<Integer>> getLotto() {
		return lotto;
	}

	public void setLotto(List<List<Integer>> lotto) {
		this.lotto = lotto;
	}
}
