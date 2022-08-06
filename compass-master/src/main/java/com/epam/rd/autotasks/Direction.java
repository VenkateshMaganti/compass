package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        //throw new UnsupportedOperationException();
        degrees = angleDegree(degrees);
        Direction direction = null;
        if (degrees == 0) {
            direction = Direction.N;
        } else if (degrees == 45) {
            direction = Direction.NE;
        } else if (degrees == 90) {
            direction = Direction.E;
        } else if (degrees == 135) {
            direction = Direction.SE;
        } else if (degrees == 180) {
            direction = Direction.S;
        } else if (degrees == 225) {
            direction = Direction.SW;
        } else if (degrees == 270) {
            direction = Direction.W;
        } else if (degrees == 315) {
            direction = Direction.NW;
        }
        return direction;
    }

    private static int angleDegree(int degrees) {
        if (degrees < 0) {
            degrees = 360 + degrees;
        }
        degrees = degrees % 360;
        return degrees;
    }

    public static Direction closestToDegrees(int degrees) {
        //throw new UnsupportedOperationException();
        degrees = angleDegree(degrees);
        Direction direction = null;
        if ((degrees >= 0 && degrees < 22) || (degrees > 337 && degrees <= 359)) {
            direction = Direction.N;
        } else if (degrees > 22 && degrees < 67) {
            direction = Direction.NE;
        } else if (degrees > 67 && degrees < 112) {
            direction = Direction.E;
        } else if (degrees > 112 && degrees < 157) {
            direction = Direction.SE;
        } else if (degrees > 157 && degrees < 202) {
            direction = Direction.S;
        } else if (degrees > 202 && degrees < 247) {
            direction = Direction.SW;
        } else if (degrees > 247 && degrees < 292) {
            direction = Direction.W;
        } else if (degrees > 292 && degrees < 337) {
            direction = Direction.NW;
        }
        return direction;
    }

    public Direction opposite() {
        //throw new UnsupportedOperationException();
        this.degrees = angleDegree(degrees);
        Direction direction = null;
        if (degrees == 0) {
            direction = Direction.S;
        } else if (degrees == 45) {
            direction = Direction.SW;
        } else if (degrees == 90) {
            direction = Direction.W;
        } else if (degrees == 135) {
            direction = Direction.NW;
        } else if (degrees == 180) {
            direction = Direction.N;
        } else if (degrees == 225) {
            direction = Direction.NE;
        } else if (degrees == 270) {
            direction = Direction.E;
        } else if (degrees == 315) {
            direction = Direction.SE;
        }
        return direction;
    }

    public int differenceDegreesTo(Direction direction) {
        //throw new UnsupportedOperationException();
        int degree = angleDegree(this.degrees);
        int diffDegree = angleDegree(direction.degrees);
        if (degree == 0) {
            return Math.min(Math.abs(degree - diffDegree), Math.abs(360 - diffDegree));
        } else {
            return Math.abs(degree - diffDegree);
        }
    }
}
