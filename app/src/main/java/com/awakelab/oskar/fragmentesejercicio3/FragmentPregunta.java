package com.awakelab.oskar.fragmentesejercicio3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.awakelab.oskar.fragmentesejercicio3.databinding.FragmentPreguntaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPregunta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPregunta extends Fragment {

    private FragmentPreguntaBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentPregunta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPregunta.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPregunta newInstance(String param1, String param2) {
        FragmentPregunta fragment = new FragmentPregunta();
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
            mParam1 = getArguments().getString("nombre");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPreguntaBinding.inflate(getLayoutInflater(), container, false);
        binding.textViewHola.setText("Hola " + mParam1);

        binding.btnComprobar.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            boolean resultado = false;
            if (binding.radioGroup.getCheckedRadioButtonId() == binding.rBtnPikachu.getId()) {
                resultado = true;
            }
            bundle.putBoolean("resultado", resultado);
            bundle.putString("nombre",mParam1);
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_fragmentPregunta_to_fragmentResultado, bundle);
        });
        return binding.getRoot();
    }


}