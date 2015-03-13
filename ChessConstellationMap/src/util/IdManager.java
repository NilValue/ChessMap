package util;

import java.util.Hashtable;

import core.Board;
import core.Constellation;

public class IdManager {
    public IdManager() {
	this.constellationsMap = new Hashtable<String, Constellation>();
    }
    
    private final Hashtable<String, Constellation> constellationsMap;
    
    public void addConstellation(Constellation constellation) {
	this.constellationsMap.putIfAbsent(constellation.getId(), constellation);
    }
    
    /**
     * @param id
     *        - The id of the constellation which is searched.
     * @return The constellation object which is associated with the id or null
     *         if there is no such object.
     */
    public Constellation getConstellation(String id) {
	return this.constellationsMap.get(id);
    }
    
    /**
     * @param constellation
     *        - The constellation for which an ID shall be generated.
     * @return An ID for the given constellation.<br/>
     *         Those IDs will become fairly long so String is the best type for
     *         them.<br/>
     *         Calls a private method because it might become handy to implement
     *         different types of IDs later on <br/>
     */
    public String generateId(Board board, Color movingPlayer) {
	return this.generateIdForMapGeneration(board, movingPlayer);
    }
    
    private String generateIdForMapGeneration(Board board, Color movingPlayer) {
	
    }
}
