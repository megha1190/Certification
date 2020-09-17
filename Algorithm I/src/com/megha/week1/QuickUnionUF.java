package com.megha.week1;

public class QuickUnionUF {
    private int id[];
    public QuickUnionUF(int totalCount)
    {
        id = new int[totalCount];
        for(int i =0;i<totalCount;i++)
        {
            id[i] = i;
        }
    }
    private boolean isConnected(int p, int q)
    {
        return id[p]==id[q];
    }
    private void printArray()
    {
        for (int i :
                this.id) {
            System.out.print(i +"\t");
        }
        System.out.println();

    }
    private int root(int i)
    {
        while(i!=id[i])
            i=id[i];
        return i;
    }
    private void union(int p, int q) {
       int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot]= qRoot;
;
    }
    public static void main(String args[])
    {
        QuickUnionUF obj = new QuickUnionUF(10);
        obj.printArray();
        obj.union(4,3);
        obj.printArray();
        obj.union(3,8);
        obj.printArray();
        obj.union(6,5);
        obj.printArray();

    }


}
