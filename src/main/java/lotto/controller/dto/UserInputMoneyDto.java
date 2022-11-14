package lotto.controller.dto;

import lotto.util.ValidConst;

public class UserInputMoneyDto {

	private Integer inputPrice;
	private Integer userTicketCount;

	public UserInputMoneyDto(Integer userPrice) {
		this.inputPrice = userPrice;
		this.userTicketCount = userPrice / ValidConst.MONEY_UNIT;
	}

	public Integer getInputPrice() {
		return inputPrice;
	}

	public Integer getUserTicketCount() {
		return userTicketCount;
	}
}
