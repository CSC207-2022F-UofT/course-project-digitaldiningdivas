package frameworks_and_drivers;
import APP_Business_Rules.DataAccessStorageInterface;

import java.io.*;

public class DataAccessStorage implements DataAccessStorageInterface {
    //Class for accessing data from a file.

    @Override
    public Object accessData(String fileName){
        //The method for accessing data.

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            Object fileData = in.readObject();

            in.close();
            file.close();

            return fileData;
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void storeData(String fileName, Object inputData){

        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(inputData);

            out.close();
            file.close();
        }
        catch (IOException ex){
            System.out.println("IOException is caught");
        }
    }
}
