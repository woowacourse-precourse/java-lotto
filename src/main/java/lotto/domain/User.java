package lotto.domain;

import static lotto.constant.LottoConstant.PERCENTAGE;
import static lotto.constant.LottoConstant.PRICE;
import static lotto.exception.ErrorResponse.BAD_INPUT_STRING;

import java.util.List;

public class User {

    private Integer money;
    private List<PaidLotto> paidLottoList;

    public User(String money) {
        try {
            this.money = Integer.parseInt(money);
        } catch (Exception exception) {
            throw BAD_INPUT_STRING.exception();
        }
    }

    public void setPaidLottoList(List<PaidLotto> paidLottoList) {
        this.paidLottoList = paidLottoList;
    }

    public Integer getLottoMountPerPrice(Integer lottoPrice) {
        Integer mount = this.money / lottoPrice;
        this.money %= lottoPrice;
        return mount;
    }

    public Integer getMoney() {
        return this.money;
    }

    public List<PaidLotto> getPaidLottoList() {
        return this.paidLottoList;
    }

    public void tellBenefit() {
        System.out.println("총 수익률은 " + getBenefitRatio() + "%입니다.");
    }

    private String getBenefitRatio() {
        float prize = (float) (
            (getTotalPrize() / (this.paidLottoList.size() * PRICE.getValue() * 1.0))
                * PERCENTAGE.getValue());
        return String.format("%.1f", prize);
    }

    private Integer getTotalPrize() {
        return this.paidLottoList.stream().filter(PaidLotto::isRewarded)
            .map(PaidLotto::getLotteryPrize)
            .reduce((Integer::sum))
            .orElse(0);
    }
}
