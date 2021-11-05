package com.example.jewelryConstructionProject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

class JewelryAdapter extends ArrayAdapter<Jewelry> {
    private final JewelryListFragment jewelryListFragment;

    public JewelryAdapter(JewelryListFragment jewelryListFragment, ArrayList<Jewelry> jewelryList) {
        super(jewelryListFragment.getActivity(), 0, jewelryList);
        this.jewelryListFragment = jewelryListFragment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = jewelryListFragment.getActivity().getLayoutInflater().inflate(R.layout.fragment_jewelry_list, null);
        }

        Jewelry jewelry = getItem(position);

        TextView titleTextView = (TextView) convertView.findViewById(R.id.ListItemJewelryTitleLabel);
        titleTextView.setText(jewelry.getTitle());

        TextView dateTextView = (TextView) convertView.findViewById(R.id.ListItemJewelryDateLabel);
        dateTextView.setText(jewelry.getDate());

        CheckBox passedCheckBox = (CheckBox) convertView.findViewById(R.id.ListItemCheckBox);
        passedCheckBox.setChecked(jewelry.getForExhibition());

        return convertView;
    }
}
