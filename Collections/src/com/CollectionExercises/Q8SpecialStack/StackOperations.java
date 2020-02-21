package com.CollectionExercises.Q8SpecialStack;

class StackOperations
{
    static final int MAX = 20;
    int top = -1;
    int a[] = new int[MAX];
    int minEle;

    boolean isEmpty()
    {
        return (top < 0);
    }

    public void isFull(){
        if (top >= (MAX - 1)) {
            System.out.println("Stack is full");
        }
        else{
            System.out.println("Stack is not full");
        }

    }

    void push(int x)
    {
        if(top < 0){
            minEle = x;
            a[++top] = x;
            System.out.println(x + " pushed into stack");
        }
        else if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
        }
        else {

            if(x<minEle) {
                a[++top] = 2 * x - minEle;
                minEle = x;
                System.out.println(x + " pushed into stack");
            }
            else{
                a[++top] = x;
            }

        }
    }

    int pop()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
        }
        else {
            int x = a[top--];
            if (x < minEle)
            {
                minEle = 2*minEle - x;
            }
            return x;
        }

        return 0;
    }

    int getMin() {
        if (top < 0) {
            System.out.println("Array is Empty");
        }
        return minEle;
    }
}