package helper;

import model.PositionedItem;

import java.util.List;

public class Calculator {

    public static int getDistance(PositionedItem source, PositionedItem target) {
        return -(Math.abs(source.getX() - target.getX()) + Math.abs(source.getY() - target.getY()));
    }

    public static int getBestScore(PositionedItem source, List<PositionedItem> items) {
        int bestScore = Integer.MIN_VALUE;
        for (PositionedItem item : items) {
            int score = Calculator.getDistance(source, item);
            if (score > bestScore) {
                bestScore = score;
            }
        }
        return bestScore;
    }

}
