package lotto.repository.dto;

import java.util.List;

import lotto.domain.Lotto;

public class UserLottoDto {

	private List<Lotto> userLotto;

	public UserLottoDto(List<Lotto> userLotto) {
		this.userLotto = userLotto;
	}

	public List<Lotto> getUserLotto() {
		return userLotto;
	}

}
