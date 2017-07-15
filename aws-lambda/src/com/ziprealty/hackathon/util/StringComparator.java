package com.ziprealty.hackathon.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jamgale on 7/15/17.
 * This function approximates string matching using a Levenshtein distance algorithm
 */
public class StringComparator {

    public static int distance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),
                        a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String text = "In computer science, approximate string matching, "
//                + "often colloquially referred to as fuzzy string searching is the technique of finding strings that match a pattern approximately rather than exactly. "
//                + "The problem of approximate string matching is typically divided into two sub-problems: finding approximate substring matches inside a given string and finding "
//                + "dictionary strings that match the pattern approximately.";


        String text = "Bernside Petyr huzma connor hiptoe";
        System.out.println("System genetated string is: \n'" + text + "'");
        System.out.println("Enter the keyword to search: ");
        String keyword = sc.nextLine();
        String[] data = text.split(" ");
        List<Integer> dist = new ArrayList<Integer>();
        for (int i = 0; i < data.length; i++) {
            dist.add(distance(data[i], keyword));
        }
        Collections.sort(dist);
        System.out.print("Did you mean: ");
        for (int i = 0; i < data.length; i++) {
            if (distance(data[i], keyword) == dist.get(0)) {
                System.out.print(data[i] + ", ");
            }
        }
        sc.close();
    }
}

