package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LottoCollectionTest {
    @Test
    @DisplayName("구매한 모든 로또의 숫자 출력 테스트")
    void 구매한_로또들의_숫자_출력_테스트(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        List<Lotto> arr = new ArrayList<>();
        arr.add(new Lotto(List.of(1,2,3,4,5,6)));
        arr.add(new Lotto(List.of(7,8,9,10,11,12)));
        arr.add(new Lotto(List.of(13,14,15,16,17,18)));

        OutputView.printLottoCollection(new LottoCollection(arr));
        List<String> str = new ArrayList<>();
        str.add("[1, 2, 3, 4, 5, 6]");
        str.add("[7, 8, 9, 10, 11, 12]");
        str.add("[13, 14, 15, 16, 17, 18]");

        for(int i=0;i<str.size();i++){
            Assertions.assertThat(true).isEqualTo(byteArrayOutputStream.toString().contains(str.get(i)));
        }
    }
}
