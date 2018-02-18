package util;

public enum GameVersion {
    EUROPEAN(37, 7, 7, 3, 3),
    BRITISH(32, 7, 7, 3, 3);

    private int numberOfCounter;
    private int maxRow;
    private int maxColumn;
    private int startX;
    private int startY;

    GameVersion(int numberOfCounter, int maxRow, int maxColumn, int startX, int startY) {
        this.numberOfCounter = numberOfCounter;
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
        this.startX = startX;
        this.startY = startY;
    }

    public boolean[][] getBoard() {
        if (this == BRITISH) {
            return createBritishBoard();
        }

        return createEuropeanBoard();
    }

    private boolean[][] createEuropeanBoard() {
        boolean[][] board = createBritishBoard();
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                board[i][j] = true;
            }
        }
        return board;
    }

    private boolean[][] createBritishBoard() {
        boolean[][] board = new boolean[maxRow][maxColumn];
        for (int i = 2; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = true;
                board[j][i] = true;
            }
        }
        return board;
    }

    public int getNumberOfCounter() {
        return numberOfCounter;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public int getMaxColumn() {
        return maxColumn;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
}
