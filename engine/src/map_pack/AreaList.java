package map_pack;

import exception_pack.*;
import main_pack.Player;

import java.util.HashMap;
import java.util.Map;

public class AreaList {

    private HashMap<AreaName,Area> areaHashMap;

    public AreaList(int numberOfPlayer){
        areaHashMap = AreaInitialization.create(numberOfPlayer);
    }

    public int getSupplies(){
        int result = 0;
        for (Map.Entry<AreaName, Area> entry : areaHashMap.entrySet()){
            result += entry.getValue().getSupplies();
        }
        return result;
    }

    public int getVictory() throws VictoryException {
        int result = 0;
        for (Map.Entry<AreaName, Area> entry : areaHashMap.entrySet()){
            if(entry.getValue().hasVictoryPoint()) result += 1;
        }
        if (result >= 7) throw new VictoryException(areaTab[1].getOwner());
        return result;
    }

    public void addArea(Area area, Player newOwner){
        area.setOwner(newOwner);
        areaTab[numberOfArea] = area;
        numberOfArea++;
    }

    public void removeArea(Area area) throws AreaNotFoundException{
        int position = findArea(area);
        numberOfArea--;
        areaTab[position] = areaTab[numberOfArea];
    }

    private int findArea(Area area) throws AreaNotFoundException{
        int position = 0;
        for (Area tmp : areaTab){
            if (tmp == area) return position;
            position++;
        }
        throw new AreaNotFoundException(area);
    }

    public HashMap<AreaName, Area> getAreaHashMap() {
        return areaHashMap;
    }
}