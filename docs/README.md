## 🎯 프로젝트 개요

로또 게임 기능을 구현합니다. 

로또 한 장의 가격은 1,000원 입니다.

숫자 1부터 45 범위 내의 숫자 중, 6개의 숫자를 자동으로 뽑습니다.

당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑습니다.

당첨 내역 및 수익률을 출력하고 로또 게임을 종료합니다.

## 🚀 기능 목록

- [ ] 로또 구입 금액을 입력받는 기능

  _InputView #inputTo(String BUDGET)_

    - [ ] 구매 가능한 로또 개수 구하는 기능 _Money #getNumberOfTickets_
    - [ ] 공백이 있다면 제거
    - [ ] (e) 공백인 경우 예외처리
    - [ ] (e) 정수 입력이 아니면 예외처리
    - [ ] (e) 음수이면 예외처리
    - [ ] (e) 1000원 단위 외의 금액은 예외처리

- [ ] 구매한 로또 개수 출력하는 기능

  _OutputView #outputPurchasedTicketCounts(String.format())_

- [ ] 로또 목록 기능
    - [ ] 로또 티켓을 랜덤으로 생성하는 기능

      _LottoMachine #createAutoTickets()_

        - [ ] 로또 숫자 정렬하는 기능

    - [ ] 생성된 티켓 목록을 출력하는 기능

      _OutputView #outputPurchasedTicketList(LottoTickets)_


- [ ] 당첨 번호 입력받는 기능

  _InputView #inputTo(String WinningNumber)_

    - [ ] 공백 제거
    - [ ] (e) 숫자가 아니면 예외처리
    - [ ] (e) 숫자가 6개가 아니면 예외처리
    - [ ] (e) 숫자는 1 ~ 45 범위가 아니면 예외처리
    - [ ] (e) 입력 구분자가 , 가 아니면 예외처리
    - [ ] (e) 중복된 숫자가 올 경우 예외처리
- 보너스 번호 입력받는 기능

  _InputView #inputTo(String BonusNumber)_

    - [ ] 공백 제거
    - [ ] (e) 숫자가 아니면 예외처리
    - [ ] (e) 숫자는 1 ~ 45 범위가 아니면 예외처리
    - [ ] (e) 당첨 번호와 중복되면 예외처리

- 결과를 추첨하는 기능

  _WinningStatistics #compareToTicket(winningTicket, LottoTickets)_

    - 당첨 번호와 구매 티켓 일치 확인 기능
    - 보너스볼 확인 기능
    - 수익률 출력 (수익률 = 당첨 금액 /구입 금액) 하는 기능
    - 추첨 결과를 출력하는 기능

