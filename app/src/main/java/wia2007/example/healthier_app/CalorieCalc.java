package wia2007.example.healthier_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalorieCalc#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalorieCalc extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalorieCalc() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalorieCalc.
     */
    // TODO: Rename and change types and number of parameters
    public static CalorieCalc newInstance(String param1, String param2) {
        CalorieCalc fragment = new CalorieCalc();
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

    EditText calo;
    TextView brkfst, mngsnk, lnch, dnr, brminmax, msminmax, lcminmax, dnminmax, perclr;
    Button calculate;
    Spinner spinner;
    String[] mealsperday = {"3", "4"};
    int qty;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calorie, container, false);

        calculate = view.findViewById(R.id.calcButton);
        mngsnk = view.findViewById(R.id.TVMornSnack);
        lnch = view.findViewById(R.id.TVLunch);
        dnr = view.findViewById(R.id.TVDinner);
        brkfst = view.findViewById(R.id.TVBreakfast);
        brminmax = view.findViewById(R.id.TVBMinMax);
        msminmax = view.findViewById(R.id.TVMSMinMax);
        lcminmax = view.findViewById(R.id.TVLMinMax);
        dnminmax = view.findViewById(R.id.TVDMinMax);
        perclr = view.findViewById(R.id.percalories);
        calo = view.findViewById(R.id.Calories);
        spinner = view.findViewById(R.id.mealsperday);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, mealsperday);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                int number = Integer.parseInt(selected);
                qty = number;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setSelection(0);
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = calo.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(requireContext(), R.string.toastError, Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int calinput = Integer.parseInt(input);
                        if (calinput <= 0) {
                            Toast.makeText(requireContext(), R.string.toastError, Toast.LENGTH_SHORT).show();
                        } else {
                            Integer clr = Integer.parseInt(calo.getText().toString());
                            perclr.setText(String.format(" /%d kcal", clr));
                            if(qty == 3){
                                Double dmin = clr*0.25;
                                Double dn = clr*0.3;
                                Double bmin = clr*0.3;
                                Double bkf = clr*0.325;
                                Double bmax = clr*0.35;
                                Double lmin = clr*0.35;
                                Double dmax = clr*0.35;
                                Double lc = clr*0.375;
                                Double lmax = clr*0.4;
                                brkfst.setText(String.format("Breakfast\t\t\t\t\t\t%.0f kcal", bkf));
                                mngsnk.setText("Morning snack\t\t\t\t\t 0 kcal");
                                lnch.setText(String.format("Lunch\t\t\t\t\t\t%.0f kcal", lc));
                                dnr.setText(String.format("Dinner\t\t\t\t\t%.0f kcal", dn));
                                brminmax.setText(String.format("(min: %.0f, max: %.0f)", bmin, bmax));
                                msminmax.setText("(min: 0, max: 0)");
                                lcminmax.setText(String.format("(min: %.0f, max: %.0f)", lmin, lmax));
                                dnminmax.setText(String.format("(min: %.0f, max: %.0f)", dmin, dmax));
                            }
                            else if(qty == 4){
                                Double msmin = clr*0.05;
                                Double mgsk = clr*0.075;
                                Double msmax = clr*0.1;
                                Double bmin = clr*0.25;
                                Double dmin = clr*0.25;
                                Double bkf = clr*0.275;
                                Double dn = clr*0.275;
                                Double bmax = clr*0.3;
                                Double dmax = clr*0.3;
                                Double lmin = clr*0.35;
                                Double lc = clr*0.375;
                                Double lmax = clr*0.4;
                                brkfst.setText(String.format("Breakfast\t\t\t\t\t\t%.0f kcal", bkf));
                                mngsnk.setText(String.format("Morning snack\t\t\t\t\t%.0f kcal", mgsk));
                                lnch.setText(String.format("Lunch\t\t\t\t\t\t%.0f kcal", lc));
                                dnr.setText(String.format("Dinner\t\t\t\t\t%.0f kcal",dn));
                                brminmax.setText(String.format("(min: %.0f, max: %.0f)", bmin, bmax));
                                msminmax.setText(String.format("(min: %.0f, max: %.0f)", msmin, msmax));
                                lcminmax.setText(String.format("(min: %.0f, max: %.0f)", lmin, lmax));
                                dnminmax.setText(String.format("(min: %.0f, max: %.0f)", dmin, dmax));
                            }
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(requireContext(), R.string.toastError, Toast.LENGTH_SHORT).show();
                    }
                }
                /*
                Integer clr = Integer.parseInt(calo.getText().toString());
                if(qty == 3){
                    Double bkf = clr*0.325;
                    Double lc = clr*0.375;
                    Double dn = clr*0.3;
                    brkfst.setText(String.format("Breakfast\t\t\t\t\t\t%.0f kcal", bkf));
                    mngsnk.setText("Morning snack\t\t\t\t\t 0 kcal");
                    lnch.setText(String.format("Lunch\t\t\t\t\t\t%.0f kcal", lc));
                    dnr.setText(String.format("Dinner\t\t\t\t\t%.0f kcal",dn));
                }
                else if(qty == 4){
                    Double bkf = clr*0.275;
                    Double mgsk = clr*0.075;
                    Double lc = clr*0.375;
                    Double dn = clr*0.275;
                    brkfst.setText(String.format("Breakfast\t\t\t\t\t\t%.0f kcal", bkf));
                    mngsnk.setText(String.format("Morning snack\t\t\t\t\t%.0f kcal", mgsk));
                    lnch.setText(String.format("Lunch\t\t\t\t\t\t%.0f kcal", lc));
                    dnr.setText(String.format("Dinner\t\t\t\t\t%.0f kcal",dn));
                }

                 */



            }
        });


        return view;
    }
}

