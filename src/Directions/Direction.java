package Directions;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction oppositeDirection(Direction direction) {
        if (direction == null)
            throw new IllegalArgumentException("direction value is null!");

        switch (direction) {
            case NORTH:
                return Direction.SOUTH;
            case EAST:
                return Direction.WEST;
            case SOUTH:
                return Direction.NORTH;
            default://this default must be Direction.WEST
                return Direction.EAST;
        }
    }

    public static Direction turnRight(Direction direction) {
        if (direction == null)
            throw new IllegalArgumentException("direction value is null!");

        switch (direction){
            case NORTH:
                return Direction.EAST;
            case EAST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.WEST;
            default://default here is always WEST
                return Direction.NORTH;
        }
    }

    public static Direction turnLeft(Direction direction) {
        if (direction == null)
            throw new IllegalArgumentException("direction value is null!");

        switch (direction){
            case NORTH:
                return Direction.WEST;
            case WEST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.EAST;
            default://default here is always EAST
                return Direction.NORTH;
        }
    }
}
