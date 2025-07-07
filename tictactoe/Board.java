package tictactoe;

public class Board {
    int size;
    PlayingPiece[][] board;

    int freeCellsCount;


    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
        this.freeCellsCount=size*size;

    }
    public void setFreeCellsCount(int freeCellsCount) {
        this.freeCellsCount = freeCellsCount;
    }

    public int getFreeCellsCount() {
        return freeCellsCount;
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public boolean addPiece(int row,int col,PlayingPiece piece){
        if(row<0||row>=size||col<0||col>=size){
            System.out.println("Invalid Input");
            return false;
        }
        if(board[row][col]==null){
            board[row][col]=piece;
            return true;
        }else{
            System.out.println("This position is already occupied");
            return false;
        }
    }

    public void showBoard(){
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i][j]!=null){
                    System.out.print(" "+board[i][j].getPieceType()+" ");
                }else{
                    System.out.print(" " +"E"+ " ");
                }


            }
            System.out.println();
        }
    }
}
