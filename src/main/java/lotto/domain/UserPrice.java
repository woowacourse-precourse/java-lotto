package lotto.domain;

import static lotto.util.ValidUtil.*;

public class UserPrice {

	private Integer inputPrice;
	private Integer userTicketCount;

	public UserPrice(String inputPrice) {
		Integer userPrice = validateUserMoney(inputPrice);
		this.inputPrice = userPrice;
		this.userTicketCount = userPrice / 1000;
	}

	public Integer getInputPrice() {
		return inputPrice;
	}

	public Integer getUserTicketCount() {
		return userTicketCount;
	}
}
