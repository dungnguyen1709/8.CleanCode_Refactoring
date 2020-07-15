package refactoring;

public class TennisGame {

    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";
    public static final String DEUCE = "Deuce";
    public static final int TEMP_SCORE = 0;
    public static final String SCORE_DEFAULT = "";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static String score;
    public static int tempScore;

    public static String getScore(int player1Score, int player2Score) {
        score = SCORE_DEFAULT;
        tempScore = TEMP_SCORE;
        boolean isScoreEquals = player1Score == player2Score;
        boolean eitherReachMoreThan4 = player1Score >= 4 || player2Score >= 4;


        if (isScoreEquals) {
            getScoreIfEquals(player1Score);
        } else if (eitherReachMoreThan4) {
            getScoreByEitherReach4(player1Score,player2Score,eitherReachMoreThan4);
        } else {
            countingScores(player1Score, player2Score, tempScore);
        }

        return score;
    }

    private static void getScoreIfEquals(int player1Score) {
        switch (player1Score) {
            case 0:
                score = LOVE_ALL;
                break;
            case 1:
                score = FIFTEEN_ALL;
                break;
            case 2:
                score = THIRTY_ALL;
                break;
            case 3:
                score = FORTY_ALL;
                break;
            default:
                score = DEUCE;
                break;

        }
    }

    private static String getScoreByEquals(int player1Score, int player2Score, boolean isScoreEquals) {
        if (isScoreEquals) {
            getScoreIfEquals(player1Score);

        }
        return score;
    }

    private static String getScoreByEitherReach4(int player1Score, int player2Score, boolean eitherReachMoreThan4) {
        if (eitherReachMoreThan4) {
            int minusResult = player1Score - player2Score;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2 :";
        }
        return score;
    }

    private static String countingScores(int player1Score, int player2Score, int tempScore) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }

}