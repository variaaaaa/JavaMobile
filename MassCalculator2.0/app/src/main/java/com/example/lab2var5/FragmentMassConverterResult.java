package com.example.lab2var5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab2var5.databinding.FragmentMassConverterResultBinding;

public class FragmentMassConverterResult extends Fragment {
    private FragmentMassConverterResultBinding binding;

    private TextView textViewResult;
    public String result = "123";

    public void clearText(String s) {
    }

//    public interface onClearEventListener{
//        public void clearEvent(String s);
//    }

    //onClearEventListener clearEventListener;

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try {
//            clearEventListener = (onClearEventListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString()
//                    + " must implement OnConvertButtonClickListener");
//        }
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMassConverterResultBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        textViewResult = view.findViewById(R.id.textViewResult);
//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clearEventListener.clearEvent(result);
//            }
//        });
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle!= null) {
            String result = bundle.getString("result");
            textViewResult.setText(result);
        }
    }

    public void clearEvent() {
        TextView textViewResult = getView().findViewById(R.id.textViewResult);
        textViewResult.setText("");
    }

    public void displayResult(String result) {
        textViewResult.setText(result);
    }
}