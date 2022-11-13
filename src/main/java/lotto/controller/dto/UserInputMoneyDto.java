package lotto.controller.dto;

public class UserInputMoneyDto {

	private Integer inputPrice;
	private Integer userTicketCount;

	public UserInputMoneyDto(Integer userPrice) {
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
