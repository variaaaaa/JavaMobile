package com.example.lab2var5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.lab2var5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnOk.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                double mass = 0;

                String input = binding.editTextMass.getText().toString();
                int check = 1;
                if (binding.editTextMass.getText().toString().equals("")) {
                   Toast.makeText(MainActivity.this, "Напишите массу", Toast.LENGTH_SHORT).show(); }
                else {

                    while (check == 1) {
                        try {
                            mass = Double.parseDouble(input);
                            check = 0;
                        } catch (NumberFormatException e) {
                            Toast.makeText(MainActivity.this, "Напишите массу", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                

                int selectedRadioButtonId = binding.radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId == R.id.radioButtonCarats){
                    binding.textViewConvertedMass.setText("Граммы: " + convertCaratsToGrams(mass) + "\n" +
                            "Килограммы: " + convertCaratsToKg(mass) + "\n" +
                            "Центнеры: " + convertCaratsToCentners(mass) + "\n" +
                            "Тонны: " + convertCaratsToTons(mass) + "\n" +
                            "Фунты: " + convertCaratsToPounds(mass) + "\n" +
                            "Унции: " + convertCaratsToOunces(mass));
                } else if (selectedRadioButtonId == R.id.radioButtonGrams){
                        binding.textViewConvertedMass.setText("Караты: " + convertGramsToCarats(mass) + "\n" +
                                "Килограммы: " + convertGramsToKg(mass) + "\n" +
                                "Центнеры: " + convertGramsToCentners(mass) + "\n" +
                                "Тонны: " + convertGramsToTons(mass) + "\n" +
                                "Фунты: " + convertGramsToPounds(mass) + "\n" +
                                "Унции: " + convertGramsToOunces(mass));
                } else if (selectedRadioButtonId == R.id.radioButtonKg) {
                    binding.textViewConvertedMass.setText("Караты: " + convertKgToCarats(mass) + "\n" +
                            "Граммы: " + convertKgToGrams(mass) + "\n" +
                            "Центнеры: " + convertKgToCentners(mass) + "\n" +
                            "Тонны: " + convertKgToTons(mass) + "\n" +
                            "Фунты: " + convertKgToPounds(mass) + "\n" +
                            "Унции: " + convertKgToOunces(mass));
                } else if (selectedRadioButtonId == R.id.radioButtonCentners) {

                    binding.textViewConvertedMass.setText("Караты: " + convertCentnersToCarats(mass) + "\n" +
                            "Граммы: " + convertCentnersToGrams(mass) + "\n" +
                            "Килограммы: " + convertCentnersToKg(mass) + "\n" +
                            "Тонны: " + convertCentnersToTons(mass) + "\n" +
                            "Фунты: " + convertCentnersToPounds(mass) + "\n" +
                            "Унции: " + convertCentnersToOunces(mass));
                } else if  (selectedRadioButtonId == R.id.radioButtonTons) {
                    binding.textViewConvertedMass.setText("Караты: " + convertTonsToCarats(mass) + "\n" +
                            "Граммы: " + convertTonsToGrams(mass) + "\n" +
                            "Килограммы: " + convertTonsToKg(mass) + "\n" +
                            "Центнеры: " + convertTonsToCentners(mass) + "\n" +
                            "Фунты: " + convertTonsToPounds(mass) + "\n" +
                            "Унции: " + convertTonsToOunces(mass));
                } else if (selectedRadioButtonId == R.id.radioButtonPounds) {
                    binding.textViewConvertedMass.setText("Караты: " + convertPoundsToCarats(mass) + "\n" +
                            "Граммы: " + convertPoundsToGrams(mass) + "\n" +
                            "Килограммы: " + convertPoundsToKg(mass) + "\n" +
                            "Центнеры: " + convertPoundsToCentners(mass) + "\n" +
                            "Тонны: " + convertPoundsToTons(mass) + "\n" +
                            "Унции: " + convertPoundsToOunces(mass));
                } else if  (selectedRadioButtonId == R.id.radioButtonOunces) {
                    binding.textViewConvertedMass.setText("Караты: " + convertOuncesToCarats(mass) + "\n" +
                            "Граммы: " + convertOuncesToGrams(mass) + "\n" +
                            "Килограммы: " + convertOuncesToKg(mass) + "\n" +
                            "Центнеры: " + convertOuncesToCentners(mass) + "\n" +
                            "Тонны: " + convertOuncesToTons(mass) + "\n" +
                            "Фунты: " + convertOuncesToPounds(mass));
                } else {
                    Toast.makeText(MainActivity.this, "Выберите единицу измерения", Toast.LENGTH_SHORT).show();
                }
            }
        });
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