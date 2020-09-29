package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    private static ChessCoordinate enterCoordinate(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter the %s coordinate: ", name);
        return new ChessCoordinate(scanner.next());
    }

    private static boolean checkPawn(ChessCoordinate from, ChessCoordinate to){
        return (from.x == to.x) && ((from.y+1 == to.y) || (from.y+2 == to.y));
    }

    private static boolean checkKnight(ChessCoordinate from, ChessCoordinate to){
        return (((from.x+1==to.x) || (from.x-1==to.x)) && ((from.y+2==to.y) || (from.y-2==to.y))) ||
                (((from.x+2==to.x) || (from.x-2==to.x)) && ((from.y+1==to.y) || (from.y-1==to.y)));
    }

    private static boolean checkBishop(ChessCoordinate from, ChessCoordinate to){
        return Math.abs(to.x - from.x) == Math.abs(to.y - from.y) && ((from.x != to.x) && (from.y != to.y));
    }

    private static boolean checkCastle(ChessCoordinate from, ChessCoordinate to){
        return ((from.x != to.x) && (from.y == to.y)) || ((from.y != to.y) && (from.x == to.x));
    }

    private static boolean checkQueen(ChessCoordinate from, ChessCoordinate to){
        return checkCastle(from, to) || checkBishop(from, to);
    }

    private static boolean checkKing(ChessCoordinate from, ChessCoordinate to){
        return ((Math.abs(to.x - from.x) <= 1) && (Math.abs(to.y - from.y) <= 1))
                && ((from.x != to.x) || (from.y != to.y));
    }

    private static String selectFigures(ChessCoordinate firstCoordinate, ChessCoordinate secondCoordinate){
        String result = "";
        if (checkPawn(firstCoordinate, secondCoordinate)){
            result += "Pawn ";
        }
        if (checkKnight(firstCoordinate, secondCoordinate)){
            result += "Knight ";
        }
        if (checkBishop(firstCoordinate, secondCoordinate)){
            result += "Bishop ";
        }
        if (checkCastle(firstCoordinate, secondCoordinate)){
            result += "Castle ";
        }
        if (checkQueen(firstCoordinate, secondCoordinate)){
            result += "Queen ";
        }
        if (checkKing(firstCoordinate, secondCoordinate)){
            result += "King ";
        }
        return result;
    }

    public static void main(String[] args) {

        ChessCoordinate firstCoordinate = enterCoordinate("first");
        ChessCoordinate secondCoordinate = enterCoordinate("second");

        System.out.print(selectFigures(firstCoordinate, secondCoordinate));
    }
}
