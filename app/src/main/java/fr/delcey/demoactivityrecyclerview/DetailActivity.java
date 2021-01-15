package fr.delcey.demoactivityrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_BOOK = "EXTRA_BOOK";

    public static Intent navigate(Context context, Book book) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_BOOK, book);

        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_activity);

        Book book = (Book) getIntent().getSerializableExtra(EXTRA_BOOK);

        TextView title = findViewById(R.id.book_title);
        title.setText(book.getTitle());
    }
}
