package com.example.jade.ui.gallery;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.jade.R;
import com.example.jade.SliderAdapter;
import com.example.jade.SliderItem;
import com.example.jade.databinding.FragmentGalleryBinding;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;
    private ViewPager2 viewPager2;
    private ViewPager2 viewPagerMemozzi;
    private ViewPager2 viewPagerNapoli;
    private ViewPager2 viewPagerMare;
    private ViewPager2 viewPagerPranzoNapoli;
    private ViewPager2 viewPagerSecondoMare;
    private ViewPager2 viewPagerAfterSex;
    private ViewPager2 viewPagerCarini;
    //AutoSlide facility
    private Handler sliderHandler = new Handler();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        loadViewPagers(root);

        return root;
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };
    @Override
    public void onPause(){
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume(){
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void loadViewPagers(View root){
        //viewPager
        viewPager2 = root.findViewById(R.id.viewPagerImageSlider);
        viewPagerMemozzi = root.findViewById(R.id.viewPagerImageSliderMemozzi);
        viewPagerNapoli = root.findViewById(R.id.viewPagerImageSliderNapoli);
        viewPagerMare = root.findViewById(R.id.viewPagerImageSliderMare);
        viewPagerPranzoNapoli = root.findViewById(R.id.viewPagerImageSliderPranzoNapoli);
        viewPagerSecondoMare = root.findViewById(R.id.viewPagerImageMare2);
        viewPagerAfterSex = root.findViewById(R.id.viewPagerAfterSex);
        viewPagerCarini = root.findViewById(R.id.viewPagerCarini);
        //Preparo lista imagini da drawable
        List<SliderItem> sliderItem = new ArrayList<>();
        sliderItem.add(new SliderItem(R.drawable.primo1));
        sliderItem.add(new SliderItem(R.drawable.primo2));
        sliderItem.add(new SliderItem(R.drawable.primo3));
        sliderItem.add(new SliderItem(R.drawable.primo4));
        sliderItem.add(new SliderItem(R.drawable.primo5));
        sliderItem.add(new SliderItem(R.drawable.primo6));
        sliderItem.add(new SliderItem(R.drawable.primo7));
        sliderItem.add(new SliderItem(R.drawable.primo8));
        sliderItem.add(new SliderItem(R.drawable.primo9));

        viewPager2.setAdapter(new SliderAdapter(sliderItem, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });
        //fine viewPager

        //viewPagerMemozzi
        List<SliderItem> sliderItemMemozzi = new ArrayList<>();
        sliderItemMemozzi.add(new SliderItem(R.drawable.memozzo1));
        sliderItemMemozzi.add(new SliderItem(R.drawable.memozzo2));
        sliderItemMemozzi.add(new SliderItem(R.drawable.memozzo3));
        sliderItemMemozzi.add(new SliderItem(R.drawable.memozzo4));
        sliderItemMemozzi.add(new SliderItem(R.drawable.memozzo5));
        sliderItemMemozzi.add(new SliderItem(R.drawable.memozzo6));
        sliderItemMemozzi.add(new SliderItem(R.drawable.memozzo7));
        sliderItemMemozzi.add(new SliderItem(R.drawable.memozzo8));
        assert viewPagerMemozzi != null;
        viewPagerMemozzi.setAdapter(new SliderAdapter(sliderItemMemozzi, viewPagerMemozzi));
        viewPagerMemozzi.setClipToPadding(false);
        viewPagerMemozzi.setClipChildren(false);
        viewPagerMemozzi.setOffscreenPageLimit(3);
        viewPagerMemozzi.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        viewPagerMemozzi.setPageTransformer(compositePageTransformer);
        viewPagerMemozzi.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });
        //fine viewPager

        //viewPager passaggiata a Napoli
        sliderItemMemozzi = new ArrayList<>();
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli2));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli3));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli4));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli5));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli6));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli7));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli8));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli9));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli10));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli11));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli12));
        sliderItemMemozzi.add(new SliderItem(R.drawable.passeggiatanapoli13));

        assert viewPagerNapoli != null;
        viewPagerNapoli.setAdapter(new SliderAdapter(sliderItemMemozzi, viewPagerNapoli));
        viewPagerNapoli.setClipToPadding(false);
        viewPagerNapoli.setClipChildren(false);
        viewPagerNapoli.setOffscreenPageLimit(3);
        viewPagerNapoli.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        viewPagerNapoli.setPageTransformer(compositePageTransformer);
        viewPagerNapoli.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });

        sliderItemMemozzi = new ArrayList<>();
        sliderItemMemozzi.add(new SliderItem(R.drawable.marevalde1));
        sliderItemMemozzi.add(new SliderItem(R.drawable.marevalde2));
        viewPagerMare.setAdapter(new SliderAdapter(sliderItemMemozzi, viewPagerMare));
        assert viewPagerMare != null;
        viewPagerMare.setClipToPadding(false);
        viewPagerMare.setClipChildren(false);
        viewPagerMare.setOffscreenPageLimit(3);
        viewPagerMare.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        viewPagerMare.setPageTransformer(compositePageTransformer);
        viewPagerMare.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });

        sliderItemMemozzi = new ArrayList<>();
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli3));
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli4));
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli5));
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli6));
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli7));
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli8));
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli9));
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli10));
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli11));
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli12));
        sliderItemMemozzi.add(new SliderItem(R.drawable.pranzonapoli13));
        viewPagerPranzoNapoli.setAdapter(new SliderAdapter(sliderItemMemozzi, viewPagerPranzoNapoli));
        viewPagerPranzoNapoli.setClipToPadding(false);
        viewPagerPranzoNapoli.setClipChildren(false);
        viewPagerPranzoNapoli.setOffscreenPageLimit(3);
        viewPagerPranzoNapoli.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        viewPagerPranzoNapoli.setPageTransformer(compositePageTransformer);
        viewPagerPranzoNapoli.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });

        sliderItemMemozzi = new ArrayList<>();
        sliderItemMemozzi.add(new SliderItem(R.drawable.secondomare1));
        sliderItemMemozzi.add(new SliderItem(R.drawable.secondomare2));
        sliderItemMemozzi.add(new SliderItem(R.drawable.secondomare3));
        viewPagerSecondoMare.setAdapter(new SliderAdapter(sliderItemMemozzi, viewPagerPranzoNapoli));
        viewPagerSecondoMare.setClipToPadding(false);
        viewPagerSecondoMare.setClipChildren(false);
        viewPagerSecondoMare.setOffscreenPageLimit(3);
        viewPagerSecondoMare.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        viewPagerSecondoMare.setPageTransformer(compositePageTransformer);
        viewPagerSecondoMare.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });

        sliderItemMemozzi = new ArrayList<>();
        sliderItemMemozzi.add(new SliderItem(R.drawable.straniaftersex1));
        sliderItemMemozzi.add(new SliderItem(R.drawable.straniaftersex2));
        sliderItemMemozzi.add(new SliderItem(R.drawable.straniaftersex3));
        sliderItemMemozzi.add(new SliderItem(R.drawable.straniaftersex4));
        sliderItemMemozzi.add(new SliderItem(R.drawable.straniaftersex5));
        sliderItemMemozzi.add(new SliderItem(R.drawable.straniaftersex6));
        sliderItemMemozzi.add(new SliderItem(R.drawable.straniaftersex7));
        sliderItemMemozzi.add(new SliderItem(R.drawable.straniaftersex8));
        viewPagerAfterSex.setAdapter(new SliderAdapter(sliderItemMemozzi, viewPagerAfterSex));
        viewPagerAfterSex.setClipToPadding(false);
        viewPagerAfterSex.setClipChildren(false);
        viewPagerAfterSex.setOffscreenPageLimit(3);
        viewPagerAfterSex.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        viewPagerAfterSex.setPageTransformer(compositePageTransformer);
        viewPagerAfterSex.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });

        sliderItemMemozzi = new ArrayList<>();
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini1));
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini2));
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini3));
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini4));
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini5));
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini6));
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini7));
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini8));
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini9));
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini10));
        sliderItemMemozzi.add(new SliderItem(R.drawable.noicarini11));
        viewPagerCarini.setAdapter(new SliderAdapter(sliderItemMemozzi, viewPagerAfterSex));
        viewPagerCarini.setClipToPadding(false);
        viewPagerCarini.setClipChildren(false);
        viewPagerCarini.setOffscreenPageLimit(3);
        viewPagerCarini.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        viewPagerCarini.setPageTransformer(compositePageTransformer);
        viewPagerCarini.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });


    }
}