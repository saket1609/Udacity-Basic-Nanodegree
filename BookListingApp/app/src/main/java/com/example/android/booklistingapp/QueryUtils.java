package com.example.android.booklistingapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAKET KUMAR SINGH on 18-08-2017.
 */

class QueryUtils {

    private QueryUtils() {
    }

    public static String formatListOfAuthors(JSONArray authorsList) throws JSONException {
        String authorsListInString = null;
        if (authorsList.length() == 0) {
            return null;
        }
        for (int i = 0; i < authorsList.length(); i++) {
            if (i == 0) {
                authorsListInString = authorsList.getString(0);
            } else {
                authorsListInString += ", " + authorsList.getString(i);
            }
        }
        return authorsListInString;
    }

    public static List<Book> extractBooks(String json) {
        List<Book> books = new ArrayList<>();
        try {
            JSONObject jsonResponse = new JSONObject(json);
            if (jsonResponse.getInt("totalItems") == 0) {
                return books;
            }
            JSONArray jsonArray = jsonResponse.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject bookObject = jsonArray.getJSONObject(i);
                JSONObject bookInfo = bookObject.getJSONObject("volumeInfo");
                String title = bookInfo.getString("title");
                if (bookInfo.has("authors")) {
                    JSONArray authorsArray = bookInfo.getJSONArray("authors");
                    String authors = formatListOfAuthors(authorsArray);
                    Book book = new Book(authors, title);
                    books.add(book);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return books;
    }
}
