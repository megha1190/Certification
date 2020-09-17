 package com.megha.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid ;
    private final int n ;
    private final WeightedQuickUnionUF weightedQuickUnionUF ;
    private int numberOfOpenSites = 0 ;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)
    {
        int totalElements;
        if (n<=0)
            throw new IllegalArgumentException();
        this.grid = new boolean[n][n];
        this.n = n;
        totalElements = n*n +2;
        this.weightedQuickUnionUF = new WeightedQuickUnionUF(totalElements);
        for (int i = 0; i < n; i++)
            for (int j = 0 ; j < n ; j++)
                grid[i][j]=false;
       // code to connect Bottom/ top virtual element to last/first row
        for (int i = 1; i <= n; i++) {
            weightedQuickUnionUF.union(0, i);
            weightedQuickUnionUF.union(totalElements - 1, totalElements - 1 - i);
        }

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
        if (row < 1 || row > this.n || col < 1 || col > this.n)
            throw new IllegalArgumentException();
        if (!isOpen(row,col)) {
            int rowModified = row-1;
            int colModified = col-1;
            grid[rowModified][colModified] = true;
            this.numberOfOpenSites++;
            // connect the open site to adjacent sites if they are open
            if (row != 1 && isOpen(row - 1, col)) {
                weightedQuickUnionUF.union(get1D(rowModified - 1, colModified), get1D(rowModified, colModified));
            }
            if (row != this.n && isOpen(row + 1, col)) {
                weightedQuickUnionUF.union(get1D(rowModified, colModified), get1D(rowModified + 1, colModified));
            }
            if (col != 1 && isOpen(row, col - 1)) {
                weightedQuickUnionUF.union(get1D(rowModified, colModified - 1), get1D(rowModified, colModified));
            }
            if (col != this.n && isOpen(row, col + 1)) {
                weightedQuickUnionUF.union(get1D(rowModified, colModified), get1D(rowModified, colModified + 1));
            }
        }


    }

    private int get1D(int i, int j) {
        return ( i * n ) + j + 1;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException();
        return grid[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException();
        if (!isOpen(row,col) )
            return false;
        else
        {
            int pid = weightedQuickUnionUF.find(0);
            int givenSiteId = weightedQuickUnionUF.find(get1D(row-1, col-1));
            return pid== givenSiteId;
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return this.numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates()
    {
        int first = weightedQuickUnionUF.find(0);
        int last = weightedQuickUnionUF.find(n*n+1);
        return first==last;
    }
}
