package com.example.jewelryConstructionProject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class JewelryListFragment extends ListFragment {

    private ArrayList<Jewelry> jewelryArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jewelryArrayList = JewelryStorage.get(getActivity()).getJewelryList();
        //Initialize our own adapter
        JewelryAdapter adapter = new JewelryAdapter(this, jewelryArrayList);
        setListAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((JewelryAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Jewelry c = ((JewelryAdapter)getListAdapter()).getItem(position);
        Intent i = new Intent(getActivity(), MainActivity.class);
        i.putExtra(JewelryFragment.JEWELRY_FRAGMENT_ID, c.getId());
        startActivity(i);
    }

}

