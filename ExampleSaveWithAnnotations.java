package forlearn;

import forlearn.annotations.Save;
import forlearn.annotations.SaveTo;
import forlearn.annotations.Saver;

import java.io.*;

@SaveTo(path = "E:\\text.txt")
public class ExampleSaveWithAnnotations implements Serializable {
    private static final long serialVersionUID = 1L;

    @Save
    public String textField = "Rig is on windows 10 64 bit, using the blockchain driver with the 'patch' file, windows defender " +
            "and firewall have been disabled and files are in an exclusion folder";

    @Save
    public int core = 4;


    @Saver
    public void save(String path, Object... objects) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(path);
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(objects);
        }
        }

    @Override
    public String toString() {
        return "ExampleSaveWithAnnotations{" +
                "textField='" + textField + '\'' +
                ", core=" + core +
                '}';
    }

}
