package com.example.demo4;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Field extends Button {
    private int row, column;

    public Field(int row, int column){
        this.row = row;
        this.column = column;
        this.setFont(new Font(26));
        this.setPrefHeight(100);
        this.setPrefWidth(80);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
