package tictactoe;

import java.io.InputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    Board board;

    Deque<Player> players;

    Player activePlayer;


    public Game(int size) {
        this.board = new Board(size);
        players=new LinkedList<>();
        initialise();
    }

    public void initialise(){
        Player player1=new Player(1,"Abhi",new PlayingPiece(PieceType.X));
        Player player2=new Player(2,"Adam",new PlayingPiece(PieceType.O));
        players.add(player1);
        players.add(player2);
    }

    public void startGame(){
        boolean winner=false;
        while (!winner){
            Player player=players.removeFirst();
            boolean playerPlacedPieceSuccessfully=false;
            while (!playerPlacedPieceSuccessfully) {
                System.out.println(player.name+" turn: Enter row and col ");
                Scanner sc = new Scanner(System.in);
                int row = sc.nextInt();
                int col = sc.nextInt();
                playerPlacedPieceSuccessfully = board.addPiece(row, col, player.getPiece());

                if(playerPlacedPieceSuccessfully)
                {

                    winner=doWeHaveWinner(row,col);
                    board.showBoard();
                    if(winner){
                        System.out.println("Game is won by "+ player.getName());
                    }else{
                        int freeCellsCount=board.getFreeCellsCount();
                        board.setFreeCellsCount(freeCellsCount-1);
                        if(freeCellsCount-1==0)
                        {
                            System.out.println("Game is tied");
                            winner=true; // stop game
                        }
                    }

                }
            }
            players.addLast(player);

        }


    }
    public boolean doWeHaveWinner(int r,int c){
        // check all rows
        int size= board.getSize();

        PlayingPiece[][] gameBoard=board.getBoard();

        PlayingPiece piece=gameBoard[r][c];
        PieceType pieceType=piece.getPieceType();

        int rowCount=0;
        int colCount=0;
        int diagonalCount=0;
        int diagonal2Count=0;
        for(int i=0;i<size;i++){
            if(gameBoard[r][i]==null||gameBoard[r][i].getPieceType()!=pieceType){
                break;
            }else{
                rowCount++;
            }
        }

        if(rowCount==size)
            return true;
        // check all cols
        for(int i=0;i<size;i++){
            if(gameBoard[i][c]==null||gameBoard[i][c].getPieceType()!=pieceType){
                break;
            }else{
                colCount++;
            }
        }

        if(colCount==size)
        {
            return true;
        }
        // check diagonal 1
        if(r==c){
            for(int i=0;i<size;i++){
                if(gameBoard[i][i]==null||gameBoard[i][i].getPieceType()!=pieceType){
                    break;
                }else{
                    diagonalCount++;
                }
            }

            if(diagonalCount==size){
                return true;
            }
        }
        // check diagonal 2
        if(r==size-c-1){
            for(int i=0;i<size;i++){
                if(gameBoard[i][size-i-1]==null||gameBoard[i][size-i-1].getPieceType()!=pieceType){
                    break;
                }else{
                    diagonal2Count++;
                }
            }

            if(diagonal2Count==size)
            {
                return true;
            }
        }

        return false;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

}
