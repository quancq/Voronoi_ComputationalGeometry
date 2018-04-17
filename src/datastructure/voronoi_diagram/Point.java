/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.voronoi_diagram;

import static java.lang.Math.abs;
//import static util.Math.EPSILON;
//import static util.Math.PRECISION;

/**
 *
 * @author quancq
 */
public class Point {
    // Point is either site or any point on planar subdivision
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
//        return "(" + x + "," + y + ")";
        return String.format(" (%.4f, %.4f)", x, y);
    }

//    @Override
//    public int hashCode() {
//        return (int) (x * PRECISION * 31) + (int) (y * PRECISION);
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;

//        return abs(x - other.x) <= EPSILON && abs(y - other.y) <= EPSILON;
        return x == other.x && y == other.y;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }
}

