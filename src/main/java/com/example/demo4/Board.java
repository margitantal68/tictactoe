package com.example.demo4;


// Model
public class Board {
    private int size;
    private int[][] table;
    private int counter; // foglalt cellak szama

    // -1 - ures; 0 - elso jatekos; 1 - masodik jatekos
    public Board(int size){
        this.size = size;
        table = new int[size][size];
        for(int i=0; i<size; ++i){
            for(int j=0; j<size; ++j){
                table[i][j] = -1;
            }
        }
    }

    public boolean isEmpty(int row, int column){
       if( row < 0 || row >= size ||column < 0 || column >= size){
          throw new IndexOutOfBoundsException("Index error: " + row + ", " + column);
       }
       return table[row][column] == -1;
    }

    public boolean setPosition(int row, int column, int player){
        if( !isEmpty(row, column)){
            return false;
        }
        table[row][column] = player;
        ++counter;
        return true;
    }

    public int getPosition(int row, int column){
        if( row < 0 || row >= size ||column < 0 || column >= size){
            throw new IndexOutOfBoundsException("Index error: " + row + ", " + column);
        }
        return table[row][column];
    }

    public int getSize(){
        return this.size;
    }

    public boolean isGameOver(int row, int column, int player){
        // @TODO Ellenorizni, hogy nyert-e a player jatekos
        // az utolso (row, column) pozicioba helyezett babujaval!

        return false;
    }

    public boolean isDraw(){
        return counter == size * size;
    }

}
