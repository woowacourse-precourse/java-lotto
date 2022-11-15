package wootech;

public class User {
    private int count;
    private Lotto[] lottos;
    Application application;

    // 생성자 호출시 로또 번호를 생성
    public User(int count) {
        this.count = count;
        lottos = new Lotto[count];

        // 로또 번호 생성
        for (int i = 0; i < count; i++) {
            lottos[i] = new Lotto(application.createLottoNumber());
        }
    }

    public Lotto[] getLottos() {
        return lottos;
    }

}
