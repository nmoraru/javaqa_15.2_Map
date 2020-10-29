package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
public class FileOpenManager {
    HashMap<String, String> maps = new HashMap<>();

    public HashMap<String, String> getMaps() {
        return maps;
    }

    public void addApp(String file, String app) {
        maps.put(file, app);
    }

    public String getApp(String app) {
        return maps.get(app);
    }

    public void removeApp(String app) {
        maps.remove(app);
    }

    public List<String> getAllKeys() {
        Comparator byAlphabet = Comparator.naturalOrder();
        Set<String> keys = new HashSet<>();
        keys.addAll(maps.keySet());
        ArrayList<String> listFiles = new ArrayList<>(keys);
        listFiles.sort(byAlphabet);
        return listFiles;
    }

    public List<String> getAllValues() {
        Comparator byAlphabet = Comparator.naturalOrder();
        Set<String> apps = new HashSet<>();
        apps.addAll(maps.values());
        ArrayList<String> listFiles = new ArrayList<>(apps);
        listFiles.sort(byAlphabet);
        return listFiles;
    }
}
