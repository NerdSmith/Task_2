package ru.vsu.cs;

public class ChessCoordinate {
    char x;
    char y;

    public ChessCoordinate(String coordinate) {
        this.x = coordinate.charAt(0);
        this.y = coordinate.charAt(1);
    }
}
