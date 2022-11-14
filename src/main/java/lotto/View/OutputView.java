package lotto.View;

import lotto.Dto.Lotto;

import java.util.List;

import static lotto.Dto.ConstDto.InputOutputConstDto.PRINT_LOTTO_SIZE_MESSAGE;

public class OutputView {

    public void printLottoSize(int lottoSize){
        System.out.println(lottoSize+PRINT_LOTTO_SIZE_MESSAGE);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for(Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
        System.out.println();
    }
}
