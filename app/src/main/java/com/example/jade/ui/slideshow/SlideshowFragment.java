package com.example.jade.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.jade.R;
import com.example.jade.databinding.FragmentSlideshowBinding;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Random;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;
    private String[] linee;
    {
        linee = new String[9];
        try{
            InputStream in = getContext().getAssets().open("Motivi.txt");
            LineNumberReader lin = new LineNumberReader(new InputStreamReader(in));
            String line;
            int i = 0;
            while ((line = lin.readLine()) != null){
                linee[i] = line;
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button buttonF = (Button)root.findViewById(R.id.button);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               generaMotivo(root);
            }
        });

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void generaMotivo(View view){


        TextView tw = binding.textSlideshow;
        Random random = new Random();
        int n = random.nextInt(linee.length);
        System.out.println("Numero random generato: " + n);
        System.out.println("math random da: " + linee[n]);
        tw.setText(linee[n]);
        for(int i = 0; i < linee.length; i++){
            System.out.println("Linea x: " + linee[i]);
        }
    }

}