package com.awakelab.oskar.fragmentesejercicio3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.awakelab.oskar.fragmentesejercicio3.databinding.ActivityMainBinding;
import com.awakelab.oskar.fragmentesejercicio3.databinding.FragmentLoginBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FragmentLogin extends Fragment {
    private FragmentLoginBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentLogin() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(getLayoutInflater(), container, false);
        binding.btnComenzar.setOnClickListener(v -> {
            String nombre = binding.editTextNombre.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("nombre",nombre);
            Navigation.findNavController(getView()).navigate(R.id.action_fragmentLogin_to_fragmentPregunta, bundle);
        });
        return binding.getRoot();
    }
}