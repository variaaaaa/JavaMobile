// Generated by view binder compiler. Do not edit!
package com.example.lab2var5.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lab2var5.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMassConverterResultBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout fragmentResultContainer;

  @NonNull
  public final TextView textViewResult;

  private FragmentMassConverterResultBinding(@NonNull RelativeLayout rootView,
      @NonNull RelativeLayout fragmentResultContainer, @NonNull TextView textViewResult) {
    this.rootView = rootView;
    this.fragmentResultContainer = fragmentResultContainer;
    this.textViewResult = textViewResult;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMassConverterResultBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMassConverterResultBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_mass_converter_result, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMassConverterResultBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      RelativeLayout fragmentResultContainer = (RelativeLayout) rootView;

      id = R.id.textViewResult;
      TextView textViewResult = ViewBindings.findChildViewById(rootView, id);
      if (textViewResult == null) {
        break missingId;
      }

      return new FragmentMassConverterResultBinding((RelativeLayout) rootView,
          fragmentResultContainer, textViewResult);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
