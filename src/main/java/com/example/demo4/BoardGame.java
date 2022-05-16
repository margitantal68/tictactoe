package com.example.demo4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;

// View + Controller
public class BoardGame extends GridPane {
    private Board board;
    private Field[][] boardView;
    private int size;
    private int currentPlayer; // 0 - 1. player, 1 - 2. player

    public BoardGame(Board board){
        this.board = board;
        this.size = board.getSize();
        boardView = new Field[ size ][ size ];
        createView();
    }

    private void createView(){
        for(int i=0; i<size; ++i){
            for(int j=0; j<size; ++j){
                boardView[i][j] = new Field(i, j);
                boardView[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        handleButtonPressed(actionEvent);
                    }
                });
                this.add(boardView[i][j], j, i);
            }
        }

    }

    private void handleButtonPressed(ActionEvent event){
        Field source = (Field) event.getSource();
        int row = source.getRow();
        int column = source.getColumn();
        System.out.printf("%d,%d\n", row, column);
        if( board.isEmpty(row, column)){
            board.setPosition(row, column, currentPlayer);
            boardView[row][column].setText("" + currentPlayer);
            if( board.isGameOver(row, column, currentPlayer) ){
                showGameOver("Player " + currentPlayer + " is the winner!");
                exitGame();
            }
            if( board.isDraw() ){
                showGameOver("Draw");
                exitGame();
            }
            currentPlayer = 1 -currentPlayer;
        }
    }

    private void showGameOver(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Over!");
        alert.setContentText(message);
        alert.showAndWait();

    }

    private void exitGame(){
        Platform.exit();
        System.exit(0);
    }
}
