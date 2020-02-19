package com.Q9Furniture;

class MetalTables extends Table
{
    {
        Type = "metal table";
        StressProof_= "true";
        FireProof = "true";
    }
    void getDetails()
    {
        System.out.println(Type);
        System.out.println("Stress Proof: "+StressProof_);
        System.out.println("Fire Proof: "+FireProof);
    }
}
class WoodenTables extends Table {
    {
        Type = "wooden table";
        StressProof_ = "true";
        FireProof = "Nooo";
    }
    void getDetails()
    {
        System.out.println(Type);
        System.out.println("Stress Proof: "+StressProof_);
        System.out.println("Fire Proof: "+FireProof);
    }
}
class Tables
{
    public static void main(String args[])
    {
        System.out.println("****METAL TABLE DETAIL*********");
        MetalTables m=new MetalTables();
        m.getDetails();
        System.out.println("****WOODEN TABLE DETAIL*********");
        WoodenTables w=new WoodenTables();
        w.getDetails();
    }
}