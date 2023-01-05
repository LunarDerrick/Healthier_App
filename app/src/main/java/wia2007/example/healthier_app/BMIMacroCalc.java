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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView result, range, circle, protein, carbs, fat;
    Button calculate;
    RadioButton category, sedentary, moderate, active, gain, maintain, loss;
    RadioGroup rgal, rgmwg;

    double activityLevel, mainweightgoal;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi_macro, container, false);

        //height & weight input text
        tinggi = view.findViewById(R.id.height);
        berat = view.findViewById(R.id.weight);
        //text view
        result = view.findViewById(R.id.bminum);
        range = view.findViewById(R.id.range);
        circle = view.findViewById(R.id.Circular);
        protein = view.findViewById(R.id.protein);
        carbs = view.findViewById(R.id.carbs);
        fat = view.findViewById(R.id.fat);
        //radio button
        category = view.findViewById(R.id.WeightClass);
        moderate = view.findViewById(R.id.Moderate);
        sedentary = view.findViewById(R.id.Sedentary);
        active = view.findViewById(R.id.Active);
        gain = view.findViewById(R.id.Gain);
        maintain = view.findViewById(R.id.Maintain);
        loss = view.findViewById(R.id.Loss);
        //calculate button
        calculate = view.findViewById(R.id.CalcButton);
        //radio group
        rgal = view.findViewById(R.id.RGAL);
        rgmwg = view.findViewById(R.id.RGMWG);

        gain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rgmwg.clearCheck();
                maintain.setBackgroundResource(R.drawable.edit_text_white);
                gain.setBackgroundResource(R.drawable.edit_text_purple);
                loss.setBackgroundResource(R.drawable.edit_text_white);
                gain.setTextColor(Color.WHITE);
                maintain.setTextColor(Color.rgb(139,139,139));
                loss.setTextColor(Color.rgb(139,139,139));
                mainweightgoal = (+0.2);
            }
        });

        maintain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rgmwg.clearCheck();
                gain.setBackgroundResource(R.drawable.edit_text_white);
                maintain.setBackgroundResource(R.drawable.edit_text_purple);
                loss.setBackgroundResource(R.drawable.edit_text_white);
                maintain.setTextColor(Color.WHITE);
                gain.setTextColor(Color.rgb(139,139,139));
                loss.setTextColor(Color.rgb(139,139,139));
                mainweightgoal = 0;
            }
        });

        loss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rgmwg.clearCheck();
                maintain.setBackgroundResource(R.drawable.edit_text_white);
                loss.setBackgroundResource(R.drawable.edit_text_purple);
                gain.setBackgroundResource(R.drawable.edit_text_white);
                loss.setTextColor(Color.WHITE);
                maintain.setTextColor(Color.rgb(139,139,139));
                gain.setTextColor(Color.rgb(139,139,139));
                mainweightgoal = (-0.2);
            }
        });

        sedentary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rgal.clearCheck();
                moderate.setBackgroundResource(R.drawable.edit_text_white);
                sedentary.setBackgroundResource(R.drawable.edit_text_purple);
                active.setBackgroundResource(R.drawable.edit_text_white);
                sedentary.setTextColor(Color.WHITE);
                moderate.setTextColor(Color.rgb(139,139,139));
                active.setTextColor(Color.rgb(139,139,139));
                activityLevel = 1.2;
            }
        });

        moderate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rgal.clearCheck();
                sedentary.setBackgroundResource(R.drawable.edit_text_white);
                moderate.setBackgroundResource(R.drawable.edit_text_purple);
                active.setBackgroundResource(R.drawable.edit_text_white);
                moderate.setTextColor(Color.WHITE);
                sedentary.setTextColor(Color.rgb(139,139,139));
                active.setTextColor(Color.rgb(139,139,139));
                activityLevel = 1.5;
            }
        });

        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rgal.clearCheck();
                moderate.setBackgroundResource(R.drawable.edit_text_white);
                active.setBackgroundResource(R.drawable.edit_text_purple);
                sedentary.setBackgroundResource(R.drawable.edit_text_white);
                active.setTextColor(Color.WHITE);
                sedentary.setTextColor(Color.rgb(139,139,139));
                moderate.setTextColor(Color.rgb(139,139,139));
                activityLevel = 1.75;
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double heinput = Double.valueOf(tinggi.getText().toString());
                if (berat.getText().toString().trim().isEmpty() || tinggi.getText().toString().trim().isEmpty() || heinput <= 0){
                    Toast.makeText(requireContext(), R.string.toastError, Toast.LENGTH_SHORT).show();
                }else {
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

                    //men
                    Double men = (10 * Double.parseDouble(berat.getText().toString())) +
                            (6.25 * ((Double.parseDouble(tinggi.getText().toString())))) - (5 * 20) + 5;
                    men = men * activityLevel;
                    men = (men * mainweightgoal) + men;
                    circle.setText(String.format("%.0f", men));
                    Double pro = men * 0.2;
                    pro = pro / 4;
                    protein.setText(String.format("%.0fg", pro));
                    Double fats = men * 0.3;
                    fats = fats / 9;
                    fat.setText(String.format("%.0fg", fats));
                    Double car = men * 0.50;
                    car = car / 4;
                    carbs.setText(String.format("%.0fg", car));
                }
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}