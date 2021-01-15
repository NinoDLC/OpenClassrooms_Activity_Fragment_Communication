package fr.delcey.demoactivityrecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private static final String EXTRA_NUMBER_OF_BOOKS = "EXTRA_NUMBER_OF_BOOKS";

    private OnBookClickedListener listener;

    public static Fragment newInstance(int numberOfBooks) {

        Bundle arguments = new Bundle();
        arguments.putInt(EXTRA_NUMBER_OF_BOOKS, numberOfBooks);

        MainFragment fragment = new MainFragment();
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        listener = (OnBookClickedListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainAdapter mainAdapter = new MainAdapter(this);
        RecyclerView recyclerView = view.findViewById(R.id.main_recyclerview);
        recyclerView.setAdapter(mainAdapter);

        Button button = view.findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = generateBooks();

                mainAdapter.setData(books);
            }
        });
    }


    private List<Book> generateBooks() {
        int numberOfBooks = getArguments().getInt(EXTRA_NUMBER_OF_BOOKS, 0);

        List<Book> books = new ArrayList<>(numberOfBooks);

        for (int i = 0; i < numberOfBooks; i++) {
            books.add(
                new Book(
                    "" + numberOfBooks,
                    "Book title " + i,
                    "Book long looooooooooooooooong description that should be in multiple lines " + i
                )
            );
        }

        return books;
    }

    public void onBookClicked(Book book) {
        listener.onBookClicked(book);
    }
}
