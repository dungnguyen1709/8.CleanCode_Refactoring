package refactoring;

public class TennisGame {

    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";
    public static final String DEUCE = "Deuce";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";

    public static String getScore(  int firstScore1, int secondScore2) {
        String score = "";
        int tempScore;

        boolean isScoreEquals = firstScore1 == secondScore2;
        boolean isScoreDifferenceMoreThan4 = firstScore1 >= 4 || secondScore2 >= 4;

        if (isScoreEquals)
        {
            switch (firstScore1)
            {
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
        else {
            if (isScoreDifferenceMoreThan4)
            {
                int minusResult = firstScore1 - secondScore2;
                if (minusResult==1) score ="Advantage player1";
                else if (minusResult ==-1) score ="Advantage player2";
                else if (minusResult>=2) score = "Win for player1";
                else score ="Win for player2";
            }
            else
            {
                for (int i=1; i<3; i++)
                {
                    if (i==1) tempScore = firstScore1;
                    else { score+="-"; tempScore = secondScore2;}
                    switch(tempScore)
                    {
                        case 0:
                            score+= LOVE;
                            break;
                        case 1:
                            score+= FIFTEEN;
                            break;
                        case 2:
                            score+= THIRTY;
                            break;
                        case 3:
                            score+= FORTY;
                            break;
                    }
                }
            }
        }
        return score;
    }
}
