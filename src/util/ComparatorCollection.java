/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import datastructure.beachline.Node;
import datastructure.event.Event;
import java.util.Comparator;

/**
 *
 * @author quancq
 */
public class ComparatorCollection {

    /**
     *
     */
    public static Comparator BEACH_LINE_ASCENDING_X_COMPARATOR = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            double value1 = ((Node) o1).getComparableValue();
            double value2 = ((Node) o2).getComparableValue();

            return Double.compare(value1, value2);
        }

    };
    
    public static Comparator EVENT_QUEUE_DESCENDING_Y_COMPARATOR = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            double y1 = ((Event) o1).getPoint().y;
            double y2 = ((Event) o2).getPoint().y;
            
            return Double.compare(y2, y1);
        }
    };
}
