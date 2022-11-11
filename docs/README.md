# 로또 애플리케이션

## 구현목록

- [x] 사용자가 구매하는 기능 buyLotto
    - [x] 금액을 입력받음 inputMoney
    - [x] (예외처리)금액 입력 시 1000원 단위인 경우 
    - [x] (예외처리)금액 입력 시 0원을 입력한 경우


- [ ] 구매 갯수만큼 로또를 출력 printLotto
    - [ ] 로또 번호 내 숫자를 오름 차순 출력 sortNumberInAscendingOrder


- [ ] 당첨번호를 입력받는 기능 inputWinningNumber
    - [ ] 1~45 6자리를 입력받음 inputMainNumber
    - [ ] 보너스 숫자를 입력받음 inputBonusNumber
    - [ ] (예외처리) 보너스 숫자가 당첨번호에 포함되는 경우
    - [ ] (예외처리) 입력값이 1~45 이내 숫자가 아닌 경우
    - [ ] (예외처리) 같은 숫자가 들어오는 경우
    - [ ] (예외처리) 아무 값 없이 엔터치는 경우
    - [ ] (예외처리) 처음 6자리 입력값이 6개가 아닌 경우


- [ ] 당첨 통계 출력 기능 printStatistics
    - [ ] 각 등수별로 당첨 금액과 갯수를 출력 sortLottoResults
    - [ ] 3등은 5개, 2등은 5개+보너스 일치이므로 3등인지 2등인지 구별하는 기능 distinguishSecondPlace


- [ ] 수익률 출력 기능 printYield
    - [ ] 수익률 = 당첨금액/구매금액을 계산하여 출력 
    - [ ] (예외처리) 수익률이 0인 경우