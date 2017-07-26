package house_pack;

import exception_pack.VictoryException;
import map_pack.*;
import military_pack.LeaderList;

public class House {
    private HouseName houseName;
    private int supplyTrack;
    private int victoryTrack;
    private AreaList areaList;
    private LeaderList leaderList;

    public House(int suppliesTrack, int victoryPath, HouseName name){
        this.supplyTrack = suppliesTrack;
        this.victoryTrack = victoryPath;
        this.houseName = name;
    }

    public void updateSupplyTrack(){
        supplyTrack = areaList.getSupplies();
    }

    public void updateVictoryTrack() throws VictoryException {
        victoryTrack = areaList.getVictory();
    }

    public HouseName getHouseName() {
        return houseName;
    }

    public AreaList getAreaList() {
        return areaList;
    }

    public LeaderList getLeaderList() {
        return leaderList;
    }

}
