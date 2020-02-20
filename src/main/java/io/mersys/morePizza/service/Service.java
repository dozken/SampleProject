package io.mersys.morePizza.service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Service {

    int maxSlices;
    int[] slices;

    public List<Integer> doStuffSenesh() {
        List<Integer> collect = Arrays.stream(slices)
                .boxed()
                .collect(Collectors.toList());
        return solve(maxSlices, collect );
    }
    public static ArrayList<Integer> solve(Integer MAX, List<Integer> inputList) {

        ArrayList<Integer> solutionList = new ArrayList<Integer>(); // List to store the best solution

        Integer fullSize = inputList.size();
        Integer i;
        Integer j;
        Integer maxScore = 0;

        // Decrease the traversable size of the initial Pizza array in reverse order, by
        // 1 in each iteration
        for (j = fullSize - 1; j >= 0; j--) {

            Integer size = j;
            // Integer previousValue = 0;
            Integer sum = 0;
            ArrayList<Integer> currentList = new ArrayList<Integer>(); // List to store the solution at each iteration
            // of the loop

            // Traverse the current Pizza array in reverse order
            for (i = size; i >= 0; i--) {

                Integer currentValue = inputList.get(i);

                // Store the sum temporarily
                Integer tempSum = sum + currentValue;

                if (tempSum == MAX) { // If the temporary sum is equal to target
                    sum = tempSum;
                    currentList.add(i); // Add current Pizza index to the solution
                    break; // Go to return solution

                } else if (tempSum > MAX) { // If the temporary sum is greter than target
                    continue; // Try next value

                } else if (tempSum < MAX) { // If the temporary sum is lesser than target
                    sum = tempSum;
                    currentList.add(i); // Add current Pizza index to the solution
                    continue; // Try next value
                }
            }

            if (maxScore < sum) { // If current solution is the best
                maxScore = sum; // Keep its value
                solutionList = currentList; // Keep the solution
            }
        }

        // Print the score of the best solution (AKA the maximum number of slices)
        System.out.println("");
        System.out.println("");
        System.out.print("SCORE = ");
        System.out.println(maxScore);

        return solutionList; // Return best solution
    }

    public List<Integer> doStuffYeldar1() {
        //maxSlices
        //slices[]
        List<Integer> dpp = new ArrayList<>();

        int dp[] = new int[maxSlices + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < slices.length; i++) {
            for (int i1 = maxSlices - slices[i]; i1 >= 0; i1--) {
                if (dp[i1] != -1 && dp[i1+slices[i]] == -1) {
                    dp[i1+slices[i]] = i;
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        while (dp[maxSlices] == -1) {
            maxSlices--;
        }

        System.out.println(maxSlices);

        List<Integer> answers = new ArrayList<>();
        while (maxSlices != 0) {
            answers.add(dp[maxSlices]);
            maxSlices -= slices[dp[maxSlices]];
        }

        Collections.reverse(answers);
        int sum = answers.stream().mapToInt(x -> slices[x]).sum();
        System.out.println(">>>>>"+answers);
        System.out.println("sum >>>"+sum);
        return answers;
    }
    public List<Integer> doStuffYeldar() {
        //maxSlices
        //slices[]
        List<Integer> dpp = new ArrayList<>();
        for (int i = 0; i < maxSlices + 1; i++) {
            dpp.add(-1);
        }
//        int dp[] = new int[maxSlices + 1];
//        Arrays.fill(dp, -1);
        dpp.set(0, 0);
//        dp[0] = 0;

        for (int i = 0; i < slices.length; i++) {
            for (int i1 = maxSlices - slices[i]; i1 >= 0; i1--) {
                if (dpp.get(i1) != -1) {
                    dpp.set(i1 + slices[i], i);
                }
            }
        }

        while (dpp.get(maxSlices--) == -1) ;

        List<Integer> answers = new ArrayList<>();
        while (maxSlices != 0) {
            answers.add(dpp.get(maxSlices));
            maxSlices -= slices[dpp.get(maxSlices)];
        }

        System.out.println(">>>>>" + answers);
        Collections.reverse(answers);
        return answers;
    }

    public List<Integer> doStuffDos() {
        List<Integer> positions = new ArrayList<>();
        //printing
        System.out.printf("%d %d\n", maxSlices, slices.length);
        System.out.println(Arrays.toString(slices));
        //end printing

        int complement = maxSlices;

        int max = 0;
        for (int i = slices.length - 1; i >= 0; i--) {
            int candidate = complement - slices[i];
            if (candidate < 0) {
                continue;
            }
            complement = candidate;
            max += slices[i];
            if (max > maxSlices)
                break;

            positions.add(i);

        }

        System.out.println("Max slices: " + max);
        Collections.reverse(positions);
        return positions;

    }

    public void readInputFile(Path path) {
        //TODO read input file and assign constraints
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String[] settings = br.readLine().split(" ");
            this.maxSlices = Integer.parseInt(settings[0]);
            int typeCount = Integer.parseInt(settings[1]);

            this.slices = new int[typeCount];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                this.slices[i] = Integer.parseInt(str[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeOutputFile(Path path, List<Integer> obj) {
        //TODO write obj to output file
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(String.format("%d", obj.size()));
            writer.newLine();

            for (Integer i : obj) {
                writer.write(String.format("%d ", i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Integer> doStuffAdil(){
        Set<Integer> result = new HashSet<Integer>();

        //maxSlices
        //slices[]





        return new ArrayList<>(result);
    }
}
