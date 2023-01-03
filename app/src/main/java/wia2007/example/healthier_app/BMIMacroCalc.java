package wia2007.example.healthier_app;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButtonToggleGroup;
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
    TextView result, range, circle;
    Button calculate, sedentary;
    RadioButton category;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi_macro, container, false);

        tinggi = view.findViewById(R.id.height);
        berat = view.findViewById(R.id.weight);
        result = view.findViewById(R.id.bminum);
        range = view.findViewById(R.id.range);
        category = view.findViewById(R.id.WeightClass);
        calculate = view.findViewById(R.id.CalcButton);
        sedentary = view.findViewById(R.id.Sedentary);
        circle = view.findViewById(R.id.Circular);

                sedentary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String test = sedentary.getText().toString();
                        sedentary.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(84,101, 255)));
                        sedentary.setTextColor(Color.WHITE);
                        circle.setText("1500");
                    }
                });


                calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double test = Double.parseDouble(berat.getText().toString()) /
                                ((Double.parseDouble(tinggi.getText().toString()) / 100) * (Double.parseDouble(tinggi.getText().toString()) / 100));
                        result.setText(String.format("%.1f", test));
                        Integer heig = Integer.parseInt(tinggi.getText().toString());

                        if (test < 18.5) {
                            category.setText("Underweight");
                            category.setTextColor(Color.BLUE);
                            category.setButtonTintList(ColorStateList.valueOf(Color.BLUE));
                        } else if (test >= 18.5 && test < 25) {
                            category.setText("Normal");
                            category.setTextColor(Color.GREEN);
                            category.setButtonTintList(ColorStateList.valueOf(Color.GREEN));
                        } else if (test >= 25 && test < 30) {
                            category.setText("Overweight");
                            category.setTextColor(Color.rgb(255, 200, 0));
                            category.setButtonTintList(ColorStateList.valueOf(Color.rgb(255, 200, 0)));
                        } else if (test >= 30) {
                            category.setText("Obese");
                            category.setTextColor(Color.RED);
                            category.setButtonTintList(ColorStateList.valueOf(Color.RED));
                        }

                        if (heig < 150) {
                            range.setText("Your healthy weight range: 37-50kg");
                        } else if (heig >= 150 && heig < 160) {
                            range.setText("Your healthy weight range: 43-58kg");
                        } else if (heig >= 160 && heig < 170) {
                            range.setText("Your healthy weight range: 49-65kg");
                        } else if (heig >= 170 && heig < 180) {
                            range.setText("Your healthy weight range: 55-74kg");
                        } else if (heig >= 180 && heig <= 190) {
                            range.setText("Your healthy weight range: 62-82kg");
                        } else if (heig > 190) {
                            range.setText("Your healthy weight range: 72-96kg");
                        }


                    }
                });

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}