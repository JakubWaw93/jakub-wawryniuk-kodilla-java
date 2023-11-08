package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumberExterminator {

    public List<Integer> exterminate(List<Integer> numbers){
        ArrayList<Integer> evenList = new ArrayList<>();
           for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 == 0) {
                    evenList.add(numbers.get(i));
                }
           }
        return evenList;
    }
}
