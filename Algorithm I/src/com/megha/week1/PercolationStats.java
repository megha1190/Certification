 package com.megha.week1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import java.util.Scanner;

public class PercolationStats {

    // perform independent trials on grid an n-by-n
    private static final double CONFIDENCE_95= 1.96 ;
    private final int trials ;
    private final double []percolationThreshold ;
    public PercolationStats(int n, int trials)
    {
        Percolation percolation;
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        this.trials = trials;
        percolationThreshold = new double[trials];
        for (int i = 0; i < trials ; i++) {
            percolation = new Percolation(n);
            // System.out.println("For Trial "+(i+1)+",Before simulation numberOfOpenSites ="+this.percolation.numberOfOpenSites() );
            while (!percolation.percolates()) {
                int randomSite = StdRandom.uniform(1, n * n +1);
                randomSite = randomSite-1;
                int row = (randomSite / n) + 1;
                int col = (randomSite % n) + 1;
                // System.out.println(", random site choosen = "+(randomSite+1) +" Row = "+row + " Col= "+col);

                percolation.open(row, col);
            }
            int numberOfOpenSites = percolation.numberOfOpenSites();
            // System.out.println("For Trial "+(i+1)+", numberOfOpenSites ="+numberOfOpenSites );
            this.percolationThreshold[i] = (double)numberOfOpenSites /(n*n);
        }

    }

    // sample mean of percolation threshold
    public double mean()
    {
        return StdStats.mean(this.percolationThreshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev()
    {
        return StdStats.stddev(this.percolationThreshold);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo()
    {
        return (this.mean() - ((CONFIDENCE_95 * this.stddev())/Math.sqrt(this.trials)));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi()
    {
        return (this.mean() + ((CONFIDENCE_95 * this.stddev())/Math.sqrt(this.trials)));
    }

    // test client (see below)
    public static void main(String[] args)
    {
        System.out.println("Enter value for N and number of trials");
        Scanner scanner = new Scanner(System.in);
        String []tokens = scanner.nextLine().split(" ");
        int n =  Integer.parseInt(tokens[0]);

        int t =  Integer.parseInt(tokens[1]);
        PercolationStats  percolationStats = new PercolationStats(n,t);
        System.out.println("mean  \t  = " +percolationStats.mean());
        System.out.println("stddev  \t  = "+percolationStats.stddev());
        System.out.println("95% confidence interval  \t  = ["+percolationStats.confidenceLo()+","
        +percolationStats.confidenceHi()+"]");
    }
}
