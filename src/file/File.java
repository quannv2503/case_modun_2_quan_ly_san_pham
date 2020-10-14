package file;

import service.ListData;

import java.io.*;
import java.util.ArrayList;

public class File {
    public static void outPut() {
        ArrayList<ArrayList> lists = new ArrayList<>();
        lists.add(ListData.getCustomers());
        lists.add(ListData.getProducts());
        lists.add(ListData.getBills());
        lists.add(ListData.getStatisticals());
        try {
            FileOutputStream fos = new FileOutputStream("file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lists);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList inPut() {
        ArrayList arrayList = null;
        try {
            FileInputStream fis = new FileInputStream("file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arrayList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
