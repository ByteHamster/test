package com.example.testmaterial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.transition.MaterialSharedAxis;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class FragmentA extends Fragment {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setEnterTransition(new MaterialSharedAxis(MaterialSharedAxis.X, true));
            setReturnTransition(new MaterialSharedAxis(MaterialSharedAxis.X, false));
            setExitTransition(new MaterialSharedAxis(MaterialSharedAxis.X, true));
            setReenterTransition(new MaterialSharedAxis(MaterialSharedAxis.X, false));
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater,
                                 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = new View(getContext());
            v.setBackgroundColor(0xffcc0000);
            v.setOnClickListener(v1 ->
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.container, new FragmentB(), "tag")
                            .addToBackStack("back")
                            .commit());
            return v;
        }
    }

    public static class FragmentB extends Fragment {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setEnterTransition(new MaterialSharedAxis(MaterialSharedAxis.X, true));
            setReturnTransition(new MaterialSharedAxis(MaterialSharedAxis.X, false));
            setExitTransition(new MaterialSharedAxis(MaterialSharedAxis.X, true));
            setReenterTransition(new MaterialSharedAxis(MaterialSharedAxis.X, false));
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater,
                                 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = new View(getContext());
            v.setBackgroundColor(0xff0000cc);
            return v;
        }
    }
}
