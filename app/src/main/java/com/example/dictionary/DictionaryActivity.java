package com.example.dictionary;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class DictionaryActivity extends Activity {
    // Giả sử 'words' là một mảng chứa danh sách các từ trong từ điển của bạn
    String[] words = {"apple", "banana", "cherry", "date", "grape", "kiwi"};
    // ArrayAdapter sẽ giúp hiển thị dữ liệu trong ListView
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        // Tạo một ArrayAdapter để liên kết mảng 'words' với ListView trong layout
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // Thiết lập SearchView để lọc dữ liệu
        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dictionary, menu);
        return true;
    }

}
