import java.util.Scanner;

public class view{

    public int getInputRow() {

        System.out.println("Row: ");
        Scanner in = new Scanner(System.in);

        return in.nextInt();

    }

    public int getInputCol(){

        System.out.println("Col: ");
        Scanner in = new Scanner(System.in);
        int colNo;
        colNo = in.nextInt();


        return colNo;


    }

    public void printBoard(char[][] Board) {
        String strBoard = "    ";

        for(int l = 0; l< Board.length; l++)
            strBoard += "   "+ l + "  ";

        strBoard += "\n";

        for (int i = 0; i < Board.length; i++) {

            for (int j = 0; j<Board.length; j++){
                if(j == 0)
                    strBoard += i + "   ";
                if(j != Board.length-1)
                    strBoard +=  "  " + Board[i][j] + "  |";
                else
                    strBoard += "  "  + Board[i][j];
            }

            if(i != Board.length-1)
                strBoard += "\n    -----+-----+-----\n";
        }
        System.out.println(strBoard);
    }

    public void displayErrorMsg(int error){

        switch (error){
            case 0:
                System.out.println("Wrong Input! Out of bound! Please Try Again!!\n");
                break;

            case 1:
                System.out.println("Box is already filled! Please choose another box!!\n");
                break;
            default:
                System.out.println("Error!!");
        }
        //System.out.println("Wrong Input!! Please Try Again!!");
        //  System.out.println("Box is already filled! Please choose another box!!\n");
    }

    public void displayWinnerMsg(int winner){

        switch(winner) {
            case 0:
                System.out.println("YOU WON!!");
                break;
            case 1:
                System.out.println("YOU LOST!!");
                break;
            case 2:
                System.out.println("TIE!!");
                break;
        }

    }

    public void displayStartMsg(){
        System.out.println("Welcome to Tic Tac Toe Game!\n");
        System.out.println("YOU: X        COMPUTER: O");
    }

    public boolean getRematchInput(){
        System.out.println("Would you like to rematch? Y/n");

        Scanner sc = new Scanner(System.in);
        // Character input
        char c = sc.next().charAt(0);

        return (Character.toLowerCase(c) == 'y');

    }


}