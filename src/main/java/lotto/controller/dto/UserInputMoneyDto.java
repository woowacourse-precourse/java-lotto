package lotto.controller.dto;

import lotto.util.ValidConst;

public class UserInputMoneyDto {

	private Integer inputPrice;
	private Integer userLottoTicketCount;

	public UserInputMoneyDto(Integer userPrice) {
		this.inputPrice = userPrice;
		this.userLottoTicketCount = userPrice / ValidConst.MONEY_UNIT;
	}

	public Integer getInputPrice() {
		return inputPrice;
	}

	public Integer getUserLottoTicketCount() {
		return userLottoTicketCount;
	}
}
