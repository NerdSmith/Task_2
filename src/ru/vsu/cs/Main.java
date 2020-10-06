package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    private static ChessCoordinate readCoordinate(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter the %s coordinate: ", name);
        return new ChessCoordinate(scanner.next());
    }

    private static boolean checkPawn(ChessCoordinate from, ChessCoordinate to) {
        return (from.x == to.x) && ((from.y+1 == to.y) || (from.y+2 == to.y));
    }

    private static boolean checkKnight(ChessCoordinate from, ChessCoordinate to) {
        return (((from.x+1 == to.x) || (from.x-1 == to.x)) && ((from.y+2 == to.y) || (from.y-2 == to.y))) ||
                (((from.x+2 == to.x) || (from.x-2 == to.x)) && ((from.y+1 == to.y) || (from.y-1 == to.y)));
    }

    private static boolean checkBishop(ChessCoordinate from, ChessCoordinate to) {
        return Math.abs(to.x - from.x) == Math.abs(to.y - from.y) && ((from.x != to.x) && (from.y != to.y));
    }

    private static boolean checkCastle(ChessCoordinate from, ChessCoordinate to) {
        return ((from.x != to.x) && (from.y == to.y)) || ((from.y != to.y) && (from.x == to.x));
    }

    private static boolean checkQueen(ChessCoordinate from, ChessCoordinate to) {
        return checkCastle(from, to) || checkBishop(from, to);
    }

    private static boolean checkKing(ChessCoordinate from, ChessCoordinate to) {
        return ((Math.abs(to.x - from.x) <= 1) && (Math.abs(to.y - from.y) <= 1))
                && ((from.x != to.x) || (from.y != to.y));
    }

    private static String selectChessmen(ChessCoordinate firstCoordinate, ChessCoordinate secondCoordinate) {
        StringBuilder result = new StringBuilder();

        if (checkPawn(firstCoordinate, secondCoordinate)) result.append("Pawn ");
        if (checkKnight(firstCoordinate, secondCoordinate)) result.append("Knight ");
        if (checkBishop(firstCoordinate, secondCoordinate)) result.append("Bishop ");
        if (checkCastle(firstCoordinate, secondCoordinate)) result.append("Castle ");
        if (checkQueen(firstCoordinate, secondCoordinate)) result.append("Queen ");
        if (checkKing(firstCoordinate, secondCoordinate)) result.append("King ");

        return result.toString();
    }

    public static void main(String[] args) {

        ChessCoordinate firstCoordinate = readCoordinate("first");
        ChessCoordinate secondCoordinate = readCoordinate("second");

        System.out.print(selectChessmen(firstCoordinate, secondCoordinate));
    }
}
