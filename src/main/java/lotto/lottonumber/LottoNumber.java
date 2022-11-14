package lotto.lottonumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 일반 로또 번호 6개와 보너스 로또 번호 1개를 저장하는 클래스입니다.
 * 사용자가 구매한 로또 또한 해당 클래스를 사용하며, 이때 보너스 로또 번호는 의미를 갖지 않습니다.
 */
public class LottoNumber {

    /**
     * 일반 로또 번호 (6개의 정수)
     */
    private final Lotto generalLottoNumber;
    /**
     * 보너스 로또 번호 (1개의 정수)
     */
    private Integer bonusLottoNumber;

    /**
     * 7개의 중복되지 않는 정수 리스트를 각각 일반 로또 번호와 보너스 로또 번호로 변환하여 저장합니다.
     * 이후 일반 로또 번호는 오름차순으로 정렬합니다.
     * @param generatedLottoNumber 일반 로또 번호와 보너스 로또 번호를 포함한 7개의 정수 리스트
     */
    public LottoNumber(List<Integer> generatedLottoNumber) {
        List<Integer> lottoNumbers = new ArrayList<>(generatedLottoNumber);
        if (lottoNumbers.size() == 6) {
            lottoNumbers.add(-1);
        }

        List<Integer> newGeneralLottoNumbers = new ArrayList<>();
        for(int i = 0; i < 6; i++) newGeneralLottoNumbers.add(generatedLottoNumber.get(i));

        this.generalLottoNumber = new Lotto(newGeneralLottoNumbers);
        this.generalLottoNumber.sortLottoNumbers();
        this.bonusLottoNumber = lottoNumbers.get(6);
    }

    public LottoNumber(Lotto lotto, int bonusLottoNumber) {
        this.generalLottoNumber = lotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Lotto getGeneralLottoNumber() {
        return generalLottoNumber;
    }

    public Integer getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
