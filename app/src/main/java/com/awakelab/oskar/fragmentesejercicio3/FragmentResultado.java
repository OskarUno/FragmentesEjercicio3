package com.awakelab.oskar.fragmentesejercicio3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.awakelab.oskar.fragmentesejercicio3.databinding.FragmentResultadoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentResultado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentResultado extends Fragment {
    private FragmentResultadoBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private boolean mParam1;
    private String mParam2;

    public FragmentResultado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentResultado.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentResultado newInstance(String param1, String param2) {
       FragmentResultado fragment = new FragmentResultado();
       Bundle args = new Bundle();
       args.putString(ARG_PARAM1, param1);
       args.putString(ARG_PARAM2, param2);
       fragment.setArguments(args);
       return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getBoolean("resultado");
            mParam2 = getArguments().getString("nombre");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = new Bundle();
        bundle.putString("nombre", mParam2);
        binding = FragmentResultadoBinding.inflate(getLayoutInflater(), container, false);
        if (mParam1) {
            binding.textRespuesta.setText("Correcto "+ mParam2);

        } else {
            binding.textRespuesta.setText("Incorrecto "+ mParam2);
        }

        binding.btnIntentalo.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_fragmentResultado_to_fragmentPregunta,bundle);
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}