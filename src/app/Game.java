package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Object class for creating Game objects.
 * gameShelf: all games currently in play.
 * gameNumber: the game's unique number, which no two active games will share.
 * tabCount: the amount of tabs left for the game.
 * tabPrice: the price of each tab.
 * prizes: the cash prizes for the game.
 * awardedPrizes: prizes that have already been awarded.
 * sellCount: the amount of tabs already sold.
 * profitLoss: the return on the game.
 * recommendPull: whether the game is recommended to be pulled or not.
 */
public class Game implements Serializable {
    public static ArrayList<Game> gameShelf = new ArrayList<>();
    private int gameNumber;
    private int tabCount;
    private String gameName;
    private double tabPrice;
    private ArrayList<Double> prizes;
    private ArrayList<Double> awardedPrizes;
    private int sellCount;
    private double profitLoss;

    public Game(int gameNumber, int tabCount, String gameName, double tabPrice, ArrayList<Double> prizes,
                ArrayList<Double> awardedPrizes, int sellCount, double profitLoss) {
        this.gameNumber = gameNumber;
        this.tabCount = tabCount;
        this.gameName = gameName;
        this.tabPrice = tabPrice;
        this.prizes = prizes;
        this.awardedPrizes = awardedPrizes;
        this.sellCount = sellCount;
        this.profitLoss = profitLoss;

        gameShelf.add(this);
    }

    /**
     * Awards a prize from the game, changing the games profitLoss and moving the prize from prizes to awardedPrizes.
     * @param prizeValue the value of the prize being awarded.
     * @return the result of attempting to award the prize.
     */
    public boolean awardPrize(double prizeValue) {
        this.prizes.remove(prizeValue);
        this.awardedPrizes.add(prizeValue);
        return true;
    }

    /**
     * Given the active game shelf, parses each game number into an ArrayList,
     * looping over the ArrayList to find the lowest available game number.
     * @return an integer of the lowest available game number.
     */
    public int getLowestGameNumber() {
        ArrayList<Integer> takenGameNums = new ArrayList<>();
        gameShelf.forEach(Game -> takenGameNums.add(Game.gameNumber));
        Collections.sort(takenGameNums);
        int i = 1;
        for(int num : takenGameNums) {
            if(i < num) {
                return i;
            }
        }
        return takenGameNums.size()+1;

    }

    @Override
    public String toString() {
        return "Game " + gameNumber + ": " +
                "\nTab Count: " + tabCount +
                "\nGame Name: " + gameName +
                "\nTab Price: " + tabPrice +
                "\nAvailable Prizes: " + prizes +
                "\nAwarded Prizes: " + awardedPrizes +
                "\nTabs Sold: " + sellCount +
                "\n";
    }

    //getters and setters

    public static ArrayList<Game> getGameShelf() {
        return gameShelf;
    }

    public static void setGameShelf(ArrayList<Game> gameShelf) {
        Game.gameShelf = gameShelf;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getTabCount() {
        return tabCount;
    }

    public void setTabCount(int tabCount) {
        this.tabCount = tabCount;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public double getTabPrice() {
        return tabPrice;
    }

    public void setTabPrice(double tabPrice) {
        this.tabPrice = tabPrice;
    }

    public ArrayList<Double> getPrizes() {
        return prizes;
    }

    public void setPrizes(ArrayList<Double> prizes) {
        this.prizes = prizes;
    }

    public ArrayList<Double> getAwardedPrizes() {
        return awardedPrizes;
    }

    public void setAwardedPrizes(ArrayList<Double> awardedPrizes) {
        this.awardedPrizes = awardedPrizes;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public double getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(double profitLoss) {
        this.profitLoss = profitLoss;
    }
}
