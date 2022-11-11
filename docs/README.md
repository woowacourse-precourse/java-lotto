## 🔍 기능구현 목록
- java 로또는 크게 View, LottoService, LottoRepository, Lotto 로 분리되어있다

### View 기능구현 목록
- View 는 애플리케이션에서 입출력을 담당하는 객체이다.
- 로또 구매 금액을 입력받는 input 메서드 구현
  - 금액이 1000원 단위로 떨어지지않으면 예외 발생
- `List<LottoDto>` 를 인자로 받아 발생한 로또 수량 및 번호를 출력하는 메서드 구현
- 당첨 번호와 보너스 번호를 입력받고 리스트로 반환하는 input 메서드 구현
  - 당첨번호가 1~45 사이에 없으면 예외 발생
- `PrizeDto` 을 인자로 받아 당첨통계, 출력하는 메서드 구현
  - `PrizeDto` 는 금액별 당첨 갯수와 총 수익률을 필드로 포함하고있다.

### LottoService 기능 구현 목록
- LottoService 는 애플리케이션에서 금액별 로또 생성메시지 전송, 로또당첨 비교, 수익률 계산을 담당하는 객체이다.
- 금액만큼 `Lotto` 생성 메시지를 보내는 메서드 구현
  - 인자는 랜덤으로 생성된 `List<Integer>` 전달한다.
  - 생성된 `Lotto` 는 `LottoRepository` 에 저장된다.
- `LottoRepository` 에 저장된 로또와 당첨번호와 비교하는 메서드 구현
  - 일치하는 숫자만큼 `Prize` 를 생성
- 생성된 `List<Prize>` 와 수익률을 계산해서 `View` 에 결과메시지를 보내는 메서드 구현

### Lotto 기능 구현 목록
- 당첨번호와 랜덤으로 생성된 번호와 비교해서 `Prize` 를 반환하는 메서드 구현 

### LottoRepository 기능구현 목록
- LottoRepository 는 애플리케이션에서 랜덤으로 생성된  `Lotto` 객체의 저장, 조회를 담당하는 객체이다.






