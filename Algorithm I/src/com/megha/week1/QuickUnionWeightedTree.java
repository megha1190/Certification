package com.megha.week1;

public class QuickUnionWeightedTree {
    private int id[];
    private int size[];
    public QuickUnionWeightedTree(int totalCount)
    {
        id = new int[totalCount];
        size = new int[totalCount];
        for(int i =0;i<totalCount;i++)
        {
            id[i] = i;
            size[i] = 1;
        }
    }
    public static void main(String args[])
    {
        QuickUnionWeightedTree obj = new QuickUnionWeightedTree(10);
        obj.printArray();
        obj.union(4,3);
        obj.printArray();
        obj.union(3,8);
        obj.printArray();
        obj.union(6,5);
        obj.printArray();

    }

    private void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if(pRoot == qRoot)return;
        if(size[pRoot] < size[qRoot])
        {
            id[pRoot]=qRoot;
            size[qRoot] += size[pRoot];
        }
        else
        {
            id[qRoot]=pRoot;
            size[pRoot] += size[qRoot];
        }

    }

    private int root(int i) {
        while(i!=id[i])
            i=id[i];
        return i;
    }

    private void printArray() {
        for (int i :
                this.id) {
            System.out.print(i +"\t");
        }
        System.out.println();
    }
}
