package lotto.repository.dto;

import java.util.List;

import lotto.domain.Lotto;

public class UserLottoDto {

	private List<Lotto> userLottos;

	public UserLottoDto(List<Lotto> userLottos) {
		this.userLottos = userLottos;
	}

	public List<Lotto> getUserLottos() {
		return userLottos;
	}

}
