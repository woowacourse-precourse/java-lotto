package lotto;

import lotto.numbers_generator.LottoNumberGeneratorSequenceImpl;

import java.util.List;

public class Application {
    public static void main(String[] args) {
//        init();
        try {
            ConsoleManager.runUI();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private static void init(){
        LottoNumberGeneratorSequenceImpl lottoNumberGeneratorSequence = new LottoNumberGeneratorSequenceImpl(
                List.of(
                        List.of(8, 21, 23, 41, 42, 43),
                        List.of(3, 5, 11, 16, 32, 38),
                        List.of(7, 11, 16, 35, 36, 44),
                        List.of(1, 8, 11, 31, 41, 42),
                        List.of(13, 14, 16, 38, 42, 45),
                        List.of(7, 11, 30, 40, 42, 43),
                        List.of(2, 13, 22, 32, 38, 45),
                        List.of(1, 3, 5, 14, 22, 45)
                )
        );
        Context.setLottoNumberGenerator(lottoNumberGeneratorSequence);
    }
}
