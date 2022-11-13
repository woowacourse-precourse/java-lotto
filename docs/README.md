# 로또

## 기능 목록

### VIEW

- Money

- [ ] 구입금액을 입력 Money#get()
- [ ] 구입금액이 유효한 지 확인 Money#check()

- Lotto

- [ ] 발행된 로또 출력 Lotto#print()
- [ ] 당첨 결과 출력 Lotto#printResult()

- Number

- [ ] 당첨번호 입력 Number#getWinNumbers()
- [ ] 당첨 번호가 유효한 지 확인 Number#checkWinNumbers()
- [ ] 보너스 번호 입력 Number#getBonusNumber()
- [ ] 보너스 번호가 유효한 지 확인 Number#checkBonusNumber()

### DOMAIN

- LottoGenerator

- [ ] 중복되지 않는 6개의 숫자 생성 LottoGenerator#generateNumbers()
- [ ] 금액에 해당하는 개수 만큼 로또 발행 Lotto#generate()

- Referee

- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교 Referee#compare()

  - Judgment
  
  - [ ] 몇개의 숫자가 같은지 카운트 Judgment#countMatch()
  - [ ] 보너스 숫자가 포함되는지 확인 Judgment#checkBonus()
  
  - Statistics
  
  - [ ] 로또 결과를 기록 Statistics#record()
  - [ ] 로또 결과가 기록된 map 반환 Statistics#getMap()
  - [ ] 수익률 계산 Statistics#getReturn()

## 예외 상황
- 구입금액이 숫자가 아님
- 구입금액이 1000원 단위로 나누어 떨어지지 않음
- 당첨번호가 숫자가 아니거나 입력형식과 맞지 않음 
- 당첨번호의 범위(1~45)를 벗어남
- 당첨번호의 개수가 6개가 아님

## 기능 요구 사항

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.