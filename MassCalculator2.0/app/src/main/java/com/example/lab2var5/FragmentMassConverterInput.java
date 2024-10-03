package com.example.lab2var5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab2var5.databinding.FragmentMassConverterInputBinding;

public class FragmentMassConverterInput extends Fragment {

    private FragmentMassConverterInputBinding binding;
    public String result = "";
    private EditText editTextMass;
    private RadioGroup radioGroup;
    private Button buttonConvert;

    public interface onSomeEventListener{
        public void someEvent(String s);
    }

    onSomeEventListener someEventListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            someEventListener = (onSomeEventListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnConvertButtonClickListener");
        }
    }

    public void clearInput() {
        editTextMass.setText("");
        radioGroup.clearCheck();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMassConverterInputBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        editTextMass = view.findViewById(R.id.editTextMass);
        radioGroup = view.findViewById(R.id.radio_group);
        buttonConvert = view.findViewById(R.id.buttonConvert);
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mass = 0;
                String input = binding.editTextMass.getText().toString();
                int check = 1;
                if (binding.editTextMass.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Напишите массу", Toast.LENGTH_SHORT).show();
                } else {
                    while (check == 1) {
                        try {
                            mass = Double.parseDouble(input);
                            check = 0;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Напишите массу", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
                int selectedRadioButtonId = binding.radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId == R.id.radio_button_carats){
                    result = "Граммы: " + convertCaratsToGrams(mass) + "\n" +
                            "Килограммы: " + convertCaratsToKg(mass) + "\n" +
                            "Центнеры: " + convertCaratsToCentners(mass) + "\n" +
                            "Тонны: " + convertCaratsToTons(mass) + "\n" +
                            "Фунты: " + convertCaratsToPounds(mass) + "\n" +
                            "Унции: " + convertCaratsToOunces(mass);
                } else if (selectedRadioButtonId == R.id.radio_button_grams){
                    result = "Караты: " + convertGramsToCarats(mass) + "\n" +
                            "Килограммы: " + convertGramsToKg(mass) + "\n" +
                            "Центнеры: " + convertGramsToCentners(mass) + "\n" +
                            "Тонны: " + convertGramsToTons(mass) + "\n" +
                            "Фунты: " + convertGramsToPounds(mass) + "\n" +
                            "Унции: " + convertGramsToOunces(mass);
                } else if (selectedRadioButtonId == R.id.radio_button_kg) {
                    result = "Караты: " + convertKgToCarats(mass) + "\n" +
                            "Граммы: " + convertKgToGrams(mass) + "\n" +
                            "Центнеры: " + convertKgToCentners(mass) + "\n" +
                            "Тонны: " + convertKgToTons(mass) + "\n" +
                            "Фунты: " + convertKgToPounds(mass) + "\n" +
                            "Унции: " + convertKgToOunces(mass);
                } else if (selectedRadioButtonId == R.id.radio_button_centners) {
                    result = "Караты: " + convertCentnersToCarats(mass) + "\n" +
                            "Граммы: " + convertCentnersToGrams(mass) + "\n" +
                            "Килограммы: " + convertCentnersToKg(mass) + "\n" +
                            "Тонны: " + convertCentnersToTons(mass) + "\n" +
                            "Фунты: " + convertCentnersToPounds(mass) + "\n" +
                            "Унции: " + convertCentnersToOunces(mass);
                } else if  (selectedRadioButtonId == R.id.radio_button_tons) {
                    result = "Караты: " + convertTonsToCarats(mass) + "\n" +
                            "Граммы: " + convertTonsToGrams(mass) + "\n" +
                            "Килограммы: " + convertTonsToKg(mass) + "\n" +
                            "Центнеры: " + convertTonsToCentners(mass) + "\n" +
                            "Фунты: " + convertTonsToPounds(mass) + "\n" +
                            "Унции: " + convertTonsToOunces(mass);
                } else if (selectedRadioButtonId == R.id.radio_button_pounds) {
                    result = "Караты: " + convertPoundsToCarats(mass) + "\n" +
                            "Граммы: " + convertPoundsToGrams(mass) + "\n" +
                            "Килограммы: " + convertPoundsToKg(mass) + "\n" +
                            "Центнеры: " + convertPoundsToCentners(mass) + "\n" +
                            "Тонны: " + convertPoundsToTons(mass) + "\n" +
                            "Унции: " + convertPoundsToOunces(mass);
                } else if  (selectedRadioButtonId == R.id.radio_button_ounces) {
                    result = "Караты: " + convertOuncesToCarats(mass) + "\n" +
                            "Граммы: " + convertOuncesToGrams(mass) + "\n" +
                            "Килограммы: " + convertOuncesToKg(mass) + "\n" +
                            "Центнеры: " + convertOuncesToCentners(mass) + "\n" +
                            "Тонны: " + convertOuncesToTons(mass) + "\n" +
                            "Фунты: " + convertOuncesToPounds(mass);
                } else {
                    Toast.makeText(getActivity(), "Выберите единицу измерения", Toast.LENGTH_SHORT).show();
                };
                someEventListener.someEvent(result);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String result = bundle.getString("result");
            editTextMass.setText(result);
        }

    }


    private double convertCaratsToGrams(double carats) {
        return carats * 0.2;
    }

    private double convertGramsToCarats(double grams) {
        return grams / 0.2;
    }

    private double convertKgToCarats(double kg) {
        return kg * 5000;
    }

    private double convertCaratsToKg(double carats) {
        return carats / 5000;
    }

    private double convertCaratsToCentners(double carats) {
        return carats / 50;
    }

    private double convertCentnersToCarats(double centners) {
        return centners * 50;
    }

    private double convertCaratsToTons(double carats) {
        return carats / 500000;
    }

    private double convertTonsToCarats(double tons) {
        return tons * 500000;
    }

    private double convertCaratsToPounds(double carats) {
        return carats * 0.000220462;
    }

    private double convertPoundsToCarats(double pounds) {
        return pounds / 0.000220462;
    }

    private double convertCaratsToOunces(double carats) {
        return carats * 0.00705479;
    }

    private double convertOuncesToCarats(double ounces) {
        return ounces / 0.00705479;
    }

    private double convertGramsToCentners(double grams) {
        return grams / 100;
    }

    private double convertCentnersToGrams(double centners) {
        return centners * 100;
    }

    private double convertGramsToKg(double grams) {
        return grams / 1000;
    }

    private double convertKgToGrams(double kg) {
        return kg * 1000;
    }

    private double convertGramsToTons(double grams) {
        return grams / 1000000;
    }

    private double convertTonsToGrams(double tons) {
        return tons * 1000000;
    }

    private double convertGramsToPounds(double grams) {
        return grams * 0.00220462;
    }

    private double convertPoundsToGrams(double pounds) {
        return pounds / 0.00220462;
    }

    private double convertGramsToOunces(double grams) {
        return grams * 0.0352739619;
    }

    private double convertOuncesToGrams(double ounces) {
        return ounces / 0.0352739619;
    }

    private double convertKgToCentners(double kg) {
        return kg / 100;
    }

    private double convertCentnersToKg(double centners) {
        return centners * 100;
    }

    private double convertKgToTons(double kg) {
        return kg / 1000;
    }

    private double convertTonsToKg(double tons) {
        return tons * 1000;
    }

    private double convertKgToPounds(double kg) {
        return kg * 2.20462;
    }

    private double convertPoundsToKg(double pounds) {
        return pounds / 2.20462;
    }

    private double convertKgToOunces(double kg) {
        return kg * 35.2739619;
    }

    private double convertOuncesToKg(double ounces) {
        return ounces / 35.2739619;
    }

    private double convertCentnersToTons(double centners) {
        return centners / 100;
    }

    private double convertTonsToCentners(double tons) {
        return tons * 100;
    }

    private double convertCentnersToPounds(double centners) {
        return centners * 220.462;
    }

    private double convertPoundsToCentners(double pounds) {
        return pounds / 220.462;
    }

    private double convertCentnersToOunces(double centners) {
        return centners * 3527.39619;
    }

    private double convertOuncesToCentners(double ounces) {
        return ounces / 3527.39619;
    }

    private double convertTonsToPounds(double tons) {
        return tons * 2204.62;
    }

    private double convertPoundsToTons(double pounds) {
        return pounds / 2204.62;
    }

    private double convertTonsToOunces(double tons) {
        return tons * 35273.9619;
    }

    private double convertOuncesToTons(double ounces) {
        return ounces / 35273.9619;
    }

    private double convertPoundsToOunces(double pounds) {
        return pounds * 16;
    }

    private double convertOuncesToPounds(double ounces) {
        return ounces / 16;
    }
}

