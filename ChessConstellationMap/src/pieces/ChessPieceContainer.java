package pieces;

import util.Color;

public abstract class ChessPieceContainer {
    
    /*
     * Temporary identifiers to instantiate each variant of each chess piece
     * exactly once
     */
    // TODO Pieces have to be available in a separate, globally accessible
    // way in case a Pawn moves through to the end and can now become a
    // Queen, Rook,...
    
    private final static Pawn blackPawn = new Pawn(Color.BLACK);
    private final static Pawn whitePawn = new Pawn(Color.WHITE);
    
    private final static Rook blackRook = new Rook(Color.BLACK);
    private final static Rook whiteRook = new Rook(Color.WHITE);
    
    private final static Knight blackKnight = new Knight(Color.BLACK);
    private final static Knight whiteKnight = new Knight(Color.WHITE);
    
    private final static Bishop blackBishop = new Bishop(Color.BLACK);
    private final static Bishop whiteBishop = new Bishop(Color.WHITE);
    
    private final static King blackKing = new King(Color.BLACK);
    private final static King whiteKing = new King(Color.WHITE);
    
    private final static Queen blackQueen = new Queen(Color.BLACK);
    private final static Queen whiteQueen = new Queen(Color.WHITE);
    
    public static Pawn getBlackpawn() {
	return blackPawn;
    }
    
    public static Pawn getWhitepawn() {
	return whitePawn;
    }
    
    public static Rook getBlackrook() {
	return blackRook;
    }
    
    public static Rook getWhiterook() {
	return whiteRook;
    }
    
    public static Knight getBlackknight() {
	return blackKnight;
    }
    
    public static Knight getWhiteknight() {
	return whiteKnight;
    }
    
    public static Bishop getBlackbishop() {
	return blackBishop;
    }
    
    public static Bishop getWhitebishop() {
	return whiteBishop;
    }
    
    public static King getBlackking() {
	return blackKing;
    }
    
    public static King getWhiteking() {
	return whiteKing;
    }
    
    public static Queen getBlackqueen() {
	return blackQueen;
    }
    
    public static Queen getWhitequeen() {
	return whiteQueen;
    }
}
