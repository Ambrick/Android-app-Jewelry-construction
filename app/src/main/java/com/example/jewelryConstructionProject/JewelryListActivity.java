package com.example.jewelryConstructionProject;

import androidx.fragment.app.Fragment;

public class JewelryListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new JewelryListFragment();
    }
}