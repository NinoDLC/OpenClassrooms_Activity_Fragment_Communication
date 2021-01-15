package fr.delcey.demoactivityrecyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final MainFragment mainFragment;
    private final List<Book> books = new ArrayList<>();

    public MainAdapter(@NonNull MainFragment mainFragment) {
        this.mainFragment = mainFragment;
    }

    public void setData(List<Book> newBooks) {
        books.clear();
        books.addAll(newBooks);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mainFragment, books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final View rootView;
        private final TextView titleTextView;
        private final TextView descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rootView = itemView.findViewById(R.id.item_book_root);
            titleTextView = itemView.findViewById(R.id.item_book_title);
            descriptionTextView = itemView.findViewById(R.id.item_book_description);
        }

        public void bind(MainFragment mainFragment, @NonNull Book book) {
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainFragment.onBookClicked(book);
                }
            });
            titleTextView.setText(book.getTitle());
            descriptionTextView.setText(book.getDescription());
        }
    }
}
