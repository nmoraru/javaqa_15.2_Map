package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();

    private String html = "html";
    private String keyByUpperCase = "HTML";
    private String jpeg = "jpeg";
    private String xls = "xls";
    private String pdf = "pdf";

    private String google = "Google";
    private String imageViewer = "Image viewer";
    private String excel = "Microsoft Excel";
    private String pdfReader = "Adobe Acrobat Reader";

    @BeforeEach
    void setup() {
        manager = new FileOpenManager();
        manager.addApp(html, google);
        manager.addApp(jpeg, imageViewer);
        manager.addApp(xls, excel);
    }

    @Test
    void shouldGetAllApps() {
        HashMap<String, String> expected = new HashMap<>(Map.of(html, google, xls, excel, jpeg, imageViewer));
        HashMap<String, String> actual = manager.getMaps();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetOneApp() {
        String expected = google;
        String actual = manager.getApp(html);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveKey() {
        manager.removeApp(xls);
        HashMap<String, String> expected = new HashMap<>(Map.of(html, google, jpeg, imageViewer));
        HashMap<String, String> actual = manager.getMaps();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAllKeysSorted() {
        manager.addApp(html, google);
        manager.addApp(xls, excel);
        manager.addApp(jpeg, imageViewer);
        List<String> expected = new ArrayList<>(List.of(html, jpeg, xls));
        List<String> actual = manager.getAllKeys();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAllValuesSorted() {
        manager.addApp(html, google);
        manager.addApp(xls, excel);
        manager.addApp(jpeg, imageViewer);
        List<String> expected = new ArrayList<>(List.of(google, imageViewer, excel));
        List<String> actual = manager.getAllValues();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullForInvalidKey() {
        String expected = null;
        String actual = manager.getApp(pdf);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullForKeyByUpperCase() {
        String expected = null;
        String actual = manager.getApp(keyByUpperCase);
        assertEquals(expected, actual);
    }
}
