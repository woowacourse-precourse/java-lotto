package lotto.repository;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.repository.dto.UserLottoDto;

public class UserLottoRepository {

	private List<Lotto> userLotto;

	public UserLottoRepository() {
		userLotto = new ArrayList<>();
	}

	public void updateLotto(Lotto lotto) {
		userLotto.add(lotto);
	}

	public UserLottoDto findUserLottoDto() {
		return new UserLottoDto(userLotto);
	}

}
