---

## Lotto Game


### 설명 요약

    - 로또 구입
    - 로또 당첨 내역 및 수익률 출력 후, 게임 종료


<br/>

### 기능 설계

    - Lotto (Class)
        => 로또 입력

    - LottoTickets (Class)
        => 구입한 모든 로또 

    - Rule  (Class)
        => 범위, 중복, 당첨기준 & 금액
        => 예외 처리

    - Game  (Class)
        => 금액 입력
        => 당첨번호 & 보너스번호
        => 금액만큼 Lotto & Rule 적용
        => 당첨 통계