## 프로그램 설명
해당 프로그램은 금액을 입력 받아 
금액에 맞는 로또 수 만큼 발행해 당첨 결과를 알려주는 프로그램이다.

## 제약사항
- intent depth가 2 이하여야 한다.
- 3항 연산자를 사용하지 않는다.
- 함수가 15 라인이 넘어가지 않게 한다.
- else 및 switch/case 예약어를 쓰지 않는다. 
- Java Enum을 적용한다.
- 도메인 로직에 대한 단위 테스트를 구현한다. 
- Lotto에 매개변수가 없는 생성자를 추가할 수 없다.
- numbers의 접근제어자를 변경할 수 없다. 
- Lotto에 인스턴스 변수를 추가할 수 없다. 
- Lotto의 패키지 변경은 가능하다.


## 기능 목록
- 1~45 범위의 숫자 중 중복되지 않은 6개의 번호를 뽑는다.:로또 발행 - LottoManager#issue
- 로또의 번호를 출력한다. - UI#printLotto
- 금액을 입력받는다. - InputManager#inputCustomerMoney
  - 입력 받은 금액의 유효성을 검증한다. - Verifier#isValidMoney
- 금액에 맞게 로또를 구매한다. - Customer#purchaseLotto
- 당첨 번호를 입력 받는다. - InputManager#inputWinningNumber
- 보너스 번호를 입력 받는다. - InputManager#inputBonusNumber
- 구매한 로또 수량 및 번호를 오름차순으로 정렬 후 출력한다. - UI#printPurchaseHistory
- 당첨 내역과 수익률을 출력 후 종료한다. 수익률은 소수점 둘째 자리에서 반올림한다. UI#printWinningStatistics
- 사용자의 입력에 대해 예외처리를 적용하고 에러메세지를 출력 후 종료한다. 