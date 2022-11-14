package lotto.domain;

import static lotto.constant.LottoConstant.PRICE;

import lotto.lottogenerator.LottoGenerator;

public class Seller {

    private final LottoGenerator lottoGenerator;

    public Seller(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void sellLotto(User user) {
        Integer lottoMount = user.getLottoMountPerPrice(PRICE.getValue());

        user.setPaidLottoList(lottoGenerator.generateLottoList(lottoMount));
        System.out.printf("%d개를 구매했습니다.", lottoMount);
        System.out.println();
        for (PaidLotto paidLotto : user.getPaidLottoList()) {
            System.out.println(paidLotto);
        }
    }
}
