package lotto.View;

import static lotto.Dto.ConstDto.InputOutputConstDto.PRINT_LOTTO_SIZE_MESSAGE;

public class OutputView {

    public void printLottoSize(int lottoSize){
        System.out.println(lottoSize+PRINT_LOTTO_SIZE_MESSAGE);
    }
}
