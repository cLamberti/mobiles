package com.example.fragmentscountries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CountryDetailFragment extends Fragment {

    private static final String KEY_NAME       = "name";
    private static final String KEY_CAPITAL    = "capital";
    private static final String KEY_POPULATION = "population";
    private static final String KEY_LANGUAGE   = "language";
    private static final String KEY_CURRENCY   = "currency";
    private static final String KEY_CONTINENT  = "continent";

    public static CountryDetailFragment newInstance(Country country) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        Bundle args = new Bundle();
        args.putString(KEY_NAME,       country.getName());
        args.putString(KEY_CAPITAL,    country.getCapital());
        args.putString(KEY_POPULATION, country.getPopulation());
        args.putString(KEY_LANGUAGE,   country.getLanguage());
        args.putString(KEY_CURRENCY,   country.getCurrency());
        args.putString(KEY_CONTINENT,  country.getContinent());
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_detail, container, false);

        Bundle args = getArguments();
        if (args != null) {
            setText(view, R.id.tv_name,       args.getString(KEY_NAME));
            setText(view, R.id.tv_capital,    getString(R.string.label_capital)    + args.getString(KEY_CAPITAL));
            setText(view, R.id.tv_population, getString(R.string.label_population) + args.getString(KEY_POPULATION));
            setText(view, R.id.tv_language,   getString(R.string.label_language)   + args.getString(KEY_LANGUAGE));
            setText(view, R.id.tv_currency,   getString(R.string.label_currency)   + args.getString(KEY_CURRENCY));
            setText(view, R.id.tv_continent,  getString(R.string.label_continent)  + args.getString(KEY_CONTINENT));
        }

        return view;
    }

    private void setText(View root, int id, String text) {
        ((TextView) root.findViewById(id)).setText(text);
    }
}
