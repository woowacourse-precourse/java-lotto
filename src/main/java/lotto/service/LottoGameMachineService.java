package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.enumeration.Rating;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// 비즈니스 로직
public interface LottoGameMachineService {
    // 로또 게임 머신 기능
    // 1) 돈을 Repository 에 입력
    void enterMoney(int money);
    // 2) 당첨 번호를 입력해주다.
    void enterTheWinningNumbers(Lotto winningNumbers);
    // 3) 보너스 번호를 입력해주다.
    void enterBonusNumber(int bonusNumber);
    // 4) 통계를 계산하다
    LinkedHashMap<Rating, Integer> calculateStatistics();
    // 5) 금액에 따른 로또 개수를 알려준다.
    int readLottoQuantity();
    // 6) 로또의 개수를 알려주다.
    List<Lotto> readLottoNumbers();
    // 7) 입력한 금액을 알려주다.
    int readMoney();
    // 8) 당첨 번호를 알려주다.
    List<Integer> readWinningNumbers();
    // 9) 보너스 번호를 알려주다.
    int readBonusNumber();
}
