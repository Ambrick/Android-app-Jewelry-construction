package com.example.jewelryConstructionProject;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


import java.util.UUID;

public class JewelryFragment extends Fragment {

    public static final String JEWELRY_FRAGMENT_ID = "com.example.jewelryConstructionProject";

    private Jewelry jewelry;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID newsId = (UUID)getActivity().getIntent().getSerializableExtra(JEWELRY_FRAGMENT_ID);

        jewelry = JewelryStorage.get(getActivity()).getJewelryById(newsId);
    }

    public static JewelryFragment newInstance(UUID newsId) {
        Bundle args = new Bundle();
        args.putSerializable(JEWELRY_FRAGMENT_ID, newsId);
        JewelryFragment fragment = new JewelryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_jewelry, parent, false);
        EditText TitleField = (EditText)fragmentView.findViewById(R.id.JewelryTitleTextBox);

        TitleField.setText(jewelry.getTitle());

        //Слушатель EditText
        TitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                jewelry.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        TextView vs = (TextView) fragmentView.findViewById(R.id.JewelryDateTextBox);
        vs.setText(jewelry.getDate().toString());

        CheckBox ifForExhibitionCheckBox = (CheckBox) fragmentView.findViewById(R.id.IfForExhibitionCheckBox);
        ifForExhibitionCheckBox.setChecked(jewelry.getForExhibition());

        TextView descriptionTextView = (TextView) fragmentView.findViewById(R.id.JewelryCompositionTextBox);
        descriptionTextView.setText(jewelry.getDescription());

        ifForExhibitionCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isPassed)
            {
                // Назначение флага о прошедшей новости
                jewelry.setForExhibition(isPassed);
            }
        });

        return fragmentView;
    }
}