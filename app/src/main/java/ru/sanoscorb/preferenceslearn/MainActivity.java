package ru.sanoscorb.preferenceslearn;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    EditText editText;
    Button saveButton, loadButton;
    SharedPreferences preferences;
    final String SAVED_TEXT = "saved_text";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(this);
        loadButton = findViewById(R.id.button_load);
        loadButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_save)
            saveText();
        else if (v.getId() == R.id.button_load)
            loadText();
    }

    void saveText() {
        preferences = getPreferences(MODE_PRIVATE);
        Editor ed = preferences.edit();
        ed.putString(SAVED_TEXT, editText.getText().toString());
        ed.apply();
        Toast.makeText(this, R.string.toast_save, Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        preferences = getPreferences(MODE_PRIVATE);
        String savedText = preferences.getString(SAVED_TEXT, "");
        editText.setText(savedText);
        Toast.makeText(this, R.string.toast_load, Toast.LENGTH_SHORT).show();
    }
}