package com.Q9Furniture;

class MetalChairs extends Chair
{
    {
        Type = "metal chair";
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
class WoodenChairs extends Chair
{
    {
        Type = "Wooden chair";
        StressProof_= "true";
        FireProof = "Noooo";
    }
    void getDetails()
    {
        System.out.println(Type);
        System.out.println("Stress Proof: "+StressProof_);
        System.out.println("Fire Proof: "+FireProof);
    }
}
class Chairs
{
    public static void main(String args[])
    {
        System.out.println("****METAL CHAIR DETAIL*********");
        MetalChairs m=new MetalChairs();
        m.getDetails();
        System.out.println("****WOODEN CHAIR DETAIL*********");
        WoodenChairs w=new WoodenChairs();
        w.getDetails();
    }
}