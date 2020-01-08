import java.util.concurrent.ThreadLocalRandom;

public class model {
    private char [][] board;
    private static final int ROWS = 3;
    private static final int COLMUNS = 3;
    private int movesCount;
    private boolean isWinnerPlayer;
    private boolean isWinnerComp;
    private int compR;          //the row that the computer played its move on
    private int compC;         //the column that the computer played its move on

    public model(){
        this.board = new char [ROWS][COLMUNS];
        this.movesCount = 9;
        this.isWinnerPlayer = false;
        this.isWinnerComp =false;
    }

    public void initBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j<COLMUNS; j++){
                board[i][j] = ' ';
            }

        }

    }

    public void resetBoard(){

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j<COLMUNS; j++){
                board[i][j] = ' ';
            }

        }

        this.movesCount = 9;
        this.isWinnerPlayer = false;
        this.isWinnerComp =false;


    }

    public void playMoveComputer(){

        if(movesCount > 0) {


            movesCount--;

            if (!computerCanWin()) {
                if (!playerCanWin()) {
                    makeRandomMove();
                }
            }


            if (isWinner(compR, compC, 'O'))
                isWinnerComp = true;

        }

    }

    public boolean checkWinnerComp(){
        return isWinnerComp;
    }


    public int playMovePlayer(int r, int c){

        if( r > ROWS-1 || c > COLMUNS-1)
            return  0;

        if(board[r][c] != ' '){
            return 1;
        }else{
            board[r][c] = 'X';
            movesCount--;
            isWinnerPlayer = isWinner(r,c,'X');
        }

        return 2;
    }

    public boolean checkWinnerPlayer(){
        return isWinnerPlayer;
    }



    private boolean computerCanWin(){
        for (int i=0; i< ROWS; i++) {
            for (int j=0; j< COLMUNS; j++) {
                if (board[i][ (j + 1)%3] == 'O' && board[i][(j + 2)%3] == 'O' && board[i][j] == ' ') {
                    board[i][j] = 'O';
                    compR = i;
                    compC = j;
                    return true;
                } else if (board[(i + 1)%3][j] == 'O' && board[(i + 2)%3][j] == 'O' && board[i][j] == ' '){
                    board[i][j] = 'O';
                    compR = i;
                    compC = j;
                    return true;
                }
                else if (board[(i + 1)%3][(j+1)%3] == 'O' && board[(i + 2)%3][(j+2)%3] == 'O' && board[i][j] == ' '){
                    board[i][j] = 'O';
                    compR = i;
                    compC = j;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean playerCanWin(){
        for (int i=0; i< ROWS; i++) {
            for (int j=0; j< COLMUNS; j++) {
                if (board[i][ (j + 1)%3] == 'X' && board[i][(j + 2)%3] == 'X' && board[i][j] == ' ') {
                    board[i][j] = 'O';
                    compR = i;
                    compC = j;
                    return true;
                } else if (board[(i + 1)%3][j] == 'X' && board[(i + 2)%3][j] == 'X' && board[i][j] == ' '){
                    board[i][j] = 'O';
                    compR = i;
                    compC = j;
                    return true;
                }
                else if (board[(i + 1)%3][(j+1)%3] == 'X' && board[(i + 2)%3][(j+2)%3] == 'X' && board[i][j] == ' '){
                    board[i][j] = 'O';
                    compR = i;
                    compC = j;
                    return true;
                }
            }
        }
        return  false;
    }

    private void makeRandomMove(){

        boolean done = false;
        int min = 0;
        int max = 2;
        int randomRow, randomCol;

        do {
            randomRow = ThreadLocalRandom.current().nextInt(min, max + 1);
            randomCol = ThreadLocalRandom.current().nextInt(min, max + 1);

            if(board[randomRow][randomCol] == ' ')
            {
                board[randomRow][randomCol] = 'O';
                compR = randomRow;
                compC = randomCol;
                done = true;
            }


        }while (!done);

    }

    public int getMovesCount() {
        return movesCount;
    }

    public void setMovesCount(int movesCount) {
        this.movesCount = movesCount;
    }

    public char[][] getBoard() {
        return board;
    }


    private boolean isWinner(int r, int c, char symbol) {
        int countRow = 0;
        int countCol = 0;
        int countLDiag = 0;
        int countRDiag = 0;

        for(int i=0; i<board.length;i++) {
            if(board[r][i] == symbol)
                countRow++;
            if(board[i][c] == symbol)
                countCol++;
            if(board[i][i] == symbol)
                countRDiag++;
            if(board[board.length-1-i][i] == symbol)
                countLDiag++;
        }

        return countCol == board.length || countRow == board.length || countLDiag == board.length || countRDiag == board.length;
    }


}

