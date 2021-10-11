import java.util.*;

class Square {

  // Link: https://drive.google.com/file/d/1qXhUblIjrPzMKXKJeystXiBPlD-pg8T9/view
    // Link: https://drive.google.com/file/d/1i1oqsFp1li535DxIsgW38Kh_hsSl3AgY/view

    // The “+” operation is the merge operation. The rules for merging is as follows:
    // Black + Black -> Black
    // White + White -> White
    // Black + White -> Black
    // assumptioin that both square would be same size
 
  private List<List<Integer>> square;
  
  public Square(List<List<Integer>> square) {  // assuming lexicographically sorted for now
    this.square = square;  
  }
  
  public List<List<Integer>> getSquare() {
    return this.square;  // we can also return a copy of square here instead of reference to restrict class user to modify it directly
  }
  
  public Square merge(Square squareObj) {
    List<List<Integer>> ansList = new ArrayList<>();
    List<List<Integer>> obj = squareObj.getSquare();
    int ptr1 = 0, ptr2 = 0;
    int size1 = square.size();
    int size2 = obj.size();
    while (ptr1 < size1 && ptr2 < size2) {
      if (isLess(square.get(ptr1), obj.get(ptr2))) {
        // iterate over obj until square.get(ptr1) is a prefix
        ptr2 = iterateUntilPrefix(obj, ptr2, size2, square.get(ptr1));
        ansList.add(new ArrayList<>(square.get(ptr1++)));
      } else {
        // iterate over square until obj.get(ptr2) is a prefix
        ptr1 = iterateUntilPrefix(square, ptr1, size1, obj.get(ptr2));
        ansList.add(new ArrayList<>(obj.get(ptr2++)));
      }
    }
    while (ptr1 < size1) {
      ansList.add(new ArrayList<>(square.get(ptr1++)));
    }
    while (ptr2 < size2) {
      ansList.add(new ArrayList<>(obj.get(ptr2++)));
    }
    return new Square(ansList);
  }
  
  
  // iterate until list elements has comparison sequence as its prefix starting from itr upto limit itrLimit(which is size of list)
  private int iterateUntilPrefix(List<List<Integer>> list, int itr, int itrLimit, List<Integer> comparisonSequence) { 
    while (itr < itrLimit) {
      if (isPrefix(comparisonSequence, list.get(itr))) {
        itr++;
      } else {
        break;
      }
    }
    return itr;
  }

  // check if list1 is less than list2 lexicographically
  private boolean isLess(List<Integer> list1, List<Integer> list2) { 
    int ptr1 = 0, ptr2 = 0;
    int size1 = list1.size(), size2 = list2.size();
    if (size1 > size2) {
      return false;
    }
    while (ptr1 < size1 && ptr2 < size2) {
      if (list1.get(ptr1) < list2.get(ptr2)) {
        return true;
      } else if (list1.get(ptr1) > list2.get(ptr2)) {
        return false;
      }
      ptr1++;
      ptr2++;
    }
    return true;
  }

  // check is list1 is prefix of list2
  private boolean isPrefix(List<Integer> list1, List<Integer> list2) { 
    int ptr1 = 0, ptr2 = 0;
    int size1 = list1.size(), size2 = list2.size();
    if (size1 > size2) {
      return false;
    }
    while (ptr1 < size1 && ptr2 < size2) {
      if (list1.get(ptr1++) != list2.get(ptr2++)) {
        return false;
      }
    }
    return true;
  }
}

class Solution {

  /*
    1
    23
    234
    3
    43
  */
 
  public static void main(String[] args) {
    List<Integer> l11 = Arrays.asList(1, 2);
    List<Integer> l12 = Arrays.asList(1, 3, 4);
    List<Integer> l13 = Arrays.asList(3);
    
    List<Integer> l21 = Arrays.asList(1);
    List<Integer> l22 = Arrays.asList(2, 3);
    List<Integer> l23 = Arrays.asList(2, 3, 4);
    List<Integer> l24 = Arrays.asList(4, 3);
    
    Square obj1 = new Square(Arrays.asList(l11, l12, l13));
    Square obj2 = new Square(Arrays.asList(l21, l22, l23, l24));
    
    Square mergedSquare = obj1.merge(obj2);
    for (List<Integer> list : mergedSquare.getSquare()) {
      for (Integer element : list) {
        System.out.print(element);
      }
      System.out.println();
    }
  }
}