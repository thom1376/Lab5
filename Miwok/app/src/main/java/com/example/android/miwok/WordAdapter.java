package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Activity context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        TextView defaultTranslationTextView = listItemView.findViewById(R.id.default_text);
        // Get the default translation from the Word object and set this text on the name TextView
        defaultTranslationTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslationTextView = listItemView.findViewById(R.id.miwok_text);
        // Get the miwok translation from the Word object and set this text on the name TextView
        miwokTranslationTextView.setText(currentWord.getMiwokTranslation());

        return listItemView;
    }
}
