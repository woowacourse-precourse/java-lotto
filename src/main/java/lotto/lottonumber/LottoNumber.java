package lotto.lottonumber;

import java.util.List;

/**
 * 일반 로또 번호 6개와 보너스 로또 번호 1개를 저장하는 클래스입니다.
 */
public class LottoNumber {

    /**
     * 일반 로또 번호 (6개의 정수)
     */
    private final Lotto generalLottoNumber;
    /**
     * 보너스 로또 번호 (1개의 정수)
     */
    private final Integer bonusLottoNumber;

    /**
     * 7개의 중복되지 않는 정수 리스트를 각각 일반 로또 번호와 보너스 로또 번호로 변환하여 저장합니다.
     * 이후 일반 로또 번호는 오름차순으로 정렬합니다.
     * @param generatedLottoNumber 일반 로또 번호와 보너스 로또 번호를 포함한 7개의 정수 리스트
     */
    public LottoNumber(List<Integer> generatedLottoNumber) {
        this.generalLottoNumber = new Lotto(generatedLottoNumber.subList(0, 6));
        this.generalLottoNumber.sortLottoNumbers();
        this.bonusLottoNumber = generatedLottoNumber.get(6);
    }

    public Lotto getGeneralLottoNumber() {
        return generalLottoNumber;
    }

    public Integer getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
