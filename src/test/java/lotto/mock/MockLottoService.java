package lotto.mock;

import lotto.service.LottoServiceImpl;
import lotto.vo.Lotto;
import lotto.vo.LottoBuyingInfo;

import java.util.List;

public class MockLottoService extends LottoServiceImpl {
    private final List<Lotto> mockLottos;

    public MockLottoService(List<Lotto> mockLottos) {
        this.mockLottos = mockLottos;
    }

    @Override
    public List<Lotto> createLottos(LottoBuyingInfo lottoBuyingInfo) {
        return mockLottos;
    }
}
