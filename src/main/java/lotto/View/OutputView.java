package lotto.View;

import java.util.List;

public class OutputView {
    public void printList(List<String> list){
        System.out.println(list.size()+"개를 구매했습니다.");
        list.forEach(System.out::println);
    }
}
