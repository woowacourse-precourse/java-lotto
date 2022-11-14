package lotto.service;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.repository.UserLottoRepository;
import lotto.repository.dto.UserLottoDto;
import lotto.util.ValidConst;

public class LottoService {

	private final UserLottoRepository userLottoRepository;

	public LottoService(UserLottoRepository userLottoRepository) {
		this.userLottoRepository = userLottoRepository;
	}

	public UserLottoDto makeRandomLottoNumber(Integer lottoCount) {
		for (int i = 0; i < lottoCount; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(ValidConst.LOTTO_MIN_NUMBER,
					ValidConst.LOTTO_MAX_NUMBER, ValidConst.LOTTO_MAX_SIZE)
				.stream()
				.sorted()
				.collect(Collectors.toList());
			userLottoRepository.updateLotto(new Lotto(numbers));
		}
		return userLottoRepository.findUserLottoDto();
	}

}
