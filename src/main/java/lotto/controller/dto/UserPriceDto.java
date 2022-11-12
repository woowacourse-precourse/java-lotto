package lotto.controller.dto;

public class UserPriceDto {

	private Integer inputPrice;
	private Integer userTicketCount;

	public UserPriceDto(Integer userPrice) {
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
