import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        GameState state = new GameState();

        Scanner in = new Scanner(System.in);
        int numberMineSpots = in.nextInt();
        for (int i = 0; i < numberMineSpots; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
        }


        // game loop
        while (true) {
            state.player1.gold = in.nextInt();
            state.player1.income = in.nextInt();
            state.player2.gold = in.nextInt();
            state.player2.income = in.nextInt();
            for (int i = 0; i < 12; i++) {
                String line = in.next();
                //TODO: build map
            }
            int buildingCount = in.nextInt();
            for (int i = 0; i < buildingCount; i++) {
                PlayerState owner = in.nextInt() == 0 ? state.player1 : state.player2;
                owner.addBuilding(in.nextInt(),
                        in.nextInt(),
                        in.nextInt()
                );
            }
            int unitCount = in.nextInt();
            for (int i = 0; i < unitCount; i++) {
                PlayerState owner = in.nextInt() == 0 ? state.player1 : state.player2;
                owner.addUnit(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("WAIT");
        }
    }
}

class GameState {
    public GameState() {
        player1 = new PlayerState();
        player2 = new PlayerState();
    }

    PlayerState player1;
    PlayerState player2;
}

class PlayerState {
    PlayerState(){
        buildings = new ArrayList<>();
        units = new ArrayList<>();
    }
    int gold;
    int income;

    void addBuilding(int buildingType, int x, int y) {
        buildings.add(new BuildingState(this, buildingType, x, y));
    }

    Collection<BuildingState> buildings;
    Collection<UnitState> units;

    public void addUnit(int unitId, int level, int x, int y) {
        units.add(new UnitState(this, unitId, level, x, y));
    }
}

class BuildingState {
    BuildingState(PlayerState owner, int buildingType, int x, int y) {
        this.owner = owner;
        this.buildingType = buildingType;
        this.x = x;
        this.y = y;
    }

    PlayerState owner;
    int buildingType;
    int x;
    int y;
}

class UnitState {
    PlayerState owner;
    int unitId;
    int level;
    int x;
    int y;

    public UnitState(PlayerState owner, int unitId, int level, int x, int y) {
        this.owner = owner;
        this.unitId = unitId;
        this.level = level;
        this.x = x;
        this.y = y;
    }
}