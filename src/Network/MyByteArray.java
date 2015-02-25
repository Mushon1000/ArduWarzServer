package Network;

/**
 * Created by Shai on 31/01/2015.
 */
public class MyByteArray {


    private byte[] array;
    private int size;
    private static int currentSize;

    public MyByteArray(int cap) {
        array = new byte[cap];
        currentSize = cap;
        size = 0;
    }

    public int getArrValue(int pos) {
        if (pos>=size) throw new ArrayIndexOutOfBoundsException();
        return array[pos];
    }


    public void fillArray (String str){
        int arraySize = str.split(",").length;

        setArrSize(arraySize);
        for (int i=0;i<arraySize;i++){
            setArrValue(i, str.split(",")[i].getBytes()[0]);
        }

    }
    public void setArrValue(int pos, byte val) {
        if (pos>=size) {
            if (pos>=array.length) {
                byte[] newarray = new byte[(pos+1)*5/4];
                //byte[] newarray = new byte[(pos+1)];
                System.arraycopy(array, 0, newarray, 0, size);
                array = newarray;
            }
            size = pos+1;
            currentSize = size;
        }
        array[pos] = val;
    }


    public void setArrSize(int size){
        byte[] newarray = new byte[size];
        System.arraycopy(array, 0, newarray, 0, size);
        array = newarray;
    }

    public void PrintByteArray(){
        for (int i=0;i<array.length; i++){
            System.out.print(array[i]+",");
        }
    }

    public int getLength(){
        return currentSize;
    }

    public byte[] getArrayAsByteArray(){
        return array;
    }

}
