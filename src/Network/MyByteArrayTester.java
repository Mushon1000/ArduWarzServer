package Network;

/**
 * Created by Shai on 31/01/2015.
 */
public class MyByteArrayTester{
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            //byte[] sendData = new byte[1024];
            MyByteArray sendData = new MyByteArray(4);

            sendData.setArrValue(0,(byte) 1);
            sendData.setArrValue(1,(byte) 2);
            sendData.setArrValue(2,(byte) 3);
            sendData.setArrValue(3,(byte) 4);
            //System.out.println(GetFirstNullIndex(sendData));
            //PrintByteArray(sendData);


            for (int i = 0; i < sendData.getLength(); i++){
                System.out.print("value at "+i+": " +sendData.getArrValue(i));
                System.out.println();
            }

            sendData.setArrValue(4,(byte) 5);
            sendData.setArrValue(5,(byte) 6);
            sendData.setArrValue(6,(byte) 7);
            sendData.PrintByteArray();

            sendData.setArrSize(2);
            System.out.println();
            sendData.PrintByteArray();

        }
}
