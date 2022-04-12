package BattleSimulation;

public enum Terrain {

    HILL(1),
    PLAINS(2),
    FOREST(3);
    private final int terrainNum;


    Terrain(int terrainNum) {
        this.terrainNum = terrainNum;
    }

    public int getTerrainNum() {
        return terrainNum;
    }
}
