package core;

import java.util.ArrayList;
import java.util.List;

public abstract class IdManager {
    
    protected IdManager() {
	IdManager.constellationIds = new ArrayList<String>();
    }
    
    private static ArrayList<String> constellationIds;
    
    public static ArrayList<String> getConstellationIds() {
	return IdManager.constellationIds;
    }
    
}
