// Generated by view binder compiler. Do not edit!
package com.example.jade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.jade.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.lang.NullPointerException;
import java.lang.Override;

public final class SideItemContainerBinding implements ViewBinding {
  @NonNull
  private final RoundedImageView rootView;

  @NonNull
  public final RoundedImageView imageSlide;

  private SideItemContainerBinding(@NonNull RoundedImageView rootView,
      @NonNull RoundedImageView imageSlide) {
    this.rootView = rootView;
    this.imageSlide = imageSlide;
  }

  @Override
  @NonNull
  public RoundedImageView getRoot() {
    return rootView;
  }

  @NonNull
  public static SideItemContainerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SideItemContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.side_item_container, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SideItemContainerBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    RoundedImageView imageSlide = (RoundedImageView) rootView;

    return new SideItemContainerBinding((RoundedImageView) rootView, imageSlide);
  }
}
