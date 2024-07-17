package lk.ijse;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) {
        User user = new User("Amasha Maduwanthi", 25, "madu@123");

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(user);
            System.out.println("Serialization completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            User deserializedUser = (User) ois.readObject();
            System.out.println("Deserialization completed.");
            System.out.println("Deserialized User: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}