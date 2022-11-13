package lotto;

public class LottoFunction {
    public static LottoRepository buyLottoUserPaid(Money money) {
        LottoRepository lottoRepository = LottoRepository.newLottoRepository();
        int buyCount = money.getCountByLotto();
        System.out.println();
        System.out.println(buyCount + "개를 구매했습니다.");

        for (int i = 0; i < buyCount; i++) {
            lottoRepository.addLotto(Lotto.newLotto());
        }
        lottoRepository.lottos().stream()
                .forEach(lotto -> System.out.println(lotto.getLottoNumbers()));

        return lottoRepository;
    }
}
