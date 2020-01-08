public class controller {

    private view v;
    private model m;

    public controller() {
        v = new view();
        m = new model();
    }

    public void play() {

        char[][] board;
        int rowIn, colIn;
        boolean rematchFlag = false;
        int error;

        m.initBoard();
        v.displayStartMsg();

        do {

            do {
                board = m.getBoard();
                v.printBoard(board);

                rowIn = v.getInputRow();
                colIn = v.getInputCol();

                error = m.playMovePlayer(rowIn, colIn);

                if (error == 2) {
                    if (m.checkWinnerPlayer()) {
                        board = m.getBoard();
                        v.printBoard(board);
                        v.displayWinnerMsg(0);
                        break;
                    } else {
                        m.playMoveComputer();
                        if (m.checkWinnerComp()) {
                            board = m.getBoard();
                            v.printBoard(board);
                            v.displayWinnerMsg(1);
                            break;
                        }
                    }
                } else {
                    v.displayErrorMsg(error);
                }


            } while (m.getMovesCount() > 0);


            if (m.getMovesCount() == 0) {
                board = m.getBoard();
                v.printBoard(board);
                v.displayWinnerMsg(2);
            }


            rematchFlag = v.getRematchInput();
            m.resetBoard();


        } while (rematchFlag);


    }
}
