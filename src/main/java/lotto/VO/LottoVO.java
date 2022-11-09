package lotto.VO;

import java.util.ArrayList;
import java.util.List;

public class LottoVO {
	
	public String price = "";
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<List<Integer>> lotto = new ArrayList<>();	
	public String bonusNumbers = "";

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
