package com.maven.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;

/**
 * GENERIC CLASS: Generic Repository for JSON persistence TYPE PARAMETER: T
 * represents any object type ENCAPSULATION: Private fields with controlled
 * access
 */
public class JsonRepository<T> {

    private final String fileName;
    private final Gson gson;
    private final Class<T> type;

    /**
     * Constructor with file name and type
     *
     * @param fileName Path to JSON file
     * @param type Class type for JSON deserialization
     */
    public JsonRepository(String fileName, Class<T> type) {
        this.fileName = fileName;
        this.type = type;
        // Pretty print JSON for readability
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * GENERIC METHOD: Load list of items from JSON file
     *
     * @param typeToken TypeToken containing generic type information
     * @return List of items, or empty list if error occurs
     */
    public List<T> load(TypeToken<List<T>> typeToken) {
        try (Reader reader = new FileReader(fileName)) {
            List<T> data = gson.fromJson(reader, typeToken.getType());
            return data != null ? data : new ArrayList<>();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            return new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * GENERIC METHOD: Save list of items to JSON file
     *
     * @param data List of items to persist
     * @return true if successful, false otherwise
     */
    public boolean save(List<T> data) {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(data, writer);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * GENERIC METHOD: Load single item from JSON file
     *
     * @return Single item or null if file doesn't exist
     */
    public T loadSingle() {
        try (Reader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            return null;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    /**
     * GENERIC METHOD: Save single item to JSON file
     *
     * @param item Item to persist
     * @return true if successful, false otherwise
     */
    public boolean saveSingle(T item) {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(item, writer);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
            return false;
        }
    }

    /**
     * Getter for file name
     *
     * @return File name path
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Utility method: Check if file exists
     *
     * @return true if file exists, false otherwise
     */
    public boolean fileExists() {
        return new File(fileName).exists();
    }

    /**
     * Utility method: Get file size in bytes
     *
     * @return File size or -1 if file doesn't exist
     */
    public long getFileSize() {
        File file = new File(fileName);
        return file.exists() ? file.length() : -1;
    }
}
