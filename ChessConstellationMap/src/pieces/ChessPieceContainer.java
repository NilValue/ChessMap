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
    
    private final static Horse blackHorse = new Horse(Color.BLACK);
    private final static Horse whiteHorse = new Horse(Color.WHITE);
    
    private final static Bishop blackBishop = new Bishop(Color.BLACK);
    private final static Bishop whiteBishop = new Bishop(Color.WHITE);
    
    private final static King blackKing = new King(Color.BLACK);
    private final static King whiteKing = new King(Color.WHITE);
    
    private final static Queen blackQueen = new Queen(Color.BLACK);
    private final static Queen whiteQueen = new Queen(Color.WHITE);
    
    public static Pawn getBlackPawn() {
	return ChessPieceContainer.blackPawn;
    }
    
    public static Pawn getWhitePawn() {
	return ChessPieceContainer.whitePawn;
    }
    
    public static Rook getBlackRook() {
	return ChessPieceContainer.blackRook;
    }
    
    public static Rook getWhiteRook() {
	return ChessPieceContainer.whiteRook;
    }
    
    public static Horse getBlackHorse() {
	return ChessPieceContainer.blackHorse;
    }
    
    public static Horse getWhiteHorse() {
	return ChessPieceContainer.whiteHorse;
    }
    
    public static Bishop getBlackBishop() {
	return ChessPieceContainer.blackBishop;
    }
    
    public static Bishop getWhiteBishop() {
	return ChessPieceContainer.whiteBishop;
    }
    
    public static King getBlackKing() {
	return ChessPieceContainer.blackKing;
    }
    
    public static King getWhiteKing() {
	return ChessPieceContainer.whiteKing;
    }
    
    public static Queen getBlackQueen() {
	return ChessPieceContainer.blackQueen;
    }
    
    public static Queen getWhiteQueen() {
	return ChessPieceContainer.whiteQueen;
    }
}
