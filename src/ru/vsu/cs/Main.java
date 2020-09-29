package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    private static ChessCoordinates translateCoordinates(String s){
        int x = 1;
        char firstChar = s.charAt(0);
        int y = s.charAt(1) - '0';

        switch (firstChar){
            case 'a': x = 1;
            break;
            case 'b': x = 2;
            break;
            case 'c': x = 3;
            break;
            case 'd': x = 4;
            break;
            case 'e': x = 5;
            break;
            case 'f': x = 6;
            break;
            case 'g': x = 7;
            break;
            case 'h': x = 8;
            break;
        }
        return new ChessCoordinates(x, y);
    }

    private static boolean pawn(ChessCoordinates from, ChessCoordinates to){
        return (from.x == to.x) && ((from.y+1 == to.y) || (from.y+2 == to.y));
    }

    private static boolean knight(ChessCoordinates from, ChessCoordinates to){
        return (((from.x+1==to.x) || (from.x-1==to.x)) && ((from.y+2==to.y) || (from.y-2==to.y))) ||
                (((from.x+2==to.x) || (from.x-2==to.x)) && ((from.y+1==to.y) || (from.y-1==to.y)));
    }

    private static boolean bishop(ChessCoordinates from, ChessCoordinates to){
        return Math.abs(to.x - from.x) == Math.abs(to.y - from.y) && ((from.x != to.x) && (from.y != to.y));
    }

    private static boolean castle(ChessCoordinates from, ChessCoordinates to){
        return ((from.x != to.x) && (from.y == to.y)) || ((from.y != to.y) && (from.x == to.x));
    }

    private static boolean queen(ChessCoordinates from, ChessCoordinates to){
        return castle(from, to) || bishop(from, to);
    }

    private static boolean king(ChessCoordinates from, ChessCoordinates to){
        return ((to.x - from.x == 1) || (to.y - from.y == 1)) && ((from.x != to.x) && (from.y != to.y));
    }

    private static String figuresSelection(ChessCoordinates firstCoordinate, ChessCoordinates secondCoordinate){
        String result = "";
        if (pawn(firstCoordinate, secondCoordinate)){
            result += "Pawn ";
        }
        if (knight(firstCoordinate, secondCoordinate)){
            result += "Knight ";
        }
        if (bishop(firstCoordinate, secondCoordinate)){
            result += "Bishop ";
        }
        if (castle(firstCoordinate, secondCoordinate)){
            result += "Castle ";
        }
        if (queen(firstCoordinate, secondCoordinate)){
            result += "Queen ";
        }
        if (king(firstCoordinate, secondCoordinate)){
            result += "King ";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first coordinate: ");
        ChessCoordinates firstCoordinate = translateCoordinates(scanner.next());
        System.out.print("Enter the second coordinate: ");
        ChessCoordinates secondCoordinate = translateCoordinates(scanner.next());

        System.out.print(figuresSelection(firstCoordinate, secondCoordinate));
    }
}
