package com.codecool.dynamicArrayDojo;



public class DynamicIntArray {
    private int size = 1;
    private int[] array;
    private int lastIndex;

    public DynamicIntArray(int size) {
        this.size = size;
        array = new int[size];
        lastIndex = 0;
    }

    public DynamicIntArray() {
        array = new int[size];
        lastIndex = 0;
    }

    public void add(int value) {
        int[] temp = new int[size++];
        System.arraycopy(array, 0, temp, 0,array.length);
        array = temp;
        array[lastIndex++] = value;

    }
    public void remove(int value) {
        if (checkIfValueInArray(value)) {
            int[] temp = new int[array.length - 1];
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    System.arraycopy(array, 0, temp, 0, i);
                    System.arraycopy(array, i + 1, temp, i, array.length - i - 1);
                }
            }
            array = temp;
        }else{
            throw new ArrayIndexOutOfBoundsException();

        }
    }

    public void insert(int index, int value) {
        if(index > lastIndex){
            add(value);
        }else {
            insertWithArrayCopy(index, value);
        }
    }

    private void insertWithArrayCopy(int index, int value) {
        int [] temp2 = new int[array.length];
        int [] temp1 = new int[array.length+1];
        System.arraycopy(array,0,temp1,0,index);
        System.arraycopy(array,index,temp2,0,array.length-index);
        System.arraycopy(temp2,0, temp1,index+1, temp2.length-index);
        temp1[index] = value;
        lastIndex++;
        size++;

        array = temp1;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (int i : array) {
            st.append(" ").append(i);
        }
        return String.valueOf(st);
    }

    private boolean checkIfValueInArray(int value) {
        for(int number: array){
            if(value == number){
                return true;
            }
        }
        return false;
    }
}






