package lotto.repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.repository.dto.UserLottoDto;

public class UserLottoRepository {

	private Set<Lotto> userLotto;

	public UserLottoRepository() {
		userLotto = new HashSet<>();
	}

	public void updateLotto(Lotto lotto) {
		userLotto.add(lotto);
	}

	public UserLottoDto findUserLottoDto() {
		return new UserLottoDto(userLotto.stream().collect(Collectors.toList()));
	}

	public void clear() {
		userLotto.clear();
	}
}
