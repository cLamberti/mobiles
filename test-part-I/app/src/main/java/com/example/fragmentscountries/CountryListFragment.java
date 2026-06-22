package com.example.fragmentscountries;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CountryListFragment extends Fragment {

    public interface OnCountrySelectedListener {
        void onCountrySelected(Country country);
    }

    private OnCountrySelectedListener listener;
    private List<Country> countries;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnCountrySelectedListener) {
            listener = (OnCountrySelectedListener) context;
        } else {
            throw new RuntimeException(context + " must implement OnCountrySelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);

        countries = buildCountryList();

        List<String> names = new ArrayList<>();
        for (Country c : countries) names.add(c.getName());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                R.layout.item_country,
                names
        );

        ListView listView = view.findViewById(R.id.list_countries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, v, position, id) -> {
            if (listener != null) {
                listener.onCountrySelected(countries.get(position));
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private List<Country> buildCountryList() {
        List<Country> list = new ArrayList<>();
        list.add(new Country("Costa Rica",   "San José",          "5.1 millones",   "Español",    "Colón costarricense", "América Central"));
        list.add(new Country("México",       "Ciudad de México",  "128 millones",   "Español",    "Peso mexicano",       "América del Norte"));
        list.add(new Country("España",       "Madrid",            "47.4 millones",  "Español",    "Euro",                "Europa"));
        list.add(new Country("Francia",      "París",             "67.9 millones",  "Francés",    "Euro",                "Europa"));
        list.add(new Country("Argentina",    "Buenos Aires",      "45.4 millones",  "Español",    "Peso argentino",      "América del Sur"));
        list.add(new Country("Brasil",       "Brasilia",          "215 millones",   "Portugués",  "Real brasileño",      "América del Sur"));
        list.add(new Country("Colombia",     "Bogotá",            "51.8 millones",  "Español",    "Peso colombiano",     "América del Sur"));
        list.add(new Country("Chile",        "Santiago",          "19.5 millones",  "Español",    "Peso chileno",        "América del Sur"));
        list.add(new Country("Perú",         "Lima",              "33.4 millones",  "Español",    "Sol peruano",         "América del Sur"));
        list.add(new Country("Japón",        "Tokio",             "125.7 millones", "Japonés",    "Yen japonés",         "Asia"));
        return list;
    }
}
