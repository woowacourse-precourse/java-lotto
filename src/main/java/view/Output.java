package view;

import domain.Lottos;

public class Output {
    private Input input;

    private Lottos lottos;
    public Output() {
        input = new Input();
        lottos = new Lottos(input.getNumber());
    }
    public void printLottoList() {
        System.out.println(lottos.getNumberOfLotto()+"개를 구매했습니다.");
        for(int i = 0; i < lottos.getNumberOfLotto(); i++) {
            System.out.println(lottos.getLottos().get(i));
        }
    }
}
