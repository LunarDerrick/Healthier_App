package wia2007.example.healthier_app;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExerciseFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ExerciseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExerciseFragment.
     */
    public static ExerciseFragment newInstance(String param1, String param2) {
        ExerciseFragment fragment = new ExerciseFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);

        EditText ETTargetBurn = view.findViewById(R.id.ETTargetBurn);
        EditText ETEstiBurn = view.findViewById(R.id.ETEstiBurn);
        EditText ETNameNew = view.findViewById(R.id.ETNameNew);
        EditText ETTimeNew = view.findViewById(R.id.ETTimeNew);
        Button BtnCheck = view.findViewById(R.id.BtnCheck);
        Button BtnAdd = view.findViewById(R.id.BtnAdd);
        TableLayout TLExercise = view.findViewById(R.id.TLExercise);

        // BtnCheck
        View.OnClickListener OCLCheck = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int targetValue = Integer.parseInt(ETTargetBurn.getText().toString());
                    int estimateValue = Integer.parseInt(ETEstiBurn.getText().toString());

                    if (targetValue > estimateValue) {
                        ETEstiBurn.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), R.color.red));
                    } else {
                        ETEstiBurn.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), R.color.text_green));
                    }
                } catch (NumberFormatException e) {
                    // if user haven't input anything
                    String message = "Please enter a value first!";
                    Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
                }
            }
        };
        BtnCheck.setOnClickListener(OCLCheck);

        // BtnAdd
        View.OnClickListener OCLAdd = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // fetch values from EditText
                    String newName = ETNameNew.getText().toString();
                    int newTime = Integer.parseInt(ETTimeNew.getText().toString());

                    // Create new set of TableRow to be added
                    TableRow TRExerciseNew = new TableRow(getContext());
                    TextView TVTableNameNew = new TextView(getContext());
                    TextView TVTableTimeNew = new TextView(getContext());

                    // Editing layout for 1st TextView
                    TVTableNameNew.setTextSize(14);
                    TVTableNameNew.setLayoutParams(new TableRow.LayoutParams(172,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    TVTableNameNew.setText(newName);
                    TVTableNameNew.setPadding(10, 10, 10, 10);
                    TVTableNameNew.setBackgroundResource(R.drawable.border_white);
                    TVTableNameNew.setTextColor(getResources().getColor(R.color.black));

                    // Editing layout for 2nd TextView
                    TVTableTimeNew.setTextSize(14);
                    TVTableTimeNew.setLayoutParams(new TableRow.LayoutParams(172,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    TVTableTimeNew.setText(String.format("%s", newTime));
                    TVTableTimeNew.setPadding(10, 10, 10, 10);
                    TVTableTimeNew.setBackgroundResource(R.drawable.border_white);
                    TVTableTimeNew.setTextColor(getResources().getColor(R.color.black));

                    // Add the new TextViews to the TableRow
                    TRExerciseNew.addView(TVTableNameNew);
                    TRExerciseNew.addView(TVTableTimeNew);

                    // Add the new TableRow to the TableLayout
                    TLExercise.addView(TRExerciseNew);

                } catch (NumberFormatException e) {
                    // if user haven't input anything
                    String message = "Please enter a value first!";
                    Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
                }
            }
        };
        BtnAdd.setOnClickListener(OCLAdd);

        return view;
    }
}