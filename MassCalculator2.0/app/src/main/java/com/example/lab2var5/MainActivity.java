package com.example.lab2var5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FragmentMassConverterInput.onSomeEventListener {
    private FragmentMassConverterInput inputFragment;
    private FragmentMassConverterResult resultFragment;
    private Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClear = findViewById(R.id.buttonClear);

        inputFragment = (FragmentMassConverterInput) getSupportFragmentManager().findFragmentByTag("input_fragment");
        if (inputFragment == null) {
            inputFragment = new FragmentMassConverterInput();
        }

        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.add(R.id.fragmentContainerInput, inputFragment, "input_fragment");
        fTrans.commit();

        resultFragment = new FragmentMassConverterResult();
        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.add(R.id.fragmentContainerResult, resultFragment, "result_fragment");
        fTrans.commit();

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultFragment != null) {
                    resultFragment.clearEvent();
                    inputFragment.clearInput();
                }
            }
        });
    }

    @Override
    public void someEvent(String s) {
        FragmentMassConverterResult fragmentResult = (FragmentMassConverterResult) getSupportFragmentManager().findFragmentByTag("result_fragment");
        if (fragmentResult != null) {
            fragmentResult.displayResult(s);
        }
    }

    //    @Override
//    public void clearEvent(String s) {
//        // getSupportFragmentManager().executePendingTransactions();
//        FragmentMassConverterInput inputFragment = (FragmentMassConverterInput) getSupportFragmentManager().findFragmentByTag("input_fragment");
//
//        ((TextView) inputFragment.getView().findViewById(R.id.editTextMass)).setText((""));
//        FragmentMassConverterResult fragmentResult = (FragmentMassConverterResult) getSupportFragmentManager().findFragmentByTag("result_fragment");
//
//        //fragmentResult.displayResult("");
//
//        inputFragment.clearInput();
//
//    }

}