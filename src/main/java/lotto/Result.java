package lotto;

import java.util.List;
import java.util.ArrayList;;

public class Result {
    private static int matchCount;
    private static boolean bonusMatch;
    private static int rank;
    private final List<Integer> ticketResults;
    public final int[] rankResults;
    public final int totalPrize;

    public Result(List<List<Integer>> ticketList, List<Integer> lottoNumbers, int bonusNumber) {
        this.ticketResults = getTicketResults(ticketList, lottoNumbers, bonusNumber);
        this.rankResults = getRankResults(this.ticketResults);
        this.totalPrize = getTotalPrize(this.rankResults);
    }
    
    private static int getTotalPrize(int[] ranksResults) {
        int totalPrize = 
            (ranksResults[0] * Rank.FIRST.prizeMoney())
            + (ranksResults[1] * Rank.SECOND.prizeMoney())
            + (ranksResults[2] * Rank.THIRD.prizeMoney())
            + (ranksResults[3] * Rank.FOURTH.prizeMoney())
            + (ranksResults[4] * Rank.FIFTH.prizeMoney());
        return totalPrize;
    }

    private static int[] getRankResults(List<Integer> ticketResults) {
        int[] rankResults = {0, 0, 0, 0, 0};  // FIRST, SECOND, THIRD, FOURTH, FIFTH
        for(int result : ticketResults) {
            if(result == 5) {
                rankResults[4] += 1;
            }
            if(result == 4) {
                rankResults[3] += 1;
            }
            if(result == 3) {
                rankResults[2] += 1;
            }
            if(result == 2) {
                rankResults[1] += 1;
            }
            if(result == 1) {
                rankResults[0] += 1;
            }
        }
        return rankResults;
    }

    private static List<Integer> getTicketResults(List<List<Integer>> ticketList, List<Integer> lottoNumbers, int bonusNumber) {
        List<Integer> ticketResults = new ArrayList<>();
        for (List<Integer> ticket : ticketList) {
            matchCount = getMatchCount(ticket, lottoNumbers);
            bonusMatch = isBonusMatch(ticket, matchCount, bonusNumber);
            rank = getRank(matchCount, bonusMatch);
            ticketResults.add(rank);
        }
        return ticketResults;
    }
    
    private static int getRank(int matchCount, boolean bonusMatch) {
        rank = 6;
        if(matchCount < 3) {
            rank = 6;
        }
        if(matchCount == 3) {
            rank = 5;
        }
        if(matchCount == 4) {
            rank = 4;
        }
        if(matchCount == 5 && bonusMatch == false) {
            rank = 3;
        }
        if(matchCount == 5 && bonusMatch == true) {
            rank = 2;
        }
        if(matchCount == 6) {
            rank = 1;
        }
        return rank;
    }

    private static boolean isBonusMatch(List<Integer> ticket, int matchCount, int bonusNumber) {
        bonusMatch = false;
        if(matchCount != 5) {
            bonusMatch = false;
        }
        if(matchCount == 5 && ticket.contains(bonusNumber)) {
            bonusMatch = true;
        }
        return bonusMatch;
    }

    private static int getMatchCount(List<Integer> ticket, List<Integer> lottoNumbers) {
        matchCount = 0;
        for (Integer number : ticket) {
            if (lottoNumbers.contains(number)) {
                matchCount += 1;
            }
        }
        return matchCount;
    }
}
