package lotto;

public interface Result {

    String Origin = " 3개 일치 (5,000원) - %d개\n4개 일치 (50,000원) - %d개\n5개 일치 (1,500,000원) - %d개\n5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n6개 일치 (2,000,000,000원) - %d개\n총 수익률은 %.1f%%입니다.";

    void ReturnResult(int three,int four,int five,int FiveS,int six);
}
