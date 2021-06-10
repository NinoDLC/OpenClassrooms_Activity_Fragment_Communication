package fr.delcey.demoactivityrecyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnBookClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
            .replace(
                R.id.main_fragment_container,
                MainFragment.newInstance(15)
            )
            .commitNow();
    }

    @Override
    public void onBookClicked(@NonNull Book book) {
        startActivity(DetailActivity.navigate(this, book));
    }
}