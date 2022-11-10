# 로또

## 기능 목록
- 입력
- [ ] O 로또 구입 금액 입력 -PurchaseLotto#inputMoney() 
  - [ ] O 1000원단위로 입력
  - [ ] O 1000원 단위가 아니면 예외처리
- [ ] O 당첨번호 입력 (번호는 쉼표를 기준으로 구분) -LottoResult#inputLottoNumber()
  - [ ] O 로또 숫자 범위 1~45.
  - [ ] O 중복되지않은 6개의 숫자를 뽑는다. -Lotto#duplication()
- [ ] O 보너스 번호 입력 -LottoResult#inputBonusNumber()


- 출력
- [ ] O 발행한 로또 수량 및 번호 출력 -PurchaseLotto#countLotto() & PurchaseLotto#myLottoNumber()
  - [ ] O 오름차순 정렬
- [ ] O 내가 구매한 로토 내역 출력 -ConsumerResult#myLotto()
- [ ] 당첨 내역 출력 -ConsumerResult#winLotto()
  - [ ] O 당첨 번호와 나의 로또 비교 -ConsumerResult#compareLotto()
  - [ ] 보너스 번호와 나의 로또 비교 -ConsumerResult#compareBonus()
- [ ] 수익률 출력 -ConsumerResult#profit()
  - [ ] 수익 -ConsumerResult#myIncome()
  - [ ] 소수점 둘째 자리에서 반올림


- 예외 상황
- [ ] 예외 상황 시 에러 문구 "[ERROR]"로 시작


# 프로그래밍 요구 사항
1. 함수 길이는 최대 15라인
2. else 쓰지않기
3. Java Enum을 적용 -->어디에...?
4. 도메인 로직에 단위 테스트 구현
5. 3항 연산자 사용 금지
6. 들여쓰기 깊이 3미만
7. 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 이름을 수정, 이동 X
- Lotto 클래스 -->여기서는 뭘 구현하지...?
  - 제공된 Lotto 클래스를 활용해 구현해야 한다.
  - Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
  - numbers의 접근 제어자인 private을 변경할 수 없다.
  - Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
  - Lotto의 패키지 변경은 가능하다. --->domain으로 변경 할까...?