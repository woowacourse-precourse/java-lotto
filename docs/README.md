## 🚀 기능 목록

- [x] 로또 발행 기능(오름차순 정렬) - LottoGenerator#createRandomNumbers()
- [x] 구입 금액 입력 기능 - Console#inputMoney()
- [x] 금액에 따른 로또 개수 계산 기능 - Calculator#getLottoCount() 
- [x] 구매한 로또 출력 기능 - Console#outputMyLottos()
- [x] 당첨 번호 입력 기능 - Console#inputWinningNumbers()
- [x] 보너스 번호 입력 기능 - Console#inputBonusNumber()
- [x] 당첨 번호와 로또 번호 비교 기능 - Lotto#compareNumbers()
- [x] 보너스 번호와 로또 번호 비교 기능 - Lotto#compareBonus()
- [ ] 등수 계산 기능 - Calculator#calculateRank()
- [ ] 수익률 계산 기능 - Calculator#calculateYield()
- [ ] 당첨 통계 출력 기능 - Console#outputWinningResult()
- [ ] 예외 상황 에러 문구 출력 기능 - Console#outputErrorMessage()


## 기능 요구 사항
로또 번호의 숫자 범위는 1~45까지이다.
1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.

당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
- 1등: 6개 번호 일치 / 2,000,000,000원
- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- 3등: 5개 번호 일치 / 1,500,000원
- 4등: 4개 번호 일치 / 50,000원
- 5등: 3개 번호 일치 / 5,000원

로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
로또 1장의 가격은 1,000원이다.
당첨 번호와 보너스 번호를 입력받는다.
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

## 제한사항

Java Enum을 적용한다.
else 예약어를 쓰지 않는다.
함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.