package com.megha.week1;

public class QuickFindUF {

   private int id[];
    public QuickFindUF(int totalCount)
    {
        id = new int[totalCount];
        for(int i =0;i<totalCount;i++)
        {
            id[i] = i;
        }
    }
    public boolean isConnected(int p, int q)
    {
        return id[p]==id[q];
    }
    public void union(int p, int q)
    {
        System.out.println("joining "+p +" and "+q);
       if(!isConnected(p,q))
       {
           int pid = id[p];
           int qid = id[q];
           for(int i =0;i<id.length;i++)
           {
               if(id[i]==pid)
                   id[i]=qid;
           }
       }
    }
    public void printArray()
    {
        for (int i :
                this.id) {
            System.out.print(i +"\t");
        }
        System.out.println();

    }
    public static void main(String args[])
    {
        QuickFindUF obj = new QuickFindUF(10);
       obj.printArray();
        obj.union(4,3);
        obj.printArray();
        obj.union(3,8);
        obj.printArray();
        obj.union(6,5);
        obj.printArray();

    }
}
