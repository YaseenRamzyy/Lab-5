package model;

import java.io.*;
import java.util.*;

public class UserManager implements FileHandler {
    private final String fileName;
    private final Map<String, String> users = new HashMap<>();

    public UserManager(String fileName) {
        this.fileName = fileName;
        loadFromFile();
    }

    @Override
    public void loadFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            users.clear();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validateLogin(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}