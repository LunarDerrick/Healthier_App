package wia2007.example.healthier_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BMIMacroCalc#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BMIMacroCalc extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BMIMacroCalc() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BMIMacroCalc.
     */
    // TODO: Rename and change types and number of parameters
    public static BMIMacroCalc newInstance(String param1, String param2) {
        BMIMacroCalc fragment = new BMIMacroCalc();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }


    }

    EditText tinggi, berat;
    TextView result;
    Button calculate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi_macro, container, false);

        tinggi = view.findViewById(R.id.height);
        berat = view.findViewById(R.id.weight);
        result = view.findViewById(R.id.bminum);
        calculate = view.findViewById(R.id.CalcButton);

        calculate.setOnClickListener(bmi -> calculateBMI());

        return view;
    }

    private void calculateBMI() {
        String heightStr = tinggi.getText().toString();
        String weightStr = berat.getText().toString();

            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);
            float bmi = weightValue / (heightValue * heightValue);

            result.setText((int) bmi);
    }
    @Override
    public void onClick(View view) {

    }

    public void OnClickCalculate(View view) {
    }
}