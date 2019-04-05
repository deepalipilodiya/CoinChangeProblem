import java.util.ArrayList;

public class CoinChangeProblem {

    public static int[] coinUsed;
    public static int[] coinCount;

    public static void processChangeCoin(int[] coinDenom,int[] coinCount,int[] coinUsed,int amt) {

        for (int i = 0; i < amt + 1; i++) {

            int denomCount = i;
            int coin = 1;
            int intmdCnt = 0;
            ArrayList<Integer> currentDenom = new ArrayList<Integer>();
            for (int k : coinDenom) {
                if (k <= i) {
                    currentDenom.add(k);
                }
            }
            for (int j : currentDenom) {
                if ((coinCount[i - j] + 1) < denomCount) {
                    if ((i - j) < coinDenom[0] && (i - j) > 0 ) {
                        coin = 0;
                        denomCount = 9999;
                    } else {
                        coin = j;
                        denomCount = coinCount[i - j] + 1;
                    }
                }
                coinCount[i] = denomCount;
                coinUsed[i] = coin;
            }
        }
    }


    public static void printCoins(int[] coinUsed,int amt){
        while(amt>0){
            int current_Coin = coinUsed[amt];
            System.out.println("Print Num :" + current_Coin );
            amt = amt - current_Coin;
        }
    }

    public static void main(String[] args) {
        int[] coins_denom = {2,5,10,21,25};
        int amt =64;
        coinCount = new int[amt+1];
        coinUsed = new int[amt+1];
        processChangeCoin(coins_denom,coinCount,coinUsed,amt);
        printCoins(coinUsed,amt);
    }
}