package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes,
 * where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 * 
 * numberOfBoxesi is the number of boxes of type i. numberOfUnitsPerBoxi is the number of units in
 * each box of the type i. You are also given an integer truckSize, which is the maximum number of
 * boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the
 * number of boxes does not exceed truckSize.
 * 
 * Return the maximum total number of units that can be put on the truck.
 */
public class LC1710 {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    List<BoxType> boxTypeList = new ArrayList<>();

    for (int[] boxType : boxTypes) {
      boxTypeList.add(new BoxType(boxType[0], boxType[1]));
    }

    Collections.sort(boxTypeList,
        (BoxType bt1, BoxType bt2) -> Integer.compare(bt1.numUnitsPerBox, bt2.numUnitsPerBox));

    int currentUnits = 0;
    int currentBoxTypePointer = boxTypeList.size() - 1;

    for (int i = 0; i < truckSize; i++) {
      if (currentBoxTypePointer < 0) {
        break;
      }
      BoxType boxType = boxTypeList.get(currentBoxTypePointer);
      currentUnits += boxType.numUnitsPerBox;
      boxType.numBoxes -= 1;
      if (boxType.numBoxes == 0) {
        currentBoxTypePointer -= 1;
      }
    }

    return currentUnits;
  }

  public static class BoxType {
    int numBoxes;
    int numUnitsPerBox;

    public BoxType(int numBoxes, int numUnitsPerBox) {
      this.numBoxes = numBoxes;
      this.numUnitsPerBox = numUnitsPerBox;
    }
  }
}
